using System;
using System.Collections.Generic;
using Archer.Sapka.Client;
using Archer.Sapka.Parser.Ast;
using Tao.Lua;

namespace Archer.Sapka.Bot
{
	public class BotAI : IDisposable
	{
		private readonly SapkaClient _client;
		private IntPtr _lua;
		private readonly Dictionary<string, Lua.lua_CFunction> _delegates = new Dictionary<string,Lua.lua_CFunction>();

		public BotAI(SapkaClient client)
		{
			if(client == null)
				throw new ArgumentNullException("client");

			_client = client;
			var disp = client.PacketDispatcher;

			disp.GameStarted += new EventHandler<SapkaGameEventArgs>(Dispatcher_GameStarted);
			disp.RoundStarted += new EventHandler<SapkaGameEventArgs>(Dispatcher_RoundStarted);
			disp.MapChanged += new EventHandler<MapChangeEventArgs>(Dispatcher_MapChanged);
			disp.RoundEnded += new EventHandler<SapkaFinishRoundEventArgs>(Dispatcher_RoundEnded);
			disp.GameEnded += new EventHandler<SapkaFinishGameEventArgs>(Dispatcher_GameEnded);
		}

		public bool NeedsVisualizer { get; private set; }

		#region IDisposable Members

		public void Dispose()
		{
			Dispose(true);
			GC.SuppressFinalize(this);
		}

		~BotAI()
		{
			Dispose(false);
		}

		private void Dispose(bool disposing)
		{
			if(disposing)
			{
				if(_lua != IntPtr.Zero)
				{
					Lua.lua_close(_lua);
					_lua = IntPtr.Zero;
				}
			}
		}

		#endregion

		#region Dispatcher event handlers

		private void Dispatcher_GameStarted(object sender, SapkaGameEventArgs e)
		{
			OnGameStarted((SapkaClient)sender, e);
		}

		private void Dispatcher_RoundStarted(object sender, SapkaGameEventArgs e)
		{
			OnRoundStarted((SapkaClient)sender, e);
		}

		private void Dispatcher_MapChanged(object sender, MapChangeEventArgs e)
		{
			OnMapChanged((SapkaClient)sender, e);
		}

		private void Dispatcher_RoundEnded(object sender, SapkaFinishRoundEventArgs e)
		{
			OnRoundEnded((SapkaClient)sender, e);
		}

		private void Dispatcher_GameEnded(object sender, SapkaFinishGameEventArgs e)
		{
			OnGameEnded((SapkaClient)sender, e);
		}

		#endregion

		#region Lua bindings

		public bool Load(string fileName)
		{
			_lua = Lua.luaL_newstate();
			Lua.luaL_openlibs(_lua);

			int s = Lua.luaL_loadfile(_lua, fileName);
			if(s != 0)
				return ReportLuaErrors(_lua, s);

			s = Lua.lua_pcall(_lua, 0, 0, 0);
			if(s != 0)
				return ReportLuaErrors(_lua, s);

			RegisterBotApi();
			BindBotToEvents();
			HandleBotConfig();
			return true;
		}

		public void Activate()
		{
			luacall("on_connected");
		}

		private static bool ReportLuaErrors(IntPtr ctx, int status)
		{
			if(status == 0)
				return true;
			Console.WriteLine("! {0}", Lua.lua_tostring(ctx, -1));
			Lua.lua_pop(ctx, 1);
			return false;
		}

		private void RegisterBotApi()
		{
			Lua.lua_register(_lua, "launch", luawrap2(api_launch));
			Lua.lua_register(_lua, "move_left", luawrapb(api_move_left));
			Lua.lua_register(_lua, "move_right", luawrapb(api_move_right));
			Lua.lua_register(_lua, "move_up", luawrapb(api_move_up));
			Lua.lua_register(_lua, "move_down", luawrapb(api_move_down));
			Lua.lua_register(_lua, "engine_stop", luawrapb(api_engine_stop));
		}

		private void BindBotToEvents()
		{
		}

		private void HandleBotConfig()
		{
			var filename = luaget("LOGFILE");
			if(!string.IsNullOrEmpty(filename))
				_client.LogTo(filename);

			NeedsVisualizer = luagetb("VISUALIZER");
		}

		private string luaget(string name)
		{
			string value = null;
			Lua.lua_getglobal(_lua, name);
			if(Lua.lua_isstring(_lua, -1) != 0)
				value = Lua.lua_tostring(_lua, -1);
			else
				Lua.lua_pop(_lua, -1);
			return value;
		}

		private bool luagetb(string name)
		{
			bool value = false;
			Lua.lua_getglobal(_lua, name);
			if(Lua.lua_isboolean(_lua, -1))
				value = Lua.lua_toboolean(_lua, -1) != 0;
			else
				Lua.lua_pop(_lua, -1);
			return value;
		}

		#region luacall

		private void luacall(string handler)
		{
			Lua.lua_getglobal(_lua, handler);
			if(Lua.lua_isfunction(_lua, -1))
			{
				Lua.lua_call(_lua, 0, 0);
			}
			else
			{
				Lua.lua_pop(_lua, -1);
			}
		}

		private void luacall(string handler, int value)
		{
			luacall(handler, 1, delegate()
			{
				Lua.lua_pushinteger(_lua, value);
			});
		}

		private void luacall(string handler, int nargs, Action pushargs)
		{
			Lua.lua_getglobal(_lua, handler);
			if(Lua.lua_isfunction(_lua, -1))
			{
				pushargs();
				Lua.lua_call(_lua, nargs, 0);
			}
			else
			{
				Lua.lua_pop(_lua, -1);
			}
		}

		#endregion

		#region luawrap

		private Lua.lua_CFunction luawrap(Action action)
		{
			var d = (Lua.lua_CFunction)delegate(IntPtr L)
			{
				action();
				return 0;
			};
			_delegates[action.Method.Name] = d;
			return d;
		}

		private Lua.lua_CFunction luawrap1(Action<string> action)
		{
			var d = (Lua.lua_CFunction)delegate(IntPtr L)
			{
				int argc = Lua.lua_gettop(L);
				string value = argc > 0 ? Lua.lua_tostring(L, 1) : string.Empty;
				action(value);
				return 0;
			};
			_delegates[action.Method.Name] = d;
			return d;
		}

		private Lua.lua_CFunction luawrapb(Action<bool> action)
		{
			var d = (Lua.lua_CFunction)delegate(IntPtr L)
			{
				int argc = Lua.lua_gettop(L);
				bool value = argc > 0 ? Lua.lua_toboolean(L, 1) != 0 : false;
				action(value);
				return 0;
			};
			_delegates[action.Method.Name] = d;
			return d;
		}

		private Lua.lua_CFunction luawrap2(Action<string, string> action)
		{
			var d = (Lua.lua_CFunction)delegate(IntPtr L)
			{
				int argc = Lua.lua_gettop(L);
				string a = argc > 0 ? Lua.lua_tostring(L, 1) : string.Empty;
				string b = argc > 1 ? Lua.lua_tostring(L, 2) : string.Empty;
				action(a, b);
				return 0;
			};
			_delegates[action.Method.Name] = d;
			return d;
		}

		#endregion

		#region luapush

		private void luapush(int value)
		{
			Lua.lua_pushinteger(_lua, value);
		}

		private void luapush(RankScoreNode score)
		{
			Lua.lua_newtable(_lua);
			foreach(var p in score)
			{
				Lua.lua_pushinteger(_lua, p.Id);

				Lua.lua_newtable(_lua);
				Lua.lua_pushstring(_lua, "rank");
				Lua.lua_pushinteger(_lua, p.Rank);
				Lua.lua_rawset(_lua, -3);
				Lua.lua_pushstring(_lua, "score");
				Lua.lua_pushinteger(_lua, p.Score);
				Lua.lua_rawset(_lua, -3);

				Lua.lua_rawset(_lua, -3);
			}
		}

		private void luapush(MapInfoNode map)
		{
			Lua.lua_newtable(_lua);
			Lua.lua_pushstring(_lua, "cellsize");
			Lua.lua_pushinteger(_lua, map.CellSize);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "rows");
			Lua.lua_newtable(_lua);
			int rowId = 0;
			foreach(var row in map.Map)
			{
				Lua.lua_pushinteger(_lua, rowId++);
				Lua.lua_newtable(_lua);
				int itemId = 0;
				foreach(var i in row)
				{
					Lua.lua_pushinteger(_lua, itemId++);
					Lua.lua_pushstring(_lua, i.ToString());
					Lua.lua_rawset(_lua, -3);
				}
				Lua.lua_rawset(_lua, -3);
			}
			Lua.lua_rawset(_lua, -3);
		}

		private void luapush(PlayerInfoNode player)
		{
			Lua.lua_newtable(_lua);

			Lua.lua_pushstring(_lua, "id");
			Lua.lua_pushinteger(_lua, player.Id);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "x");
			Lua.lua_pushinteger(_lua, player.X);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "y");
			Lua.lua_pushinteger(_lua, player.Y);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "speed");
			Lua.lua_pushinteger(_lua, player.Speed);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "bombs");
			Lua.lua_pushinteger(_lua, player.Bombs);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "strength");
			Lua.lua_pushinteger(_lua, player.BombStrength);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "dead");
			Lua.lua_pushboolean(_lua, player.IsDead ? 1 : 0);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "infected");
			Lua.lua_pushboolean(_lua, player.IsInfected ? 1 : 0);
			Lua.lua_rawset(_lua, -3);
		}

		private void luapush(MapItemNode item)
		{
			Lua.lua_newtable(_lua);

			Lua.lua_pushstring(_lua, "icon");
			Lua.lua_pushstring(_lua, "" + item.Icon);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "x");
			Lua.lua_pushinteger(_lua, item.Cell.X);
			Lua.lua_rawset(_lua, -3);

			Lua.lua_pushstring(_lua, "y");
			Lua.lua_pushinteger(_lua, item.Cell.Y);
			Lua.lua_rawset(_lua, -3);

			var bomb = item as BombNode;
			if(bomb != null)
			{
				Lua.lua_pushstring(_lua, "range");
				Lua.lua_pushinteger(_lua, bomb.Range);
				Lua.lua_rawset(_lua, -3);

				Lua.lua_pushstring(_lua, "time");
				Lua.lua_pushinteger(_lua, bomb.BoomTime);
				Lua.lua_rawset(_lua, -3);
			}

			var high = item as HighTempNode;
			if(high != null)
			{
				Lua.lua_pushstring(_lua, "range");
				Lua.lua_pushinteger(_lua, high.Range);
				Lua.lua_rawset(_lua, -3);

				Lua.lua_pushstring(_lua, "time");
				Lua.lua_pushinteger(_lua, high.EndTime);
				Lua.lua_rawset(_lua, -3);
			}
		}

		#endregion

		#endregion

		#region Sapka event handlers

		protected void OnGameStarted(SapkaClient client, SapkaGameEventArgs e)
		{
			luacall("on_game_start", e.Id);
		}

		protected void OnRoundStarted(SapkaClient client, SapkaGameEventArgs e)
		{
			luacall("on_round_start", 2, delegate()
			{
				luapush(e.Id);
				luapush(e.Map);
			});
		}

		protected void OnRoundEnded(SapkaClient client, SapkaFinishRoundEventArgs e)
		{
			luacall("on_round_end", e.Score);
		}

		protected void OnGameEnded(SapkaClient client, SapkaFinishGameEventArgs e)
		{
			luacall("on_game_over", 1, delegate()
			{
				luapush(e.Score);
			});
		}

		protected void OnMapChanged(SapkaClient client, MapChangeEventArgs e)
		{
			if(e.Change.Changes != null)
			{
				foreach(var i in e.Change.Changes)
				{
					var add = i as AddInfoNode;
					if(add != null)
					{
						luacall("on_item_added", 1, delegate()
						{
							luapush(add.Item);
						});
					}
					var rem = i as RemoveInfoNode;
					if(rem != null)
					{
						luacall("on_item_removed", 1, delegate()
						{
							luapush(rem.Item);
						});
					}
				}
			}
			foreach(var p in e.Change.Players)
			{
				luacall("on_player", 1, delegate()
				{
					luapush(p);
				});
			}
			if(e.Change.DangerLevel > 0)
				luacall("on_danger");

			luacall("on_tick", e.Change.Time);
		}

		#endregion

		#region bot API

		private void api_move(char c, bool dropbomb)
		{
			_client.Write(dropbomb ? c + "b;" : c + ";");
		}

		private void api_move_left(bool dropbomb)
		{
			api_move('l', dropbomb);
		}
		private void api_move_right(bool dropbomb)
		{
			api_move('r', dropbomb);
		}
		private void api_move_up(bool dropbomb)
		{
			api_move('u', dropbomb);
		}
		private void api_move_down(bool dropbomb)
		{
			api_move('d', dropbomb);
		}
		private void api_engine_stop(bool dropbomb)
		{
			api_move('s', dropbomb);
		}

		private void api_launch(string team, string tokens)
		{
			_client.Write("launch {0} {1};", team, tokens);
		}

		#endregion
	}
}

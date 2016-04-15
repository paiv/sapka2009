using System;
using System.Text;
using System.Threading;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class SapkaVisualizerConsole : SapkaVisualizer
	{
		private int _mapLeft;
		private int _mapTop;
		private int _cellSize;
		private int _mapWidth;
		private int _mapHeight;

		public SapkaVisualizerConsole(PacketDispatcher dispatcher)
			: base(dispatcher)
		{
			ResetMapPosition();
		}

		#region properties

		public int StepDelay { get; set; }

		#endregion

		#region Sapka events

		protected override void OnServerMessage(SapkaClient client, ServerMessageEventArgs e)
		{
			BottomLine(e.Message);
		}

		protected override void OnGameStarted(SapkaClient sapkaClient, SapkaGameEventArgs e)
		{
			BottomLine("GAME {0} STARTED", e.Id);
		}

		protected override void OnRoundStarted(SapkaClient sapkaClient, SapkaGameEventArgs e)
		{
			BottomLine("ROUND {0} STARTED", e.Id);
			WriteMap(e.Map);
		}

		protected override void OnRoundEnded(SapkaClient sapkaClient, SapkaFinishRoundEventArgs e)
		{
			BottomLine("ROUND ENDED Your score: {0}", e.Score);
		}

		protected override void OnGameEnded(SapkaClient sapkaClient, SapkaFinishGameEventArgs e)
		{
			BottomLine("GAME OVER :");
			StringBuilder so = new StringBuilder();
			foreach(var p in e.Score)
			{
				so.AppendFormat("    P{0} {1} ({2})", p.Id, p.Rank, p.Score);
				so.AppendLine();
			}
			BottomLine("{0}", so);
		}

		protected override void OnMapChanged(SapkaClient client, MapChangeEventArgs e)
		{
			StatusLine("T{0} D{1}", e.Change.Time, e.Change.DangerLevel);
			foreach(var p in e.Change.Players)
				WriteOnMap(p.X, p.Y, '@');
			if(e.Change.Changes != null)
			{
				foreach(var change in e.Change.Changes)
				{
					bool add = change is AddInfoNode;
					var cell = change.Item.Cell;
					WriteOnMap(cell.X, cell.X, add ? change.Item.Icon : '.');
				}
			}
			if(StepDelay > 0)
				Thread.Sleep(StepDelay);
		}

		#endregion

		#region console output methods

		private void BottomLine(string format, params object[] args)
		{
			BottomLine(true, format, args);
		}

		private void BottomLine(bool resetCursor, string format, params object[] args)
		{
			MoveCursor(_mapLeft, _mapTop + _mapHeight);
			Console.WriteLine(format, args);
			if(resetCursor)
				ResetMapPosition();
		}

		private void MoveCursor(int left, int top)
		{
			Console.SetCursorPosition(left, top);
		}

		private void ResetMapPosition()
		{
			_mapLeft = Console.CursorLeft;
			_mapTop = Console.CursorTop;
			_mapWidth = 0;
			_mapHeight = 0;
		}

		private void WriteOnMap(int x, int y, char c)
		{
			if(_cellSize <= 0)
				return;
			MoveCursor(_mapLeft + x / _cellSize, _mapTop + y / _cellSize);
			Console.Write(c);
		}

		private void StatusLine(string format, params object[] args)
		{
			MoveCursor(_mapLeft + _mapWidth + 4, _mapTop);
			Console.Write(format, args);
		}

		private void WriteMap(MapInfoNode map)
		{
			_cellSize = map.CellSize;
			_mapWidth = 0;
			_mapHeight = 0;
			foreach(var line in map.Map)
			{
				StringBuilder so = new StringBuilder();
				int i = 0;
				foreach(var artefact in line)
				{
					so.Append(artefact);
					i++;
				}
				BottomLine(false, "{0}", so);
				_mapHeight++;
				if(i > _mapWidth)
					_mapWidth = i;
			}
			MoveCursor(_mapLeft, _mapTop);
		}

		#endregion
	}
}

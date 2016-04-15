using System;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class PacketDispatcher
	{
		private readonly SapkaClient _client;

		public PacketDispatcher(SapkaClient client)
		{
			if(client == null)
				throw new ArgumentNullException("client");
			_client = client;
		}

		#region Events

		public event EventHandler<ServerMessageEventArgs> ServerMessage;
		public event EventHandler<SapkaGameEventArgs> GameStarted;
		public event EventHandler<SapkaGameEventArgs> RoundStarted;
		public event EventHandler<MapChangeEventArgs> MapChanged;
		public event EventHandler<SapkaFinishRoundEventArgs> RoundEnded;
		public event EventHandler<SapkaFinishGameEventArgs> GameEnded;

		#region event helpers

		private void OnServerMessage(string message)
		{
			if(ServerMessage != null)
				ServerMessage(_client, new ServerMessageEventArgs(message));
		}

		private void OnGameStarted(int id, MapInfoNode map)
		{
			if(GameStarted != null)
				GameStarted(_client, new SapkaGameEventArgs(id, map));
		}

		private void OnRoundStarted(int id, MapInfoNode map)
		{
			if(RoundStarted != null)
				RoundStarted(_client, new SapkaGameEventArgs(id, map));
		}

		private void OnMapChanged(MapChangeNode change)
		{
			if(MapChanged != null)
				MapChanged(_client, new MapChangeEventArgs(change));
		}

		private void OnRoundEnded(int score)
		{
			if(RoundEnded != null)
				RoundEnded(_client, new SapkaFinishRoundEventArgs(score));
		}

		private void OnGameEnded(RankScoreNode score)
		{
			if(GameEnded != null)
				GameEnded(_client, new SapkaFinishGameEventArgs(score));
		}

		#endregion

		#endregion

		public void Process(string message)
		{
			OnServerMessage(message);
		}

		public void Process(SapkaInfoNode packet)
		{
			var gameStart = packet as GameInfoNode;
			if(gameStart != null)
			{
				OnGameStarted(gameStart.Pid, gameStart.Map);
				return;
			}

			var roundStart = packet as StartRoundNode;
			if(roundStart != null)
			{
				OnRoundStarted(roundStart.Id, roundStart.Map);
				return;
			}

			var mapChange = packet as MapChangeNode;
			if(mapChange != null)
			{
				OnMapChanged(mapChange);
				return;
			}

			var roundEnd = packet as FinishRoundNode;
			if(roundEnd != null)
			{
				OnRoundEnded(roundEnd.Score);
				return;
			}

			var gameEnd = packet as FinishGameNode;
			if(gameEnd != null)
			{
				OnGameEnded(gameEnd.Score);
				return;
			}

			throw new NotImplementedException();
		}
	}
}

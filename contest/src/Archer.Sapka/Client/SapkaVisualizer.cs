using System;

namespace Archer.Sapka.Client
{
	public abstract class SapkaVisualizer
	{
		protected SapkaVisualizer(PacketDispatcher dispatcher)
		{
			if(dispatcher == null)
				throw new ArgumentNullException("dispatcher");

			dispatcher.ServerMessage += new EventHandler<ServerMessageEventArgs>(Dispatcher_ServerMessage);
			dispatcher.GameStarted += new EventHandler<SapkaGameEventArgs>(Dispatcher_GameStarted);
			dispatcher.RoundStarted += new EventHandler<SapkaGameEventArgs>(Dispatcher_RoundStarted);
			dispatcher.MapChanged += new EventHandler<MapChangeEventArgs>(Dispatcher_MapChanged);
			dispatcher.RoundEnded += new EventHandler<SapkaFinishRoundEventArgs>(Dispatcher_RoundEnded);
			dispatcher.GameEnded += new EventHandler<SapkaFinishGameEventArgs>(Dispatcher_GameEnded);
		}

		#region Dispatcher event handlers

		private void Dispatcher_ServerMessage(object sender, ServerMessageEventArgs e)
		{
			OnServerMessage((SapkaClient)sender, e);
		}

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

		#region Sapka event handlers

		protected abstract void OnServerMessage(SapkaClient client, ServerMessageEventArgs e);
		protected abstract void OnGameStarted(SapkaClient client, SapkaGameEventArgs e);
		protected abstract void OnRoundStarted(SapkaClient client, SapkaGameEventArgs e);
		protected abstract void OnMapChanged(SapkaClient client, MapChangeEventArgs e);
		protected abstract void OnRoundEnded(SapkaClient client, SapkaFinishRoundEventArgs e);
		protected abstract void OnGameEnded(SapkaClient client, SapkaFinishGameEventArgs e);

		#endregion
	}
}

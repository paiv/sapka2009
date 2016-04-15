using System;

namespace Archer.Sapka.Client
{
	public class ServerMessageEventArgs : EventArgs
	{
		public ServerMessageEventArgs(string message)
		{
			Message = message;
		}

		public string Message { get; private set; }
	}
}

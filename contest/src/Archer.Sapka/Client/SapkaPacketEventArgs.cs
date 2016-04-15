using System;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class SapkaPacketEventArgs : EventArgs
	{
		public SapkaPacketEventArgs(SapkaInfoNode packet)
		{
			Packet = packet;
		}

		public SapkaInfoNode Packet { get; private set; }
	}
}

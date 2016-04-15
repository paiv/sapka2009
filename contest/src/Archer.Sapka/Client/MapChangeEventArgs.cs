using System;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class MapChangeEventArgs : EventArgs
	{
		public MapChangeEventArgs(MapChangeNode change)
		{
			Change = change;
		}

		public MapChangeNode Change { get; private set; }
	}
}

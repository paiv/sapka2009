using System;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class SapkaGameEventArgs : EventArgs
	{
		public SapkaGameEventArgs(int id, MapInfoNode map)
		{
			Id = id;
			Map = map;
		}

		public int Id { get; private set; }
		public MapInfoNode Map { get; private set; }
	}
}

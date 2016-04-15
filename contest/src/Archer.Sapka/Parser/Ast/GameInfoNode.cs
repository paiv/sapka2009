
namespace Archer.Sapka.Parser.Ast
{
	public class GameInfoNode : SapkaInfoNode
	{
		public GameInfoNode(GoldParser.Parser parser, int pid, MapInfoNode map)
			: base(parser)
		{
			Pid = pid;
			Map = map;
		}

		public int Pid { get; private set; }
		public MapInfoNode Map { get; private set; }
	}
}

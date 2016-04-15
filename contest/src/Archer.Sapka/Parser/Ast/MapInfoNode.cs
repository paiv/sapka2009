
namespace Archer.Sapka.Parser.Ast
{
	public class MapInfoNode : NonTerminalNode
	{
		public MapInfoNode(GoldParser.Parser parser, int cellSize, MapDataNode map)
			: base(parser)
		{
			CellSize = cellSize;
			Map = map;
		}

		public int CellSize { get; private set; }
		public MapDataNode Map { get; private set; }
	}
}

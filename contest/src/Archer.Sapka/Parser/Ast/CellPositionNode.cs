
namespace Archer.Sapka.Parser.Ast
{
	public class CellPositionNode : NonTerminalNode
	{
		public CellPositionNode(GoldParser.Parser parser, int x, int y)
			: base(parser)
		{
			X = x;
			Y = y;
		}

		public int X { get; private set; }
		public int Y { get; private set; }
	}
}

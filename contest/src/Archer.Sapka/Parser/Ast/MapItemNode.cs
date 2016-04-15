
namespace Archer.Sapka.Parser.Ast
{
	public class MapItemNode : NonTerminalNode
	{
		public MapItemNode(GoldParser.Parser parser, CellPositionNode cell, char icon)
			: base(parser)
		{
			Cell = cell;
			Icon = icon;
		}

		public CellPositionNode Cell { get; private set; }
		public char Icon { get; private set; }
	}
}

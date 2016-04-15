
namespace Archer.Sapka.Parser.Ast
{
	public class HighTempNode : MapItemNode
	{
		public HighTempNode(GoldParser.Parser parser, CellPositionNode cell)
			: this(parser, cell, -1, -1)
		{
		}

		public HighTempNode(GoldParser.Parser parser, CellPositionNode cell, int range, int time)
			: base(parser, cell, '#')
		{
			Range = range;
			EndTime = time;
		}

		public int Range { get; private set; }
		public int EndTime { get; private set; }
	}
}

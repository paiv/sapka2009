
namespace Archer.Sapka.Parser.Ast
{
	public class BombNode : MapItemNode
	{
		public BombNode(GoldParser.Parser parser, CellPositionNode cell, int range, int time)
			: base(parser, cell, '*')
		{
			Range = range;
			BoomTime = time;
		}

		public int Range { get; private set; }
		public int BoomTime { get; private set; }
	}
}

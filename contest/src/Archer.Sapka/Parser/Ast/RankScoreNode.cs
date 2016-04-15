
namespace Archer.Sapka.Parser.Ast
{
	public class RankScoreNode : AbstractNodeList<PlayerScoreNode>
	{
		public RankScoreNode(GoldParser.Parser parser, PlayerScoreNode item)
			: base(parser, item)
		{

		}
	}
}

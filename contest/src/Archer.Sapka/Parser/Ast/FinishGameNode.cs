
namespace Archer.Sapka.Parser.Ast
{
	public class FinishGameNode : SapkaInfoNode
	{
		public FinishGameNode(GoldParser.Parser parser, RankScoreNode score)
			: base(parser)
		{
			Score = score;
		}

		public RankScoreNode Score { get; private set; }
	}
}


namespace Archer.Sapka.Parser.Ast
{
	public class FinishRoundNode : SapkaInfoNode
	{
		public FinishRoundNode(GoldParser.Parser parser, int score)
			: base(parser)
		{
			Score = score;
		}

		public int Score { get; private set; }
	}
}

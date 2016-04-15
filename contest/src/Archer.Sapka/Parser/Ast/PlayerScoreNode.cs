
namespace Archer.Sapka.Parser.Ast
{
	public class PlayerScoreNode : NonTerminalNode
	{
		public PlayerScoreNode(GoldParser.Parser parser, int id, int score, int rank)
			: base(parser)
		{
			Id = id;
			Score = score;
			Rank = rank;
		}

		public int Id { get; private set; }
		public int Score { get; private set; }
		public int Rank { get; private set; }
	}
}

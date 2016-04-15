
namespace Archer.Sapka.Parser.Ast
{
	public class PlayerInfoNode : NonTerminalNode
	{
		public PlayerInfoNode(GoldParser.Parser parser, int id)
			: base(parser)
		{
			Id = id;
		}

		public int Id { get; set; }
		public bool IsDead { get; set; }
		public bool IsInfected { get; set; }
		public int X { get; set; }
		public int Y { get; set; }
		public int Speed { get; set; }
		public int Bombs { get; set; }
		public int BombStrength { get; set; }
	}
}

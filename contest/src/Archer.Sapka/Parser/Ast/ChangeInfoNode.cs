
namespace Archer.Sapka.Parser.Ast
{
	public abstract class ChangeInfoNode : NonTerminalNode
	{
		protected ChangeInfoNode(GoldParser.Parser parser, MapItemNode item)
			: base(parser)
		{
			Item = item;
		}

		public MapItemNode Item { get; set; }
	}
}

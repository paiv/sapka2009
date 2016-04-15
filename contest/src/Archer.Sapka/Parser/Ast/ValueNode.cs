
namespace Archer.Sapka.Parser.Ast
{
	public class ValueNode<T> : TerminalNode
	{
		public ValueNode(GoldParser.Parser parser, T value)
			: base(parser)
		{
			Value = value;
		}

		public T Value { get; private set; }
	}
}


namespace Archer.Sapka.Parser.Ast
{
	public class ChangesListNode : AbstractNodeList<ChangeInfoNode>
	{
		public ChangesListNode(GoldParser.Parser parser, ChangeInfoNode item)
			: base(parser, item)
		{

		}
	}
}

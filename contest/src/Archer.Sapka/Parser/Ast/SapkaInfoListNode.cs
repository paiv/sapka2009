
namespace Archer.Sapka.Parser.Ast
{
	public class SapkaInfoListNode : AbstractNodeList<PlayerInfoNode>
	{
		public SapkaInfoListNode(GoldParser.Parser parser, PlayerInfoNode item)
			: base(parser, item)
		{

		}
	}
}

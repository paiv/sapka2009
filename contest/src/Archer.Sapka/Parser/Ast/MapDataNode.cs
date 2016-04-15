
namespace Archer.Sapka.Parser.Ast
{
	public class MapDataNode : AbstractNodeList<MapDataLineNode>
	{
		public MapDataNode(GoldParser.Parser parser, MapDataLineNode item)
			: base(parser, item)
		{

		}
	}
}

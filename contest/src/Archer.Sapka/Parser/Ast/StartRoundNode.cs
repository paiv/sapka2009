
namespace Archer.Sapka.Parser.Ast
{
	public class StartRoundNode : SapkaInfoNode
	{
		public StartRoundNode(GoldParser.Parser parser, int id, MapInfoNode map)
			: base(parser)
		{
			Id = id;
			Map = map;
		}

		public int Id { get; private set; }
		public MapInfoNode Map { get; private set; }
	}
}

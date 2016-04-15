
namespace Archer.Sapka.Parser.Ast
{
	public class MapChangeNode : SapkaInfoNode
	{
		public MapChangeNode(GoldParser.Parser parser, int time, SapkaInfoListNode players,
			ChangesListNode changes)
			: base(parser)
		{
			Time = time;
			Players = players;
			Changes = changes;
		}

		public int Time { get; private set; }
		public int DangerLevel { get; set; }
		public SapkaInfoListNode Players { get; private set; }
		public ChangesListNode Changes { get; private set; }
	}
}

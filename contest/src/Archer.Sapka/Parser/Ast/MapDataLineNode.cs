using System.Collections.Generic;
using System.Collections;

namespace Archer.Sapka.Parser.Ast
{
	public class MapDataLineNode : NonTerminalNode, IEnumerable<char>
	{
		private List<char> _row;

		public MapDataLineNode(GoldParser.Parser parser, char item)
			: base(parser)
		{
			_row = new List<char>();
			_row.Add(item);
		}

		public MapDataLineNode Prepend(char item)
		{
			_row.Insert(0, item);
			return this;
		}

		#region IEnumerable<char> Members

		public IEnumerator<char> GetEnumerator()
		{
			return _row.GetEnumerator();
		}

		#endregion

		#region IEnumerable Members

		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}

		#endregion
	}
}

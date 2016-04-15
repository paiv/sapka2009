using System.Collections;
using System.Collections.Generic;

namespace Archer.Sapka.Parser.Ast
{
	public abstract class AbstractNodeList<T> : NonTerminalNode, IEnumerable<T>
		where T : ASTNode
	{
		public AbstractNodeList(GoldParser.Parser parser, T item)
			: base(parser)
		{
			AppendChildNode(item);
		}

		#region IEnumerable<T> Members

		public IEnumerator<T> GetEnumerator()
		{
			foreach(T item in m_array)
				yield return item;
		}

		#endregion

		#region IEnumerable Members

		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}

		#endregion

		public new T this[int index]
		{
			get
			{
				return (T)base[index];
			}
		}

		public AbstractNodeList<T> Prepend(T item)
		{
			PrependChildNode(item);
			return this;
		}
	}
}

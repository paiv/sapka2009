using System.Collections.Generic;
using GoldParser;

namespace Archer.Sapka.Parser.Ast
{
	/// <summary>
	/// Derive this class for NonTerminal AST Nodes
	/// </summary>
	public partial class NonTerminalNode : ASTNode
	{
		private int m_reductionNumber;
		private Rule m_rule;
		protected List<ASTNode> m_array = new List<ASTNode>();

		public NonTerminalNode(GoldParser.Parser theParser)
		{
			m_rule = theParser.ReductionRule;
		}

		public override bool IsTerminal
		{
			get
			{
				return false;
			}
		}

		public int ReductionNumber
		{
			get { return m_reductionNumber; }
			set { m_reductionNumber = value; }
		}

		public int Count
		{
			get { return m_array.Count; }
		}

		public ASTNode this[int index]
		{
			get { return m_array[index]; }
		}

		public void AppendChildNode(ASTNode node)
		{
			if(node != null)
				m_array.Add(node);
		}

		public void PrependChildNode(ASTNode node)
		{
			if(node != null)
				m_array.Insert(0, node);
		}

		public Rule Rule
		{
			get { return m_rule; }
		}

	}
}

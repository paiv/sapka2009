using GoldParser;

namespace Archer.Sapka.Parser.Ast
{
	/// <summary>
	/// Derive this class for Terminal AST Nodes
	/// </summary>
	public partial class TerminalNode : ASTNode
	{
		private Symbol m_symbol;
		private string m_text;
		private int m_lineNumber;
		private int m_linePosition;

		public TerminalNode(GoldParser.Parser theParser)
		{
			m_symbol = theParser.TokenSymbol;
			m_text = theParser.TokenSymbol.ToString();
			m_lineNumber = theParser.LineNumber;
			m_linePosition = theParser.LinePosition;
		}

		public override bool IsTerminal
		{
			get
			{
				return true;
			}
		}

		public Symbol Symbol
		{
			get { return m_symbol; }
		}

		public string Text
		{
			get { return m_text; }
		}

		public override string ToString()
		{
			return m_text;
		}

		public int LineNumber
		{
			get { return m_lineNumber; }
		}

		public int LinePosition
		{
			get { return m_linePosition; }
		}
	}
}

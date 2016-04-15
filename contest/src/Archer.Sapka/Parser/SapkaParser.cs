using System.IO;
using System.Text;
using Archer.Sapka.Parser.Ast;
using GoldParser;
using GParser = GoldParser.Parser;

namespace Archer.Sapka.Parser
{
	public partial class SapkaParser
	{
		SapkaParserContext m_context;
		ASTNode m_AST;
		string m_errorString;
		GParser m_parser;

		public SapkaParser()
		{
			ParserFactory.InitializeFactoryFromResource(this.GetType().Namespace + ".sapka.cgt");
		}

		public int LineNumber
		{
			get
			{
				return m_parser.LineNumber;
			}
		}

		public int LinePosition
		{
			get
			{
				return m_parser.LinePosition;
			}
		}

		public string ErrorString
		{
			get
			{
				return m_errorString;
			}
		}

		public string ErrorLine
		{
			get
			{
				return m_parser.LineText;
			}
		}

		public ASTNode SyntaxTree
		{
			get
			{
				return m_AST;
			}
		}

		public bool Parse(string source)
		{
			return Parse(new StringReader(source));
		}

		public bool Parse(TextReader sourceReader)
		{
			m_parser = ParserFactory.CreateParser(sourceReader);
			m_parser.TrimReductions = false;
			m_context = new SapkaParserContext(m_parser);

			while(true)
			{
				switch(m_parser.Parse())
				{
				case ParseMessage.LexicalError:
					m_errorString = string.Format("Lexical Error. Line {0}. Token {1} was not expected.", m_parser.LineNumber, m_parser.TokenText);
					return false;

				case ParseMessage.SyntaxError:
					StringBuilder text = new StringBuilder();
					foreach(Symbol tokenSymbol in m_parser.GetExpectedTokens())
					{
						text.Append(' ');
						text.Append(tokenSymbol.ToString());
					}
					m_errorString = string.Format("Syntax Error. Line {0}. Expecting: {1}.", m_parser.LineNumber, text.ToString());

					return false;
				case ParseMessage.Reduction:
					m_parser.TokenSyntaxNode = m_context.CreateASTNode();
					break;

				case ParseMessage.Accept:
					m_AST = m_parser.TokenSyntaxNode as ASTNode;
					m_errorString = null;
					return true;

				case ParseMessage.TokenRead:
					m_parser.TokenSyntaxNode = m_context.GetTokenText();
					break;

				case ParseMessage.InternalError:
					m_errorString = "Internal Error. Something is horribly wrong.";
					return false;

				case ParseMessage.NotLoadedError:
					m_errorString = "Grammar Table is not loaded.";
					return false;

				case ParseMessage.CommentError:
					m_errorString = "Comment Error. Unexpected end of input.";

					return false;

				case ParseMessage.CommentBlockRead:
				case ParseMessage.CommentLineRead:
					// don't do anything 
					break;
				}
			}
		}
	}
}

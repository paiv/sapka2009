using System.IO;
using Archer.Sapka.Parser.Ast;
using GParser = GoldParser.Parser;

namespace Archer.Sapka.Parser
{
	/// <summary>
	/// Constructs the AST.
	/// </summary>
	public partial class SapkaParserContext
	{
		private GParser m_parser;

		public SapkaParserContext(GParser prser)
		{
			m_parser = prser;
		}

		public string GetTokenText()
		{
			switch((SymbolConstants)m_parser.TokenSymbol.Index)
			{
			case SymbolConstants.SYMBOL_MINUS:	//'-'
			case SymbolConstants.SYMBOL_NUM:	//'#'
			case SymbolConstants.SYMBOL_AMP:	//'&'
			case SymbolConstants.SYMBOL_TIMES:	//'*'
			case SymbolConstants.SYMBOL_COMMA:	//','
			case SymbolConstants.SYMBOL_DOT:	//'.'
			case SymbolConstants.SYMBOL_SEMI:	//';'
			case SymbolConstants.SYMBOL_QUESTION:	//'?'
			case SymbolConstants.SYMBOL_PLUS:	//'+'
			case SymbolConstants.SYMBOL_B:	//b
			case SymbolConstants.SYMBOL_D:	//d
			case SymbolConstants.SYMBOL_DEAD:	//dead
			case SymbolConstants.SYMBOL_F:	//f
			case SymbolConstants.SYMBOL_GEND:	//GEND
			case SymbolConstants.SYMBOL_I:	//i
			case SymbolConstants.SYMBOL_NUMBER:	//number
			case SymbolConstants.SYMBOL_O:	//o
			case SymbolConstants.SYMBOL_P:	//P
			case SymbolConstants.SYMBOL_PID:	//PID
			case SymbolConstants.SYMBOL_R:	//r
			case SymbolConstants.SYMBOL_REND:	//REND
			case SymbolConstants.SYMBOL_S:	//s
			case SymbolConstants.SYMBOL_SEP:	//sep
			case SymbolConstants.SYMBOL_START:	//START
			case SymbolConstants.SYMBOL_STRINGMINUSTERMINATOR:	//string-terminator
			case SymbolConstants.SYMBOL_T:	//T
			case SymbolConstants.SYMBOL_U:	//u
			case SymbolConstants.SYMBOL_V:	//v
			case SymbolConstants.SYMBOL_W:	//w
			case SymbolConstants.SYMBOL_X:	//X
				return m_parser.TokenString;

			default:
				return null;
			}
		}

		public ASTNode CreateASTNode()
		{
			switch((RuleConstants)m_parser.ReductionRule.Index)
			{
			case RuleConstants.RULE_SAPKADATA:
				//<sapka-data> ::= <info> <sapka-data>
				var data = (SapkaDataNode)GetNode(1);
				if(data == null)
					return new SapkaDataNode(m_parser, (SapkaInfoNode)GetNode(0));
				return data.Prepend((SapkaInfoNode)GetNode(0));

			case RuleConstants.RULE_SAPKADATA2:
				//<sapka-data> ::= 
				return null;

			case RuleConstants.RULE_INFO_SEMI:	//<info> ::= <info-term> ';'
			case RuleConstants.RULE_INFOTERM:	//<info-term> ::= <game-info>
			case RuleConstants.RULE_INFOTERM2:	//<info-term> ::= <start-round-info>
			case RuleConstants.RULE_INFOTERM3:	//<info-term> ::= <map-change-info>
			case RuleConstants.RULE_INFOTERM4:	//<info-term> ::= <finish-round-info>
			case RuleConstants.RULE_INFOTERM5:	//<info-term> ::= <finish-game-info>
				return GetNode(0);

			case RuleConstants.RULE_GAMEINFO_AMP:
				//<game-info> ::= <sapka-init-info> '&' <map-info>
				var pid = (ValueNode<int>)GetNode(0);
				return new GameInfoNode(m_parser, pid.Value, (MapInfoNode)GetNode(2));

			case RuleConstants.RULE_SAPKAINITINFO_PID_NUMBER:
				//<sapka-init-info> ::= PID number
				return new ValueNode<int>(m_parser, int.Parse(GetToken(1)));

			case RuleConstants.RULE_MAPINFO_STRINGMINUSTERMINATOR:
				//<map-info> ::= <map-cell-size> string-terminator <map-data>
				var size = (ValueNode<int>)GetNode(0);
				return new MapInfoNode(m_parser, size.Value, (MapDataNode)GetNode(2));

			case RuleConstants.RULE_MAPCELLSIZE_NUMBER:	//<map-cell-size> ::= number
			case RuleConstants.RULE_SCORE_NUMBER:		//<score> ::= number
			case RuleConstants.RULE_RANK_NUMBER:		//<rank> ::= number
			case RuleConstants.RULE_XCOORD_NUMBER:		//<x-coord> ::= number
			case RuleConstants.RULE_YCOORD_NUMBER:		//<y-coord> ::= number
			case RuleConstants.RULE_BOMBSLEFT_NUMBER:	//<bombs-left> ::= number
			case RuleConstants.RULE_BOMBSTRENGTH_NUMBER:	//<bomb-strength> ::= number
			case RuleConstants.RULE_SPEED_NUMBER:		//<speed> ::= number
			case RuleConstants.RULE_BOOMTIME_NUMBER:	//<boom-time> ::= number
			case RuleConstants.RULE_ENDTIME_NUMBER:		//<end-time> ::= number
			case RuleConstants.RULE_DAMAGINGRANGE_NUMBER:	//<damaging-range> ::= number
			case RuleConstants.RULE_XCELL_NUMBER:		//<x-cell> ::= number
			case RuleConstants.RULE_YCELL_NUMBER:		//<y-cell> ::= number
			case RuleConstants.RULE_DANGERLEVEL_NUMBER:	//<danger-level> ::= number
				return new ValueNode<int>(m_parser, int.Parse(GetToken(0)));

			case RuleConstants.RULE_MAPDATA_STRINGMINUSTERMINATOR:
				//<map-data> ::= <map-data-line> string-terminator <map-data>
				return ((MapDataNode)GetNode(2)).Prepend((MapDataLineNode)GetNode(0));

			case RuleConstants.RULE_MAPDATA_STRINGMINUSTERMINATOR2:
				//<map-data> ::= <map-data-line> string-terminator
				return new MapDataNode(m_parser, (MapDataLineNode)GetNode(0));

			case RuleConstants.RULE_MAPDATALINE:
				//<map-data-line> ::= <map-symbol> <map-data-line>
				var symbol = (ValueNode<char>)GetNode(0);
				return ((MapDataLineNode)GetNode(1)).Prepend(symbol.Value);

			case RuleConstants.RULE_MAPDATALINE2:
				//<map-data-line> ::= <map-symbol>
				symbol = (ValueNode<char>)GetNode(0);
				return new MapDataLineNode(m_parser, symbol.Value);

			case RuleConstants.RULE_MAPSYMBOL_DOT:	//<map-symbol> ::= '.'
			case RuleConstants.RULE_MAPSYMBOL_X:	//<map-symbol> ::= X
			case RuleConstants.RULE_MAPSYMBOL_W:	//<map-symbol> ::= w
			case RuleConstants.RULE_BONUSTYPE_B:	//<bonus-type> ::= b
			case RuleConstants.RULE_BONUSTYPE_V:	//<bonus-type> ::= v
			case RuleConstants.RULE_BONUSTYPE_F:	//<bonus-type> ::= f
			case RuleConstants.RULE_BONUSTYPE_R:	//<bonus-type> ::= r
			case RuleConstants.RULE_BONUSTYPE_S:	//<bonus-type> ::= s
			case RuleConstants.RULE_BONUSTYPE_U:	//<bonus-type> ::= u
			case RuleConstants.RULE_BONUSTYPE_O:	//<bonus-type> ::= o
			case RuleConstants.RULE_BONUSTYPE_QUESTION:	//<bonus-type> ::= '?'
				return new ValueNode<char>(m_parser, GetToken(0)[0]);

			case RuleConstants.RULE_STARTROUNDINFO_START_NUMBER_AMP:
				//<start-round-info> ::= START number '&' <map-info>
				return new StartRoundNode(m_parser, int.Parse(GetToken(1)), (MapInfoNode)GetNode(3));

			case RuleConstants.RULE_MAPCHANGEINFO_AMP_AMP_AMP:
				//<map-change-info> ::= <time-part> '&' <sapkas-part> '&' <changes-part> '&' <danger-part>
				var time = (ValueNode<int>)GetNode(0);
				var mcn = new MapChangeNode(m_parser, time.Value, (SapkaInfoListNode)GetNode(2),
					(ChangesListNode)GetNode(4));
				mcn.DangerLevel = ((ValueNode<int>)GetNode(6)).Value;
				return mcn;

			case RuleConstants.RULE_MAPCHANGEINFO_AMP_AMP:
				//<map-change-info> ::= <time-part> '&' <sapkas-part> '&' <changes-part>
				time = (ValueNode<int>)GetNode(0);
				return new MapChangeNode(m_parser, time.Value, (SapkaInfoListNode)GetNode(2),
					(ChangesListNode)GetNode(4));

			case RuleConstants.RULE_TIMEPART_T_NUMBER:
				//<time-part> ::= T number
				return new ValueNode<int>(m_parser, int.Parse(GetToken(1)));

			case RuleConstants.RULE_SAPKASPART_COMMA:
				//<sapkas-part> ::= <sapka-info> ',' <sapkas-part>
				return ((SapkaInfoListNode)GetNode(2)).Prepend((PlayerInfoNode)GetNode(0));
			case RuleConstants.RULE_SAPKASPART:
				//<sapkas-part> ::= <sapka-info>
				return new SapkaInfoListNode(m_parser, (PlayerInfoNode)GetNode(0));

			case RuleConstants.RULE_SAPKAINFO_P_NUMBER_SEP:
				//<sapka-info> ::= P number sep <sapka-info-ex>
				var pl = (PlayerInfoNode)GetNode(3);
				pl.Id = int.Parse(GetToken(1));
				return pl;

			case RuleConstants.RULE_SAPKAINFOEX:
				//<sapka-info-ex> ::= <details>
				return GetNode(0);
			case RuleConstants.RULE_SAPKAINFOEX_DEAD:
				//<sapka-info-ex> ::= dead
				pl = new PlayerInfoNode(m_parser, -1);
				pl.IsDead = true;
				return pl;

			case RuleConstants.RULE_DETAILS_SEP_SEP_SEP_SEP_SEP:
				//<details> ::= <x-coord> sep <y-coord> sep <bombs-left> sep <bomb-strength> sep <speed> sep <infected>
				pl = new PlayerInfoNode(m_parser, -1);
				pl.X = ((ValueNode<int>)GetNode(0)).Value;
				pl.Y = ((ValueNode<int>)GetNode(2)).Value;
				pl.Bombs = ((ValueNode<int>)GetNode(4)).Value;
				pl.BombStrength = ((ValueNode<int>)GetNode(6)).Value;
				pl.Speed = ((ValueNode<int>)GetNode(8)).Value;
				pl.IsInfected = true;
				return pl;
			case RuleConstants.RULE_DETAILS_SEP_SEP_SEP_SEP:
				//<details> ::= <x-coord> sep <y-coord> sep <bombs-left> sep <bomb-strength> sep <speed>
				pl = new PlayerInfoNode(m_parser, -1);
				pl.X = ((ValueNode<int>)GetNode(0)).Value;
				pl.Y = ((ValueNode<int>)GetNode(2)).Value;
				pl.Bombs = ((ValueNode<int>)GetNode(4)).Value;
				pl.BombStrength = ((ValueNode<int>)GetNode(6)).Value;
				pl.Speed = ((ValueNode<int>)GetNode(8)).Value;
				return pl;
			case RuleConstants.RULE_INFECTED_I:	//<infected> ::= i
				return null;

			case RuleConstants.RULE_CHANGESPART_COMMA:
				//<changes-part> ::= <change-info> ',' <changes-part>
				var cl = (ChangesListNode)GetNode(2);
				if(cl == null)
					return new ChangesListNode(m_parser, (ChangeInfoNode)GetNode(0));
				return cl.Prepend((ChangeInfoNode)GetNode(0));
			case RuleConstants.RULE_CHANGESPART:
				//<changes-part> ::= <change-info>
				return new ChangesListNode(m_parser, (ChangeInfoNode)GetNode(0));
			case RuleConstants.RULE_CHANGESPART2:
				//<changes-part> ::= 
				return null;

			case RuleConstants.RULE_CHANGEINFO:		//<change-info> ::= <add-info>
			case RuleConstants.RULE_CHANGEINFO2:	//<change-info> ::= <remove-info>
				return GetNode(0);

			case RuleConstants.RULE_ADDINFO_PLUS:	//<add-info> ::= '+' <add-substance>
				return new AddInfoNode(m_parser, (MapItemNode)GetNode(1));
			case RuleConstants.RULE_REMOVEINFO_MINUS:	//<remove-info> ::= '-' <remove-substance>
				return new RemoveInfoNode(m_parser, (MapItemNode)GetNode(1));

			case RuleConstants.RULE_ADDSUBSTANCE:	//<add-substance> ::= <add-dangerous-substance>
			case RuleConstants.RULE_ADDSUBSTANCE2:	//<add-substance> ::= <add-bonus-substance>
			case RuleConstants.RULE_ADDSUBSTANCE3:	//<add-substance> ::= <add-hightemp-substance>
			case RuleConstants.RULE_ADDSUBSTANCE4:	//<add-substance> ::= <add-destr-substance>
			case RuleConstants.RULE_ADDSUBSTANCE5:	//<add-substance> ::= <add-indestr-substance>
			case RuleConstants.RULE_REMOVESUBSTANCE:	//<remove-substance> ::= <remove-dangerous-substance>
			case RuleConstants.RULE_REMOVESUBSTANCE2:	//<remove-substance> ::= <remove-bonus-substance>
			case RuleConstants.RULE_REMOVESUBSTANCE3:	//<remove-substance> ::= <remove-hightemp-substance>
			case RuleConstants.RULE_REMOVESUBSTANCE4:	//<remove-substance> ::= <remove-destr-substance>
				return GetNode(0);

			case RuleConstants.RULE_ADDBONUSSUBSTANCE_SEP:		//<add-bonus-substance> ::= <bonus-type> sep <cell-position>
			case RuleConstants.RULE_REMOVEBONUSSUBSTANCE_SEP:	//<remove-bonus-substance> ::= <bonus-type> sep <cell-position>
				return new MapItemNode(m_parser, (CellPositionNode)GetNode(2),
					((ValueNode<char>)GetNode(0)).Value);

			case RuleConstants.RULE_ADDDESTRSUBSTANCE_W_SEP:	//<add-destr-substance> ::= w sep <cell-position>
			case RuleConstants.RULE_ADDINDESTRSUBSTANCE_X_SEP:	//<add-indestr-substance> ::= X sep <cell-position>
			case RuleConstants.RULE_REMOVEDANGEROUSSUBSTANCE_TIMES_SEP:	//<remove-dangerous-substance> ::= '*' sep <cell-position>
			case RuleConstants.RULE_REMOVEDESTRSUBSTANCE_W_SEP:	//<remove-destr-substance> ::= w sep <cell-position>
				return new MapItemNode(m_parser, (CellPositionNode)GetNode(2), GetToken(0)[0]);

			case RuleConstants.RULE_ADDDANGEROUSSUBSTANCE_TIMES_SEP_SEP_SEP:
				//<add-dangerous-substance> ::= '*' sep <cell-position> sep <damaging-range> sep <boom-time>
				return new BombNode(m_parser, (CellPositionNode)GetNode(2),
					((ValueNode<int>)GetNode(4)).Value, ((ValueNode<int>)GetNode(6)).Value);

			case RuleConstants.RULE_ADDHIGHTEMPSUBSTANCE_NUM_SEP_SEP_SEP:
				//<add-hightemp-substance> ::= '#' sep <cell-position> sep <damaging-range> sep <end-time>
				return new HighTempNode(m_parser, (CellPositionNode)GetNode(2),
					((ValueNode<int>)GetNode(4)).Value, ((ValueNode<int>)GetNode(6)).Value);
			case RuleConstants.RULE_REMOVEHIGHTEMPSUBSTANCE_NUM_SEP:
				//<remove-hightemp-substance> ::= '#' sep <cell-position>
				return new HighTempNode(m_parser, (CellPositionNode)GetNode(2));

			case RuleConstants.RULE_CELLPOSITION_SEP:
				//<cell-position> ::= <x-cell> sep <y-cell>
				return new CellPositionNode(m_parser, ((ValueNode<int>)GetNode(0)).Value,
					((ValueNode<int>)GetNode(2)).Value);

			case RuleConstants.RULE_DANGERPART_D_SEP:
				//<danger-part> ::= d sep <danger-level>
				return new ValueNode<int>(m_parser, int.Parse(GetToken(2)));

			case RuleConstants.RULE_FINISHROUNDINFO_REND_SEP:
				//<finish-round-info> ::= REND sep <score>
				var score = (ValueNode<int>)GetNode(2);
				return new FinishRoundNode(m_parser, score.Value);

			case RuleConstants.RULE_FINISHGAMEINFO_GEND_SEP:
				//<finish-game-info> ::= GEND sep <rank-score-info>
				return new FinishGameNode(m_parser, (RankScoreNode)GetNode(2));
			case RuleConstants.RULE_RANKSCOREINFO_COMMA:
				//<rank-score-info> ::= <player-score> ',' <rank-score-info>
				return ((RankScoreNode)GetNode(2)).Prepend((PlayerScoreNode)GetNode(0));
			case RuleConstants.RULE_RANKSCOREINFO:
				//<rank-score-info> ::= <player-score>
				return new RankScoreNode(m_parser, (PlayerScoreNode)GetNode(0));
			case RuleConstants.RULE_PLAYERSCORE_P_NUMBER_SEP_SEP:
				//<player-score> ::= P number sep <score> sep <rank>
				var pscore = (ValueNode<int>)GetNode(3);
				var prank = (ValueNode<int>)GetNode(5);
				return new PlayerScoreNode(m_parser, int.Parse(GetToken(1)), pscore.Value, prank.Value);

			default:
				throw new RuleException("Unknown rule: Does your CGT Match your Code Revision?");
			}
		}

		private ASTNode GetNode(int index)
		{
			return (ASTNode)m_parser.GetReductionSyntaxNode(index);
		}
		private string GetToken(int index)
		{
			return (string)m_parser.GetReductionSyntaxNode(index);
		}
	}
}

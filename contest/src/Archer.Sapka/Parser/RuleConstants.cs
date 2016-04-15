
namespace Archer.Sapka.Parser
{
    enum RuleConstants : int
    {
        RULE_SAPKADATA                               =  0, // <sapka-data> ::= <info> <sapka-data>
        RULE_SAPKADATA2                              =  1, // <sapka-data> ::= 
        RULE_INFO_SEMI                               =  2, // <info> ::= <info-term> ';'
        RULE_INFOTERM                                =  3, // <info-term> ::= <game-info>
        RULE_INFOTERM2                               =  4, // <info-term> ::= <start-round-info>
        RULE_INFOTERM3                               =  5, // <info-term> ::= <map-change-info>
        RULE_INFOTERM4                               =  6, // <info-term> ::= <finish-round-info>
        RULE_INFOTERM5                               =  7, // <info-term> ::= <finish-game-info>
        RULE_GAMEINFO_AMP                            =  8, // <game-info> ::= <sapka-init-info> '&' <map-info>
        RULE_SAPKAINITINFO_PID_NUMBER                =  9, // <sapka-init-info> ::= PID number
        RULE_MAPINFO_STRINGMINUSTERMINATOR           = 10, // <map-info> ::= <map-cell-size> string-terminator <map-data>
        RULE_MAPCELLSIZE_NUMBER                      = 11, // <map-cell-size> ::= number
        RULE_MAPDATA_STRINGMINUSTERMINATOR           = 12, // <map-data> ::= <map-data-line> string-terminator <map-data>
        RULE_MAPDATA_STRINGMINUSTERMINATOR2          = 13, // <map-data> ::= <map-data-line> string-terminator
        RULE_MAPDATALINE                             = 14, // <map-data-line> ::= <map-symbol> <map-data-line>
        RULE_MAPDATALINE2                            = 15, // <map-data-line> ::= <map-symbol>
        RULE_MAPSYMBOL_DOT                           = 16, // <map-symbol> ::= '.'
        RULE_MAPSYMBOL_X                             = 17, // <map-symbol> ::= X
        RULE_MAPSYMBOL_W                             = 18, // <map-symbol> ::= w
        RULE_STARTROUNDINFO_START_NUMBER_AMP         = 19, // <start-round-info> ::= START number '&' <map-info>
        RULE_MAPCHANGEINFO_AMP_AMP_AMP               = 20, // <map-change-info> ::= <time-part> '&' <sapkas-part> '&' <changes-part> '&' <danger-part>
        RULE_MAPCHANGEINFO_AMP_AMP                   = 21, // <map-change-info> ::= <time-part> '&' <sapkas-part> '&' <changes-part>
        RULE_TIMEPART_T_NUMBER                       = 22, // <time-part> ::= T number
        RULE_SAPKASPART_COMMA                        = 23, // <sapkas-part> ::= <sapka-info> ',' <sapkas-part>
        RULE_SAPKASPART                              = 24, // <sapkas-part> ::= <sapka-info>
        RULE_SAPKAINFO_P_NUMBER_SEP                  = 25, // <sapka-info> ::= P number sep <sapka-info-ex>
        RULE_SAPKAINFOEX                             = 26, // <sapka-info-ex> ::= <details>
        RULE_SAPKAINFOEX_DEAD                        = 27, // <sapka-info-ex> ::= dead
        RULE_DETAILS_SEP_SEP_SEP_SEP_SEP             = 28, // <details> ::= <x-coord> sep <y-coord> sep <bombs-left> sep <bomb-strength> sep <speed> sep <infected>
        RULE_DETAILS_SEP_SEP_SEP_SEP                 = 29, // <details> ::= <x-coord> sep <y-coord> sep <bombs-left> sep <bomb-strength> sep <speed>
        RULE_INFECTED_I                              = 30, // <infected> ::= i
        RULE_XCOORD_NUMBER                           = 31, // <x-coord> ::= number
        RULE_YCOORD_NUMBER                           = 32, // <y-coord> ::= number
        RULE_BOMBSLEFT_NUMBER                        = 33, // <bombs-left> ::= number
        RULE_BOMBSTRENGTH_NUMBER                     = 34, // <bomb-strength> ::= number
        RULE_SPEED_NUMBER                            = 35, // <speed> ::= number
        RULE_CHANGESPART_COMMA                       = 36, // <changes-part> ::= <change-info> ',' <changes-part>
        RULE_CHANGESPART                             = 37, // <changes-part> ::= <change-info>
        RULE_CHANGESPART2                            = 38, // <changes-part> ::= 
        RULE_CHANGEINFO                              = 39, // <change-info> ::= <add-info>
        RULE_CHANGEINFO2                             = 40, // <change-info> ::= <remove-info>
        RULE_ADDINFO_PLUS                            = 41, // <add-info> ::= '+' <add-substance>
        RULE_ADDSUBSTANCE                            = 42, // <add-substance> ::= <add-dangerous-substance>
        RULE_ADDSUBSTANCE2                           = 43, // <add-substance> ::= <add-bonus-substance>
        RULE_ADDSUBSTANCE3                           = 44, // <add-substance> ::= <add-hightemp-substance>
        RULE_ADDSUBSTANCE4                           = 45, // <add-substance> ::= <add-destr-substance>
        RULE_ADDSUBSTANCE5                           = 46, // <add-substance> ::= <add-indestr-substance>
        RULE_ADDDANGEROUSSUBSTANCE_TIMES_SEP_SEP_SEP = 47, // <add-dangerous-substance> ::= '*' sep <cell-position> sep <damaging-range> sep <boom-time>
        RULE_ADDBONUSSUBSTANCE_SEP                   = 48, // <add-bonus-substance> ::= <bonus-type> sep <cell-position>
        RULE_ADDDESTRSUBSTANCE_W_SEP                 = 49, // <add-destr-substance> ::= w sep <cell-position>
        RULE_ADDINDESTRSUBSTANCE_X_SEP               = 50, // <add-indestr-substance> ::= X sep <cell-position>
        RULE_ADDHIGHTEMPSUBSTANCE_NUM_SEP_SEP_SEP    = 51, // <add-hightemp-substance> ::= '#' sep <cell-position> sep <damaging-range> sep <end-time>
        RULE_BOOMTIME_NUMBER                         = 52, // <boom-time> ::= number
        RULE_ENDTIME_NUMBER                          = 53, // <end-time> ::= number
        RULE_REMOVEINFO_MINUS                        = 54, // <remove-info> ::= '-' <remove-substance>
        RULE_REMOVESUBSTANCE                         = 55, // <remove-substance> ::= <remove-dangerous-substance>
        RULE_REMOVESUBSTANCE2                        = 56, // <remove-substance> ::= <remove-bonus-substance>
        RULE_REMOVESUBSTANCE3                        = 57, // <remove-substance> ::= <remove-hightemp-substance>
        RULE_REMOVESUBSTANCE4                        = 58, // <remove-substance> ::= <remove-destr-substance>
        RULE_REMOVEDANGEROUSSUBSTANCE_TIMES_SEP      = 59, // <remove-dangerous-substance> ::= '*' sep <cell-position>
        RULE_REMOVEBONUSSUBSTANCE_SEP                = 60, // <remove-bonus-substance> ::= <bonus-type> sep <cell-position>
        RULE_REMOVEHIGHTEMPSUBSTANCE_NUM_SEP         = 61, // <remove-hightemp-substance> ::= '#' sep <cell-position>
        RULE_REMOVEDESTRSUBSTANCE_W_SEP              = 62, // <remove-destr-substance> ::= w sep <cell-position>
        RULE_BONUSTYPE_B                             = 63, // <bonus-type> ::= b
        RULE_BONUSTYPE_V                             = 64, // <bonus-type> ::= v
        RULE_BONUSTYPE_F                             = 65, // <bonus-type> ::= f
        RULE_BONUSTYPE_R                             = 66, // <bonus-type> ::= r
        RULE_BONUSTYPE_S                             = 67, // <bonus-type> ::= s
        RULE_BONUSTYPE_U                             = 68, // <bonus-type> ::= u
        RULE_BONUSTYPE_O                             = 69, // <bonus-type> ::= o
        RULE_BONUSTYPE_QUESTION                      = 70, // <bonus-type> ::= '?'
        RULE_DAMAGINGRANGE_NUMBER                    = 71, // <damaging-range> ::= number
        RULE_CELLPOSITION_SEP                        = 72, // <cell-position> ::= <x-cell> sep <y-cell>
        RULE_XCELL_NUMBER                            = 73, // <x-cell> ::= number
        RULE_YCELL_NUMBER                            = 74, // <y-cell> ::= number
        RULE_DANGERPART_D_SEP                        = 75, // <danger-part> ::= d sep <danger-level>
        RULE_DANGERLEVEL_NUMBER                      = 76, // <danger-level> ::= number
        RULE_FINISHROUNDINFO_REND_SEP                = 77, // <finish-round-info> ::= REND sep <score>
        RULE_FINISHGAMEINFO_GEND_SEP                 = 78, // <finish-game-info> ::= GEND sep <rank-score-info>
        RULE_RANKSCOREINFO_COMMA                     = 79, // <rank-score-info> ::= <player-score> ',' <rank-score-info>
        RULE_RANKSCOREINFO                           = 80, // <rank-score-info> ::= <player-score>
        RULE_PLAYERSCORE_P_NUMBER_SEP_SEP            = 81, // <player-score> ::= P number sep <score> sep <rank>
        RULE_SCORE_NUMBER                            = 82, // <score> ::= number
        RULE_RANK_NUMBER                             = 83  // <rank> ::= number
    };
}

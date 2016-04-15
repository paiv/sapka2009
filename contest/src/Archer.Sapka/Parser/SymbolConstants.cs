﻿
namespace Archer.Sapka.Parser
{
    enum SymbolConstants : int
    {
        SYMBOL_EOF                                =  0, // (EOF)
        SYMBOL_ERROR                              =  1, // (Error)
        SYMBOL_WHITESPACE                         =  2, // (Whitespace)
        SYMBOL_MINUS                              =  3, // '-'
        SYMBOL_NUM                                =  4, // '#'
        SYMBOL_AMP                                =  5, // '&'
        SYMBOL_TIMES                              =  6, // '*'
        SYMBOL_COMMA                              =  7, // ','
        SYMBOL_DOT                                =  8, // '.'
        SYMBOL_SEMI                               =  9, // ';'
        SYMBOL_QUESTION                           = 10, // '?'
        SYMBOL_PLUS                               = 11, // '+'
        SYMBOL_B                                  = 12, // b
        SYMBOL_D                                  = 13, // d
        SYMBOL_DEAD                               = 14, // dead
        SYMBOL_F                                  = 15, // f
        SYMBOL_GEND                               = 16, // GEND
        SYMBOL_I                                  = 17, // i
        SYMBOL_NUMBER                             = 18, // number
        SYMBOL_O                                  = 19, // o
        SYMBOL_P                                  = 20, // P
        SYMBOL_PID                                = 21, // PID
        SYMBOL_R                                  = 22, // r
        SYMBOL_REND                               = 23, // REND
        SYMBOL_S                                  = 24, // s
        SYMBOL_SEP                                = 25, // sep
        SYMBOL_START                              = 26, // START
        SYMBOL_STRINGMINUSTERMINATOR              = 27, // string-terminator
        SYMBOL_T                                  = 28, // T
        SYMBOL_U                                  = 29, // u
        SYMBOL_V                                  = 30, // v
        SYMBOL_W                                  = 31, // w
        SYMBOL_X                                  = 32, // X
        SYMBOL_ADDMINUSBONUSMINUSSUBSTANCE        = 33, // <add-bonus-substance>
        SYMBOL_ADDMINUSDANGEROUSMINUSSUBSTANCE    = 34, // <add-dangerous-substance>
        SYMBOL_ADDMINUSDESTRMINUSSUBSTANCE        = 35, // <add-destr-substance>
        SYMBOL_ADDMINUSHIGHTEMPMINUSSUBSTANCE     = 36, // <add-hightemp-substance>
        SYMBOL_ADDMINUSINDESTRMINUSSUBSTANCE      = 37, // <add-indestr-substance>
        SYMBOL_ADDMINUSINFO                       = 38, // <add-info>
        SYMBOL_ADDMINUSSUBSTANCE                  = 39, // <add-substance>
        SYMBOL_BOMBSMINUSLEFT                     = 40, // <bombs-left>
        SYMBOL_BOMBMINUSSTRENGTH                  = 41, // <bomb-strength>
        SYMBOL_BONUSMINUSTYPE                     = 42, // <bonus-type>
        SYMBOL_BOOMMINUSTIME                      = 43, // <boom-time>
        SYMBOL_CELLMINUSPOSITION                  = 44, // <cell-position>
        SYMBOL_CHANGEMINUSINFO                    = 45, // <change-info>
        SYMBOL_CHANGESMINUSPART                   = 46, // <changes-part>
        SYMBOL_DAMAGINGMINUSRANGE                 = 47, // <damaging-range>
        SYMBOL_DANGERMINUSLEVEL                   = 48, // <danger-level>
        SYMBOL_DANGERMINUSPART                    = 49, // <danger-part>
        SYMBOL_DETAILS                            = 50, // <details>
        SYMBOL_ENDMINUSTIME                       = 51, // <end-time>
        SYMBOL_FINISHMINUSGAMEMINUSINFO           = 52, // <finish-game-info>
        SYMBOL_FINISHMINUSROUNDMINUSINFO          = 53, // <finish-round-info>
        SYMBOL_GAMEMINUSINFO                      = 54, // <game-info>
        SYMBOL_INFECTED                           = 55, // <infected>
        SYMBOL_INFO                               = 56, // <info>
        SYMBOL_INFOMINUSTERM                      = 57, // <info-term>
        SYMBOL_MAPMINUSCELLMINUSSIZE              = 58, // <map-cell-size>
        SYMBOL_MAPMINUSCHANGEMINUSINFO            = 59, // <map-change-info>
        SYMBOL_MAPMINUSDATA                       = 60, // <map-data>
        SYMBOL_MAPMINUSDATAMINUSLINE              = 61, // <map-data-line>
        SYMBOL_MAPMINUSINFO                       = 62, // <map-info>
        SYMBOL_MAPMINUSSYMBOL                     = 63, // <map-symbol>
        SYMBOL_PLAYERMINUSSCORE                   = 64, // <player-score>
        SYMBOL_RANK                               = 65, // <rank>
        SYMBOL_RANKMINUSSCOREMINUSINFO            = 66, // <rank-score-info>
        SYMBOL_REMOVEMINUSBONUSMINUSSUBSTANCE     = 67, // <remove-bonus-substance>
        SYMBOL_REMOVEMINUSDANGEROUSMINUSSUBSTANCE = 68, // <remove-dangerous-substance>
        SYMBOL_REMOVEMINUSDESTRMINUSSUBSTANCE     = 69, // <remove-destr-substance>
        SYMBOL_REMOVEMINUSHIGHTEMPMINUSSUBSTANCE  = 70, // <remove-hightemp-substance>
        SYMBOL_REMOVEMINUSINFO                    = 71, // <remove-info>
        SYMBOL_REMOVEMINUSSUBSTANCE               = 72, // <remove-substance>
        SYMBOL_SAPKAMINUSDATA                     = 73, // <sapka-data>
        SYMBOL_SAPKAMINUSINFO                     = 74, // <sapka-info>
        SYMBOL_SAPKAMINUSINFOMINUSEX              = 75, // <sapka-info-ex>
        SYMBOL_SAPKAMINUSINITMINUSINFO            = 76, // <sapka-init-info>
        SYMBOL_SAPKASMINUSPART                    = 77, // <sapkas-part>
        SYMBOL_SCORE                              = 78, // <score>
        SYMBOL_SPEED                              = 79, // <speed>
        SYMBOL_STARTMINUSROUNDMINUSINFO           = 80, // <start-round-info>
        SYMBOL_TIMEMINUSPART                      = 81, // <time-part>
        SYMBOL_XMINUSCELL                         = 82, // <x-cell>
        SYMBOL_XMINUSCOORD                        = 83, // <x-coord>
        SYMBOL_YMINUSCELL                         = 84, // <y-cell>
        SYMBOL_YMINUSCOORD                        = 85  // <y-coord>
    };
}

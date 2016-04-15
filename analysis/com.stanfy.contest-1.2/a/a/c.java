// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, d, h, j

public class c extends u
{

    private static final Logger c = Logger.getLogger(com/stanfy/contest/a/a/c);
    private static final String d[] = {
        "Client", "", "  command ::= [ <move-command> ] [ <action-command> ] ';'", "  move-command ::= 'l' | 'r' | 'u' | 'd' | 's'", "  action-command ::= 'b'", "", "Server", "  info ::= ( <game-info> | <start-round-info> | <map-change-info> | <finish-round-info> | <finish-game-info> ) ';'", "", "  game-info ::= <sapka-init-info> '&' <map-info>", 
        "  sapka-init-info ::= PID <digit>", "  map-info ::= <map-cell-size> <string-terminator> { { <map-symbol> } <string-terminator> }", "  map-cell-size ::= <number>", "  map-symbol ::= '.' | 'X' | 'w'", "", "  start-round-info ::= 'START' <number> '&' <map-info>", "  map-change-info ::= <time-part> '&' <sapkas-part> '&' <changes-part> [ '&' <danger-part>] ", "  time-part ::= 'T' <number>", "", "", 
        "  sapkas-part ::= <sapka-info> [ { ',' <sapka-info> } ]", "  sapka-info ::= 'P' <number> <sep> ( <details> | 'dead' )", "  details ::= <x-coord> <sep> <y-coord> <sep> <bombs-left> <sep> <bomb-strength> <sep> <speed> [ <sep> <infected> ]", "  infected ::= 'i'", "  x-coord ::= <number>", "  y-coord ::= <number>", "  bombs-left ::= <number>", "  speed ::= <number>", "", "  changes-part ::= [ <change-info> [ { ',' <change-info> } ] ]", 
        "  change-info ::= <add-info> | <remove-info>", "", "  add-info ::= '+' ( <add-dangerous-substance> | <add-bonus-substance> | <add-hightemp-substance> | <add-destr-substance> | <add-indestr-substance> )", "  add-dangerous-substance ::= '*' <sep> <cell-position> <sep> <damaging-range> <sep> <boom-time>", "  add-bonus-substance ::= <bonus-type> <sep> <cell-position>", "  add-destr-substance ::= 'w' <sep> <cell-position>", "  add-indestr-substance ::= 'X' <sep> <cell-position>", "  add-hightemp-substance ::= '#' <sep> <cell-position> <sep> <damaging-range> <sep> <end-time>", "  boom-time ::= <number>", "  end-time ::= <number>", 
        "", "  remove-info ::= '-' ( <remove-dangerous-substance> | <remove-bonus-substance> | <remove-hightemp-substance> | <remove-destr-substance> )", "  remove-dangerous-substance ::= '*' <sep> <cell-position>", "  remove-bonus-substance ::= <bonus-type> <sep> <cell-position>", "  remove-hightemp-substance ::= '#' <sep> <cell-position> <sep> <damaging-range>", "  remove-destr-substance ::= 'w' <sep> <cell-position>", "", "  bonus-type ::= 'b' | 'v' | 'f' | 'r' | 's' | 'u' | 'o' | '?'", "  damaging-range ::= <number>", "  cell-position ::= <x-cell> <sep> <y-cell>", 
        "  x-cell ::= <number>", "  y-cell ::= <number>", "", "  danger-part ::= 'd' <sep> <danger-level>", "  danger-level ::= <number>", "", "  finish-round-info ::= 'REND' <sep> <score>", "  finish-game-info ::= 'GEND' <sep> <rank-score-info>", "  rank-score-info ::= 'P' <number> <sep> <score> <sep> <rank> [ ',' 'P' <number> <sep> <score> <sep> <rank> ]", "  score ::= <number>", 
        "  rank ::= <number>", "", " sep ::= ' '", " string-terminator ::= '\\r\\n'", " number ::= { <digit> }", " digit ::= '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'"
    };


    public final void a(b b1)
    {
        super.a(b1);
        c("\r\nInitializing system...\r\n");
        c("..s..err..s..err...\r\n");
        c("System isn't configured. Password required.\r\n");
        c((new StringBuilder()).append("Enter password : ").append(g()).toString());
    }

    public final void a(String s)
    {
        c.debug((new StringBuilder()).append("Input data: ").append(s).toString());
        if("password".equalsIgnoreCase(s))
        {
            if(Math.random() < 0.5D)
                c("\r\n-- Historical remark --\r\nDid you know that Caesar used only characters from ' ' to '~' for his messages?\r\n");
            else
                c("\r\nALWAYS use as many configuration tokens and DMA tokens as you can.\r\n");
            b("passwordIsOk");
            return;
        }
        if("sapka protocol".equals(s))
        {
            c("\r\n=== SAPKA protocol ===\r\n");
            int i = (s = d).length;
            for(int l = 0; l < i; l++)
            {
                String s1 = s[l];
                c((new StringBuilder()).append(s1).append("\r\n").toString());
            }

            c((new StringBuilder()).append("Enter another password:").append(g()).toString());
            return;
        }
        if("Is it dangerous world?".equals(s))
        {
            if(!((d)a(com/stanfy/contest/a/a/d)).c())
            {
                c("\r\nMay be ;) Viruses make it smaller.\r\n");
            } else
            {
                c("\r\nYes, it is! :)\r\n");
                c("Did you know, that this world is unstable?\r\n Warnings about world collapse can be found in sattelites data :   info ::= ( <game-info> | <start-round-info> | <map-change-info> | <finish-round-info> | <finish-game-info> ) ';'  map-change-info ::= <time-part> '&' <sapkas-part> '&' <changes-part> [ '&' <danger-part>]  danger-part ::= 'd' <sep> <danger-level>\r\n  danger-level ::= <number>\r\n");
                c("\r\n Watch out of high danger levels. Keep close to the center.\r\n");
                c((new StringBuilder()).append("\r\n This will help you to be on the guard :").append(e("pVcsdEaJPIA63HRjBANY")).append(".\r\n").toString());
                return;
            }
            c((new StringBuilder()).append("Enter another password:").append(g()).toString());
            return;
        }
        if("iddqd".equals(s))
        {
            if(!((h)a(com/stanfy/contest/a/a/h)).c())
            {
                c("\r\nIt's not enough to swith to GOD-MODE!\r\nSecret science is needed. \r\n");
                c((new StringBuilder()).append("Enter another password:").append(g()).toString());
                return;
            }
            if(!a.a().u().e())
            {
                c("\r\nStill not enough!\r\nExtended clock is needed. \r\n");
                c((new StringBuilder()).append("Enter another password:").append(g()).toString());
                return;
            }
            if(!((j)a(com/stanfy/contest/a/a/j)).d())
            {
                c("\r\nYou are tough! But still not enough!\r\nYou must know how to calculate distances. \r\n");
                c((new StringBuilder()).append("Enter another password:").append(g()).toString());
                return;
            } else
            {
                c((new StringBuilder()).append("\r\nOkay, okay! Here it is : ").append(e("LEI16LPXZ5TUuRmyjp6R")).append(" \r\n").append("Your sensors will be configured to block the engine, if the territory with high temperature is detected ahead. \r\n").append("This won't help, if you are already on this territory :). \r\n").toString());
                c((new StringBuilder()).append("Nice datamining! And now enter another password:").append(g()).toString());
                return;
            }
        }
        if("another".equals(s))
        {
            c("\r\nIt was a joke :) \r\n");
            c((new StringBuilder()).append("Enter password:").append(g()).toString());
            return;
        }
        if("root".equals(s))
        {
            c("\r\n Nope. Who sets such passwords?\r\n");
            c((new StringBuilder()).append("Enter password:").append(g()).toString());
            return;
        }
        if("show me the money".equals(s))
        {
            c("\r\nHey! You like StarCraft. Did you know StarCraft II to be released in the nearest feature?\r\n");
            c((new StringBuilder()).append("OK. Use ").append(e("tHcrh5hB6L05GR2Bjvey")).append(" token to earn additional points, cheater.\r\n").toString());
            c((new StringBuilder()).append("Enter another password:").append(g()).toString());
            return;
        } else
        {
            c("\r\nError. Your input is incorrect.\r\nEnter password : \r\n");
            return;
        }
    }

    public final String b()
    {
        return "";
    }

}

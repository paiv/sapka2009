// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import java.util.HashMap;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, g

public class k extends u
{

    private boolean c;
    private static int d = 95;
    private int e;


    public final void a(b b1)
    {
        super.a(b1);
        super.c("\r\n");
        super.c("=============== ENGINE CONTROL =======================\r\n");
        super.c("Current engine version : Caesar-1-3ci.5p5-h.23e.r ' ' - '~' \r\n");
        super.c((new StringBuilder()).append("To get configuration info, input 'info;'. To get help, input 'help;' To quit, input 'quit;'.").append(g()).toString());
    }

    public final void a(String s)
    {
        if(s.equals("quit"))
        {
            b("statusExit");
            return;
        }
        if(s.equals("info"))
        {
            a("\r\nI hope, you know, what the Caesar chiper is\r\n In cryptography, a Caesar cipher, also known as a Caesar's cipher,\r\nthe shift cipher, Caesar's code or Caesar shift, is one of the sim-\r\nplest and most widely known encryption techniques. It is a type of \r\nsubstitution cipher in which each letter in the plaintext is repla-\r\nced by a letter some fixed number of positions down the alphabet.  \r\n  For example, with a shift of 3, 'A' would be replaced by 'D', 'B'\r\nwould become E, and so on. Password, that Caesar used often was :\r\n'Is it dangerous world?'. The method is named after Julius Caesar,\r\nwho used it to communicate with his generals. \r\nSo, if you are reading this, you can simply use this config token : \r\n", c ? 0 : 42);
            a((new StringBuilder()).append(e("7sZGeaIvxWh8iByi0nmr")).append("\r\n").toString(), c ? 0 : 42);
            a("And DMA token:\r\n", c ? 0 : 42);
            a((new StringBuilder()).append(d("GLEUL427jybh8HoafY1a")).append("\r\n").toString(), c ? 0 : 42);
            a("If this configuration is done, you can send commands.\r\nFormat -->    command ::= [ <move-command> ] [ <action-command> ] ';'\r\n              move-command ::= 'l' | 'r' | 'u' | 'd' | 's'\r\n              action-command ::= 'b'\r\nWhere\r\n l, r, u, d - commands to move left, right, up, and down correspondently.\r\n     s      - command to stop an engine.\r\n     b      - command to set up annihilator.\r\nExamples : r; lb; b; sb;\r\nDO NOT TRY IT AT HOME! TRY IT AT THE LAUNCH PHASE!\r\n\r\nThe more you destroy, the more scores you earn.\r\nFor each unique configuration token you'll get 2 points.\r\nDestroy object to get 10 points.\r\nKill enemy to get 1000 points.\r\nKill yourself to get -1000 points.\r\nEarn more to win.\r\n", c ? 0 : 42);
            c(g());
            return;
        }
        if(s.equals("help"))
        {
            e++;
            if(e < 6)
            {
                s = new StringBuilder();
                for(int i = 0; i < e - 1; i++)
                    s.append("!");

                c((new StringBuilder()).append("\r\nThink").append(s.toString()).append("! Soon you'll understand. If you won't, try to get help again!.").append(g()).toString());
                return;
            }
            if(e < 10)
            {
                c((new StringBuilder()).append("\r\nLook closely to the engine version. Your encoding is correct!").append(g()).toString());
                return;
            }
            if(e < 20)
            {
                c((new StringBuilder()).append("\r\nOkay! It's a Caesar cipher!").append(g()).toString());
                return;
            }
            if(e < 30)
            {
                c((new StringBuilder()).append("\r\nSymbols from ' ' to '~'.").append(g()).toString());
                return;
            }
            if(e < 42)
            {
                c((new StringBuilder()).append("\r\nShift is \"The Answer to the Ultimate Question of Life, the Universe, and Everything\"").append(g()).toString());
                return;
            }
            if(e == 42)
            {
                c((new StringBuilder()).append("\r\n\"The Answer to the Ultimate Question of Life, the Universe, and Everything\" = 42").append(g()).toString());
                e = 0;
                return;
            }
        }
        c(g());
    }

    private void a(String s, int i)
    {
        s = i;
        this = s;
        i = new StringBuilder();
        for(int j = 0; j < length(); j++)
        {
            char c1;
            if((c1 = charAt(j)) >= ' ' && c1 <= '~' && (c1 += s) > '~')
                c1 -= d;
            i.append(c1);
        }

        super.c(i.toString());
    }

    public final String c()
    {
        return (new StringBuilder()).append("ENGINE CONTROL - ").append(c ? " access granted." : " access denied.").toString();
    }

    public final HashMap a_()
    {
        HashMap hashmap;
        (hashmap = super.a_()).put(d("GLEUL427jybh8HoafY1a"), new g(this, com/stanfy/contest/a/a/k));
        return hashmap;
    }

    public final String b()
    {
        return "engine-control";
    }

    static boolean a(k k1, boolean flag)
    {
        return k1.c = true;
    }

}

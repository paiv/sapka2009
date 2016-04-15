// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;

// Referenced classes of package com.stanfy.contest.a.a:
//            u

public class a extends u
{

    private String c;

    public a()
    {
        c = "Caesar";
    }

    private static String a(String s, String s1)
    {
        s1 = s1.toCharArray();
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for(int j = 0; i < s.length(); j = (j + 1) % s1.length)
        {
            stringbuilder.append("\\").append(s.charAt(i) ^ s1[j]);
            i++;
        }

        return stringbuilder.toString();
    }

    private String c()
    {
        this = a.a().u();
        return (new StringBuilder()).append("Internal clock: ").append(!a() || !e() ? e() || !a() ? "disabled" : "eXtended clOck Routines - disabled" : "enabled").append(".").toString();
    }

    public final void a(b b1)
    {
        super.a(b1);
        c("\r\n================== Internal clock ==============================================\r\n");
        c("Includes:\r\n");
        c(" - basic clock\r\n");
        c(" - eXtended clOck Routines\r\n");
        String as[] = {
            "\r\nInstructions are available after configuring.\r\nInput 'info;' to get them.\r\n"
        };
        long l = 1000L;
        Object obj1 = this;
        a(as, l);
        c("Input 'quit;' to return.\r\n\r\n");
        b1 = e("NTmx9KWzTuXSFybcgrBA");
        Object obj = e("X1oj7Fs9xqvFOZugh1yE");
        as = (new String[] {
            "To switch on basic clock use configuration token: "
        });
        l = 1000L;
        obj1 = this;
        a(as, l);
        c(a((new StringBuilder()).append(((String) (obj = b1))).append("\r\nTo switch on eXtended clOck Routines use configuration token: ").append(a(((String) (obj1 = obj)), ((String) (obj)))).toString(), ((a) (b1 = this)).c));
        c((new StringBuilder()).append("\r\n\"I came, I saw, I conquered.\"").append(g()).toString());
    }

    public final void a(String s)
    {
        if(s.equals("info"))
        {
            s = a.a().u();
            c((new StringBuilder()).append("\r\n").append(c()).append("\r\n\r\n").toString());
            if(s.a())
            {
                c("Internal clock is configured to recognize notifications about starting the new round ");
                c("(START) and finishing the current one (REND).\r\n");
                c("Format --> info ::= ( <game-info> | <start-round-info> | <map-change-info> | <finish-round-info> | <finish-game-info> ) ';'");
                c("           start-round-info ::= 'START' <number> '&' <map-info>\r\n");
                c("           finish-round-info ::= 'REND' <sep> <score>\r\n");
                c("           sep ::= ' '\r\n");
                c("           score ::= <number>\r\n");
                c("\r\n");
            }
            if(s.e())
            {
                c("Extended clock routines are synchronized with the remote server and can parse time of events.\r\n");
                c("Format --> map-change-info ::= <time-part> '&' <sapkas-part> '&' <changes-part> [ '&' <danger-part>]\r\n");
                c("           time-part ::= 'T' <number>\r\n");
                c("\r\nNumber after 'T' defines the internal server time (in ticks). One tick is about 50 milliseconds.\r\n");
                c("Server analyzes data sent from Sapka-clients every tick during the game. After analyzing it sends response to the Sapka-client that starts with 'T' <number> as a rule.\r\n");
            }
            c(g());
            return;
        }
        if(s.equals("quit"))
        {
            b("statusExit");
            return;
        } else
        {
            c((new StringBuilder()).append("\r\nUnknown command").append(g()).toString());
            return;
        }
    }

    public final String a()
    {
        return c();
    }

    public final String b()
    {
        return "iclock";
    }
}

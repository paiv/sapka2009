// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;

// Referenced classes of package com.stanfy.contest.a.a:
//            u

public class b extends u
{

    private String c;


    private static char[] a(char c1, int i)
    {
        i = new char[i];
        for(int j = 0; j < i.length; j++)
            i[j] = a(c1);

        return i;
    }

    private static char a(char c1)
    {
        switch(c1)
        {
        case 43: // '+'
            return '-';

        case 45: // '-'
            return '+';

        case 60: // '<'
            return '>';

        case 62: // '>'
            return '<';

        case 91: // '['
            return ']';

        case 93: // ']'
            return '[';

        case 46: // '.'
            return ',';

        case 44: // ','
            return '.';
        }
        return c1;
    }

    private static String f(String s)
    {
        StringBuilder stringbuilder;
        (stringbuilder = new StringBuilder()).append(a('+', 11)).append(a('['));
        for(int i = 0; i < s.length(); i++)
        {
            int l = s.charAt(i) / 11;
            stringbuilder.append(a('>')).append(a('+', l));
        }

        stringbuilder.append(a('<', s.length()));
        stringbuilder.append(a('-'));
        stringbuilder.append(a(']'));
        for(int j = 0; j < s.length(); j++)
        {
            int i1 = s.charAt(j) % 11;
            stringbuilder.append(a('>')).append(a('+', i1)).append(a('.'));
        }

        return stringbuilder.toString();
    }

    public final void a(com.stanfy.contest.a.a.b.b b1)
    {
        super.a(b1);
        c = e("zJDqE2CkZi1VsMbMBCIp");
        c("\r\n================== AAR subsytem ================================================\r\n");
        String as[] = {
            "\r\nScanning associative memory", ".", ".", ".", ".\r\n"
        };
        long l = 1000L;
        b1 = this;
        a(as, l);
        c("ERROR!!! Information dedicated to process map resources is damaged!\r\n");
        as = (new String[] {
            ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", 
            ".", ".", ".", ".", ".", ".", ".", ".\r\n"
        });
        l = 100L;
        b1 = this;
        a(as, l);
        c("finish-game-info ::= 'GEND' <sep> <rank-score-info>\r\n  rank-score-info ::= 'P' <number> <sep> <score> <sep> <rank> [ ',' 'P' <number> <sep> <score> <sep> <rank> ]\r\n  score ::= <number>\r\n  rank ::= <number>\r\n");
        as = (new String[] {
            ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", 
            ".", ".", ".", ".", ".", ".", ".", ".\r\n"
        });
        l = 100L;
        b1 = this;
        a(as, l);
        as = (new String[] {
            ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", 
            ".", ".\r\n"
        });
        l = 100L;
        b1 = this;
        a(as, l);
        c("This part of the memory contains configuration token that activates the adoption of additional resources (bonuses).\r\n");
        c("Trying to recover.");
        as = (new String[] {
            ".", ".", ".", " hm...\r\n"
        });
        l = 1000L;
        b1 = this;
        a(as, l);
        as = (new String[] {
            "                      Unknown syntax detected. Loading possible description from\r\n"
        });
        l = 1000L;
        b1 = this;
        a(as, l);
        c("                                          http://uk.wikipedia.org/wiki/Brainfuck\r\n");
        c("                                                           Something went wrong.\r\n");
        c("                                                               Attempt failed :(\r\n");
        as = (new String[] {
            "                                                                 Memory content:\r\n", f(f(c))
        });
        l = 1000L;
        b1 = this;
        a(as, l);
        b("statusExit");
    }

    public final void a(String s)
    {
    }

    public final String a()
    {
        if(a.a().u().x())
            return (new StringBuilder()).append("AAR enabled. Token: ").append(e("zJDqE2CkZi1VsMbMBCIp")).toString();
        else
            return "Adoption of Additional Resources (AAR) disabled.";
    }

    public final String b()
    {
        return "aar";
    }
}

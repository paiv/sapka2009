// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ah extends o
{

    private am a;

    ah(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.a(am.a(am1).pop()).intValue();
        int i = am.a(am.a(am1).pop()).intValue();
        String s = am.b(am.a(am1).pop());
        try
        {
            String s1 = s.substring(i, this);
            am.a(am1).push(s1);
            return s1;
        }
        catch(StringIndexOutOfBoundsException _ex)
        {
            throw y.a(s, i, this);
        }
    }

    public final String a()
    {
        return "Gets substring of source String, and puts result at top of stack\r\n FORMAT : <STRING> <INT(FROM)> <INT(TO)> SUBSTR -> <STRING> \r\n EXAMPLE: 'cooler' 0 4 SUBSTR . OUTPUT:cool";
    }
}

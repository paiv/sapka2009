// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ai extends o
{

    private am a;

    ai(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.a(am.a(am1).pop()).intValue();
        String s = am.b(am.a(am1).pop());
        try
        {
            String s1 = (new StringBuilder()).append(s.charAt(this)).append("").toString();
            am.a(am1).push(s1);
            return s1;
        }
        catch(StringIndexOutOfBoundsException _ex)
        {
            throw y.a(s, this, this);
        }
    }

    public final String a()
    {
        return "Gets character of String at specified position and puts it at top of stack\r\n FORMAT : <STRING> <INT(INDEX)>CHARAT -> <STRING> \r\n EXAMPLE: 'stake' 2 CHARAT . OUTPUT:a\r\n          'stake' 0 CHARAT . OUTPUT:s";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class v extends o
{

    private am a;

    v(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.a(am.a(am1).pop()).intValue();
        int i = am.a(am.a(am1).pop()).intValue();
        try
        {
            am.a(am1).push(Integer.valueOf(i % this));
            return Integer.valueOf(i % this);
        }
        catch(ArithmeticException _ex)
        {
            throw y.b();
        }
    }

    public final String a()
    {
        return "Divides number1 by number2 and returns only the remainder as result to top of stack\r\n Only Ints are allowed : <INT> <INT> % -> <INT>\r\n EXAMPLE: 3 2 % . OUTPUT:1\r\n          10 2 % . OUTPUT:0";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class t extends o
{

    private am a;

    t(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.a(am.a(am1).pop()).intValue();
        int i = am.a(am.a(am1).pop()).intValue();
        am.a(am1).push(Integer.valueOf(this * i));
        return Integer.valueOf(this * i);
    }

    public final String a()
    {
        return "Multiplies two operands at top of stack, returns result to top of stack\r\n Only Ints are allowed : <INT> <INT> * -> <INT>\r\n EXAMPLE: 3 2 * . OUTPUT:6\r\n          0 3 * . OUTPUT:0";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class z extends o
{

    private am a;

    z(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.a(am.a(am1).pop()).intValue();
        int i;
        this = (i = am.a(am.a(am1).pop()).intValue()) <= this ? 0 : -1;
        am.a(am1).push(Integer.valueOf(this));
        return Integer.valueOf(this);
    }

    public final String a()
    {
        return "Checks if variable2 GREATER than variable1, returns result at top of stack (0=FALSE or -1=TRUE)\r\n Only Ints are allowed : <INT2> <INT1>> -> <INT(BOOLEAN)>\r\n EXAMPLE: 2 3 > . OUTPUT:0";
    }
}

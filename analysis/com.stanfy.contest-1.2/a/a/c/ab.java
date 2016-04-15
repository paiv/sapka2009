// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ab extends o
{

    ab(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        this = ((ab) (am.a(am1).pop()));
        Object obj;
        this = (obj = am.a(am1).pop()).equals(this) ? -1 : 0;
        am.a(am1).push(Integer.valueOf(this));
        return Integer.valueOf(this);
    }

    public final String a()
    {
        return "Checks if variable2 is EQUAL to variable1, returns result at top of stack (0=FALSE or -1=TRUE)\r\n All Types are allowed : <OBJ2> <OBJ1> == -> <INT(BOOLEAN)>  \r\n EXAMPLE: 2 3 == . OUTPUT:0";
    }
}

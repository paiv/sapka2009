// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class q extends o
{

    q(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        this = ((q) (am.a(am1).peek()));
        am.a(am1).push(this);
        return this;
    }

    public final String a()
    {
        return "Duplicates object at top of stack\r\n All types are allowed : <OBJ1> DUP -> <OBJ1> <OBJ1>\r\n EXAMPLE: 3 2 DUP DROP . OUTPUT:2";
    }
}

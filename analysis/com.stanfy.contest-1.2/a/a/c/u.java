// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class u extends o
{

    u(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        this = ((u) (am.a(am1).pop()));
        Object obj = am.a(am1).pop();
        am.a(am1).push(this);
        am.a(am1).push(obj);
        return obj;
    }

    public final String a()
    {
        return "Swaps two objects at top of stack\r\n All types are allowed : <OBJ1> <OBJ2> SWAP -> <OBJ2> <OBJ1>\r\n EXAMPLE: 3 2 SWAP . OUTPUT:3\r\n          3 2 SWAP SWAP . OUTPUT:2";
    }
}

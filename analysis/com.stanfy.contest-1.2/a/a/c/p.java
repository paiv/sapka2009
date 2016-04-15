// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class p extends o
{

    private am a;

    p(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        return am.a(a).pop();
    }

    public final String a()
    {
        return "Removes object from top of stack\r\n All types are allowed : <OBJ1> DUP -> <>\r\n EXAMPLE: 3 2 1 DROP DROP . OUTPUT:3";
    }
}

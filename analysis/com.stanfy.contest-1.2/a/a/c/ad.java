// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ad extends o
{

    private am a;

    ad(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = (this = am.a(am.a(am1).pop()).intValue()) != 0 ? 0 : -1;
        am.a(am1).push(Integer.valueOf(this));
        return Integer.valueOf(this);
    }

    public final String a()
    {
        return "Checks if variable at top of stack EQUAL to ZERO, returns result at top of stack (0=FALSE or -1=TRUE)\r\n Only Int are alllowed : <INT> =0 -> <INT(BOOLEAN)>  \r\n EXAMPLE: 2 2 - =0 . OUTPUT:-1";
    }
}

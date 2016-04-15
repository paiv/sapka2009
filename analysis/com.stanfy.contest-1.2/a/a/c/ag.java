// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ag extends o
{

    private am a;

    ag(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = String.valueOf(this = am.a(am.a(am1).pop()).intValue());
        am.a(am1).push(this);
        return this;
    }

    public final String a()
    {
        return "Converts Int to String, and puts result at top of stack\r\n Only Int is alllowed : <INT> INTTOSTR -> <STRING> \r\n EXAMPLE: 42 INTTOSTR . OUTPUT:42";
    }
}

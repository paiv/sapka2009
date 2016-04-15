// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class ae extends o
{

    private am a;

    ae(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = length();
        am.a(am1).push(Integer.valueOf(this));
        return Integer.valueOf(this);
    }

    public final String a()
    {
        return "Gets string from top of stack and returns its length as result at top of stack\r\n Only String is alllowed : <STRING> LENGTH -> <INT> \r\n EXAMPLE: 'ababagalamaga' LENGTH . OUTPUT:13";
    }
}

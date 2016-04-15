// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class l extends o
{

    l(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        am.a(am1).clear();
        return "CLEAR";
    }

    public final String a()
    {
        return "Clears current stack. \r\nFORMAT  : CLEAR \r\nEXAMPLE : 2 3 4 CLEAR . ; puts 2 ints into stack, clears it, and gets top of stack. Result - stack is clear message.\r\n";
    }
}

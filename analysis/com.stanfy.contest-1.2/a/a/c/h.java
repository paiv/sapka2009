// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;


// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class h extends o
{

    h(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        return "LOAD_PREFIX";
    }

    public final String a()
    {
        return "Load-from-variable prefix. Gets data from variable and puts it at top of stack\r\nFORMAT  : @VARIABLE \r\nEXAMPLE : 3 ->C @C @C + ->C ; puts 3 in variable C, then gets it two times, calculates sum, and puts it back in C variable.\r\n";
    }
}

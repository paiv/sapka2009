// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import com.stanfy.contest.a.a.u;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class n extends o
{

    n(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        am.e(am1).b("statusExit");
        return "QUIT";
    }

    public final String a()
    {
        return "Quits from Fifth interpreter.. Doesn't changing stack.\r\n All types are allowed : <> QUIT -> <>";
    }
}

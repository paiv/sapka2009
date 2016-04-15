// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.b;

import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;

// Referenced classes of package com.stanfy.contest.a.b:
//            b

public final class c
    implements b
{

    private int a;
    private com.stanfy.contest.b.c b;

    public c(int i, com.stanfy.contest.b.c c1)
    {
        a = i;
        b = c1;
    }

    public final String a(k k1)
    {
        e e1 = k1 != null ? k1.u() : null;
        if(k1 == null || e1.a())
            return (new StringBuilder()).append("START").append(a).append("&").append(b.a(false, k1)).append(";").toString();
        else
            return null;
    }
}

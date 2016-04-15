// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.k;

// Referenced classes of package com.stanfy.contest.c:
//            g

public final class h
    implements g
{

    private h a;
    private g b;

    public h(g g1)
    {
        a = null;
        b = null;
        b = g1;
    }

    public final h a(g g1)
    {
        (g1 = new h(g1)).a = this;
        return g1;
    }

    public final String a(k k1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if(a != null)
            stringbuilder.append(a.a(k1));
        if(b != null && (this = b.a(k1)) != null && !isEmpty())
        {
            if(stringbuilder.length() > 0)
                stringbuilder.append(",");
            stringbuilder.append(this);
        }
        return stringbuilder.toString();
    }
}

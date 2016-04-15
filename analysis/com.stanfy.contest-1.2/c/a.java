// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.c;

// Referenced classes of package com.stanfy.contest.c:
//            f, g, h

public final class a
    implements f
{

    private a a;
    private f b;

    public a(f f1)
    {
        a = null;
        b = null;
        b = f1;
    }

    public final a a(f f1)
    {
        (f1 = new a(f1)).a = this;
        return f1;
    }

    public final g a(c c1)
    {
        g g1 = a != null ? a.a(c1) : null;
        this = b != null ? ((a) (b.a(c1))) : null;
        return (c1 = new h(g1)).a(this);
    }
}

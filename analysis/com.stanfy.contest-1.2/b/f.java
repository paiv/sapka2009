// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


// Referenced classes of package com.stanfy.contest.b:
//            h, e, k

public final class f extends h
{

    private k a;
    private long b;
    private int c;

    public f(k k1, int i, int j, long l)
    {
        super(i, j, k1.g());
        b = l;
        c = k1.j();
        a = k1;
    }

    public final long a()
    {
        return b;
    }

    public final int b()
    {
        return c;
    }

    public final char a(k k1)
    {
        return k1 == null || k1.u().m() ? '*' : '?';
    }

    public final k c()
    {
        return a;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


// Referenced classes of package com.stanfy.contest.b:
//            h, e, f, k

public final class b extends h
{

    private f a;
    private int b;

    public b(f f1, int i)
    {
        super(f1.e(), f1.d(), f1.g());
        b = 3;
        a = f1;
    }

    public final int a()
    {
        return b;
    }

    public final int b()
    {
        return a.b();
    }

    public final char a(k k1)
    {
        return k1 == null || k1.u().n() ? '#' : '?';
    }

    public final f c()
    {
        return a;
    }
}

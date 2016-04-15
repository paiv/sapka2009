// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


// Referenced classes of package com.stanfy.contest.b:
//            h, e, k, s, 
//            d

public final class o extends h
{

    private s a;
    private boolean b;

    public o(int i, int j, boolean flag, d d, s s1)
    {
        super(i, j, d);
        a = s1;
        b = flag;
    }

    public final char a(k k1)
    {
        if(k1 != null && (!k1.u().o() || b && !k1.u().p()))
            return '?';
        if(b)
            return '?';
        else
            return s.a(a);
    }

    public final s a()
    {
        return a;
    }

    public final void b(k k1)
    {
        a.a(k1);
    }

    public final void c(k k1)
    {
        a.b(k1);
    }
}

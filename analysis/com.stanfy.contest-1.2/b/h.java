// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


// Referenced classes of package com.stanfy.contest.b:
//            d, k

public class h
    implements Cloneable
{

    private d a;
    private int b;
    private int c;

    public h(int i, int j, d d1)
    {
        b = j;
        c = i;
        a = d1;
    }

    public char a(k k)
    {
        return '?';
    }

    public int d()
    {
        return b;
    }

    public void a(int i)
    {
        b = i;
    }

    public int e()
    {
        return c;
    }

    public void b(int i)
    {
        c = i;
    }

    protected final h f()
    {
        return (h)super.clone();
    }

    public final d g()
    {
        return a;
    }

    protected volatile Object clone()
    {
        return (h)super.clone();
    }
}

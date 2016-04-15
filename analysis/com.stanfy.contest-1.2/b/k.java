// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import java.util.*;

// Referenced classes of package com.stanfy.contest.b:
//            h, d, e, o, 
//            s

public class k extends h
{

    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j[];
    private int k[];
    private e l;
    private static boolean m = !com/stanfy/contest/b/k.desiredAssertionStatus();

    public k(int i1, d d1)
    {
        super(0, 0, d1);
        a = i1;
        j = new int[com.stanfy.contest.b.s.values().length];
        k = new int[com.stanfy.contest.b.s.values().length];
        l = new e();
        a();
    }

    public final void a()
    {
        f = 2;
        g = 1;
        e = g().d();
        h = 0;
        i = true;
        for(int i1 = 0; i1 < j.length; i1++)
        {
            j[i1] = 0;
            k[i1] = 0;
        }

    }

    public final int e()
    {
        return d / g().h();
    }

    public final int d()
    {
        return c / g().h();
    }

    public final void b(int i1)
    {
        super.b(i1);
        int j1 = g().h();
        d = i1 * j1 + d % j1;
    }

    public final void a(int i1)
    {
        super.a(i1);
        int j1 = g().h();
        c = i1 * j1 + c % j1;
    }

    public final int b()
    {
        return a;
    }

    public final int c()
    {
        return c;
    }

    public final void c(int i1)
    {
        c = i1;
    }

    public final int h()
    {
        return d;
    }

    public final void d(int i1)
    {
        d = i1;
    }

    public final int i()
    {
        if(!a(s.b))
            return e;
        if((this = g().d() >> 1) > 0)
            return this;
        else
            return 1;
    }

    public final void e(int i1)
    {
        if(!l.y())
            return;
        if(i1 < g().i())
            e = i1;
    }

    public final int j()
    {
        if(a(s.d))
            return 0;
        else
            return f;
    }

    public final void f(int i1)
    {
        if(!l.w())
        {
            return;
        } else
        {
            f = i1;
            return;
        }
    }

    public final int k()
    {
        return g;
    }

    public final void g(int i1)
    {
        if(!l.x())
        {
            return;
        } else
        {
            g = i1;
            return;
        }
    }

    public final int l()
    {
        return h;
    }

    public final boolean m()
    {
        return i;
    }

    public final void a(boolean flag)
    {
        i = false;
    }

    public final boolean n()
    {
        return !a(s.c) && g - h > 0;
    }

    public final void o()
    {
        h++;
    }

    public final void p()
    {
        h--;
    }

    public final boolean q()
    {
        return !a(s.a);
    }

    private boolean a(s s1)
    {
        return j[s1.ordinal()] > 0;
    }

    public final void a(s s1, boolean flag)
    {
        s1 = s1.ordinal();
        if(flag)
            j[s1]++;
        else
            j[s1]--;
        if(!m && j[s1] < 0)
            throw new AssertionError();
        else
            return;
    }

    public final void a(s s1, int i1)
    {
        k[s1.ordinal()] = i1;
    }

    public final int[] r()
    {
        return k;
    }

    public final List b(k k1)
    {
        LinkedList linkedlist = new LinkedList();
        s as[];
        int i1 = (as = s.e).length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            s s1 = as[j1];
            if(a(s1) && !k1.a(s1))
            {
                k1.j[s1.ordinal()]++;
                k1.k[s1.ordinal()] = k[s1.ordinal()];
                linkedlist.add(s1);
            }
        }

        return linkedlist;
    }

    public final boolean s()
    {
        s as[];
        int i1 = (as = s.e).length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            s s1 = as[j1];
            if(a(s1))
                return true;
        }

        return false;
    }

    public final String t()
    {
        StringBuilder stringbuilder = new StringBuilder();
        s as[];
        int i1 = (as = s.e).length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            s s1 = as[j1];
            if(a(s1))
                stringbuilder.append(s1.a());
        }

        return stringbuilder.toString();
    }

    public final String toString()
    {
        return (new StringBuilder()).append("BPlayer(").append(b).append("){posX=").append(c).append(", posY=").append(d).append(", bonusStatus=").append(Arrays.toString(j)).append(", healTicks=").append(Arrays.toString(k)).append("}").toString();
    }

    public final e u()
    {
        return l;
    }

    public final String v()
    {
        return b;
    }

    public final void a(String s1)
    {
        b = s1;
    }

}

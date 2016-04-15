// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import java.io.*;
import java.util.*;

// Referenced classes of package com.stanfy.contest.b:
//            b, d, e, h, 
//            i, j, k, m, 
//            v

public final class c
{

    private List a;
    private i b;
    private d c;
    private v d;
    private int e[];
    private boolean f;
    private int g;

    public c(InputStream inputstream, InputStream inputstream1)
    {
        a = new ArrayList();
        f = false;
        g = 0;
        c = new d(inputstream1);
        b = new i(inputstream, c);
        d = new v();
        e = new int[b.f()];
    }

    public final i a()
    {
        return b;
    }

    public final v b()
    {
        return d;
    }

    public final int c()
    {
        return g;
    }

    public final void a(int l)
    {
        g = l;
    }

    public final String toString()
    {
        return a(true, ((k) (null)));
    }

    public final String a(boolean flag, k k1)
    {
        StringBuilder stringbuilder;
        int i1;
        int j1;
        int l1;
        int j2;
        Iterator iterator;
        e e1 = k1 != null ? k1.u() : null;
        (stringbuilder = new StringBuilder()).append(b.c()).append("\r\n");
        i1 = stringbuilder.length();
        j1 = b.a();
        l1 = b.b();
        LinkedList linkedlist = new LinkedList();
        for(int i2 = 0; i2 < l1; i2++)
        {
            for(int k2 = 0; k2 < j1; k2++)
            {
                boolean flag1 = false;
                if(flag && (k1 == null || k1.u().g()))
                {
                    Iterator iterator1 = a.iterator();
                    do
                    {
                        if(!iterator1.hasNext())
                            break;
                        k k3 = (k)iterator1.next();
                        if(!flag1 && k3.m() && (k3.d() == k2 && k3.e() == i2))
                        {
                            stringbuilder.append(k3.s() ? "I" : ((Object) (Integer.valueOf(k3.b()))));
                            flag1 = true;
                        }
                    } while(true);
                }
                if(flag1)
                    continue;
                h h1;
                if((h1 = b.a(i2, k2).a()) instanceof b)
                    linkedlist.add((b)h1);
                stringbuilder.append(h1.a(k1));
            }

            if(e1 == null || e1.c())
                stringbuilder.append("\r\n");
        }

        if(!flag)
            break MISSING_BLOCK_LABEL_742;
        j2 = j1 + "\r\n".length();
        iterator = linkedlist.iterator();
_L2:
        int l;
        b b1;
        int l2;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_742;
        l2 = (b1 = (b)iterator.next()).b();
        int i3 = b1.e() * j2 + b1.d() + i1;
        flag = false;
        l = i3;
        do
        {
            if(flag > l2 || b1.d() - flag < 0 || !b.a(b1.e(), b1.d() - flag).d())
                break;
            stringbuilder.setCharAt(l, b1.a(k1));
            if(!b.a(b1.e(), b1.d() - flag).b())
                break;
            flag++;
            l--;
        } while(true);
        flag = false;
        l = i3;
        do
        {
            if(flag > l2 || b1.d() + flag >= j1 || !b.a(b1.e(), b1.d() + flag).d())
                break;
            stringbuilder.setCharAt(l, b1.a(k1));
            if(!b.a(b1.e(), b1.d() + flag).b())
                break;
            flag++;
            l++;
        } while(true);
        flag = false;
        l = i3;
        do
        {
            if(flag > l2 || b1.e() - flag < 0 || !b.a(b1.e() - flag, b1.d()).d())
                break;
            stringbuilder.setCharAt(l, b1.a(k1));
            if(!b.a(b1.e() - flag, b1.d()).b())
                break;
            flag++;
            l -= j2;
        } while(true);
        flag = false;
        l = i3;
_L4:
        if(flag > l2 || b1.e() + flag >= l1 || !b.a(b1.e() + flag, b1.d()).d()) goto _L2; else goto _L1
_L1:
        stringbuilder.setCharAt(l, b1.a(k1));
        if(!b.a(b1.e() + flag, b1.d()).b()) goto _L2; else goto _L3
_L3:
        flag++;
        l += j2;
          goto _L4
        return stringbuilder.toString();
    }

    public final k d()
    {
        int l = e().size();
        k k1 = new k(l, c);
        e().add(k1);
        b(k1);
        return k1;
    }

    private void b(k k1)
    {
        this = b.d();
        k1.a(d());
        k1.b(e());
    }

    public final List e()
    {
        if(a == null)
            a = new ArrayList();
        return a;
    }

    public final k b(int l)
    {
        if(a == null || a.size() <= l)
            return null;
        else
            return (k)a.get(l);
    }

    public final void f()
    {
        f = false;
        b.e();
        d.d();
        g = 0;
        k k1;
        for(Iterator iterator = a.iterator(); iterator.hasNext(); b(k1))
            (k1 = (k)iterator.next()).a();

    }

    public final int g()
    {
        return c.e();
    }

    public final void a(int l, int i1)
    {
        e[l] += i1;
    }

    public final int[] h()
    {
        return e;
    }

    public final void a(k k1)
    {
        k1.a(false);
        k1 = 0;
        Iterator iterator = a.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            k k2;
            if((k2 = (k)iterator.next()).m())
                k1++;
        } while(true);
        f = k1 < 2;
    }

    public final boolean i()
    {
        return f || d.a() >= 3600;
    }

    public final d j()
    {
        return c;
    }

    public final List b(int l, int i1)
    {
        LinkedList linkedlist = new LinkedList();
        this = a.iterator();
        do
        {
            if(!hasNext())
                break;
            k k1;
            if((k1 = (k)next()).e() == l && k1.d() == i1)
                linkedlist.add(k1);
        } while(true);
        return linkedlist;
    }
}

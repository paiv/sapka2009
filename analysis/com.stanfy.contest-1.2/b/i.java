// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import java.io.*;
import java.util.*;

// Referenced classes of package com.stanfy.contest.b:
//            b, d, f, g, 
//            h, j, k, m, 
//            o, t

public final class i
{

    private List a;
    private m b[][];
    private m c[][];
    private d d;

    public i(InputStream inputstream, d d1)
    {
        a = new ArrayList();
        d = d1;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        i l;
        b = new m[(l = this).d.g()][(l = this).d.f()];
        for(int i1 = 0; i1 < d1.g(); i1++)
        {
            String s = inputstream.readLine();
            for(int j1 = 0; j1 < Math.min(s.length(), d1.f()); j1++)
            {
                b[i1][j1] = new m();
                switch(s.charAt(j1))
                {
                case 119: // 'w'
                    b[i1][j1].add(new g(i1, j1, d1));
                    break;

                case 88: // 'X'
                    b[i1][j1].add(new t(i1, j1, d1));
                    break;

                case 111: // 'o'
                    a.add(new j(i1, j1, d1));
                    break;
                }
            }

        }

        c = a(b);
        inputstream.close();
        g();
    }

    public final int a()
    {
        return d.f();
    }

    public final int b()
    {
        return d.g();
    }

    public final int c()
    {
        return d.h();
    }

    public final m a(int l, int i1)
    {
        if(l < 0 || i1 < 0 || l >= b.length || i1 >= b[0].length)
            return null;
        else
            return b[l][i1];
    }

    private void g()
    {
        j j1;
        for(Iterator iterator = a.iterator(); iterator.hasNext(); (j1 = (j)iterator.next()).a(true));
        for(int l = 0; l < a.size() << 1; l++)
        {
            int i1 = (int)(Math.random() * (double)a.size());
            int k1 = (int)(Math.random() * (double)a.size());
            j j2 = (j)a.get(i1);
            j j3 = (j)a.get(k1);
            a.set(i1, j3);
            a.set(k1, j2);
        }

    }

    public final j d()
    {
        j j1;
        for(this = a.iterator(); hasNext();)
            if((j1 = (j)next()).a())
            {
                j1.a(false);
                return j1;
            }

        throw new Error("All starting points are filled");
    }

    public final List a(List list, b b1)
    {
        ArrayList arraylist = new ArrayList();
        int l = b1.d();
        int i1 = b1.e();
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for(int j1 = 0; j1 <= b1.b(); j1++)
        {
            flag = flag || l - j1 < 0;
            i k1;
            flag1 = flag1 || l + j1 >= (k1 = this).d.f();
            flag2 = flag2 || i1 - j1 < 0;
            flag3 = flag3 || i1 + j1 >= (k1 = this).d.g();
            if(!flag)
            {
                m m1 = a(i1, l - j1);
                a(((List) (arraylist)), m1);
                a(((List) (arraylist)), list, i1, l - j1);
                flag = flag || !m1.b();
            }
            if(!flag1)
            {
                m m2 = a(i1, l + j1);
                a(((List) (arraylist)), m2);
                a(((List) (arraylist)), list, i1, l + j1);
                flag1 = flag1 || !m2.b();
            }
            if(!flag2)
            {
                m m3 = a(i1 - j1, l);
                a(((List) (arraylist)), m3);
                a(((List) (arraylist)), list, i1 - j1, l);
                flag2 = flag2 || !m3.b();
            }
            if(!flag3)
            {
                m m4 = a(i1 + j1, l);
                a(((List) (arraylist)), m4);
                a(((List) (arraylist)), list, i1 + j1, l);
                flag3 = flag3 || !m4.b();
            }
        }

        return arraylist;
    }

    private static void a(List list, m m1)
    {
        m1 = m1.iterator();
        do
        {
            if(!m1.hasNext())
                break;
            h h1;
            if((((h1 = (h)m1.next()) instanceof g) || (h1 instanceof o) || (h1 instanceof f)) && !list.contains(h1))
                list.add(h1);
        } while(true);
    }

    private static void a(List list, List list1, int l, int i1)
    {
        list1 = list1.iterator();
        do
        {
            if(!list1.hasNext())
                break;
            k k1;
            if((k1 = (k)list1.next()).m() && (!list.contains(k1) && k1.e() == l && k1.d() == i1))
                list.add(k1);
        } while(true);
    }

    public final boolean a(h h1)
    {
        return a(h1.e(), h1.d()).remove(h1);
    }

    public final boolean b(h h1)
    {
        return a(h1.e(), h1.d()).add(h1);
    }

    public final void e()
    {
        b = a(c);
        g();
    }

    private m[][] a(m am[][])
    {
        i i1;
        int l = (i1 = this).d.f();
        this = (i1 = this).d.g();
        m am1[][] = new m[l][this];
        for(int j1 = 0; j1 < this; j1++)
        {
            for(int k1 = 0; k1 < l; k1++)
                am1[j1][k1] = am[j1][k1].e();

        }

        return am1;
    }

    public final int f()
    {
        return a.size();
    }
}

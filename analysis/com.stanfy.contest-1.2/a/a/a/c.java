// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.a;

import com.stanfy.contest.a.a.a.a.a;
import com.stanfy.contest.a.a.a.a.b;
import com.stanfy.contest.a.a.a.a.d;
import com.stanfy.contest.a.a.a.a.e;
import com.stanfy.contest.a.a.a.a.f;
import com.stanfy.contest.a.a.a.a.g;
import com.stanfy.contest.a.a.a.a.h;
import com.stanfy.contest.a.a.a.a.i;
import com.stanfy.contest.a.a.a.a.j;
import com.stanfy.contest.a.a.a.a.k;
import com.stanfy.contest.a.a.a.a.l;
import com.stanfy.contest.a.a.a.a.m;
import com.stanfy.contest.a.a.a.a.n;
import com.stanfy.contest.a.a.u;
import java.util.HashMap;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a.a.a:
//            a, b

public final class c
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/a/a/a/c);
    private static HashMap b;
    private HashMap c;
    private HashMap d;

    private c()
    {
    }

    public static c a(com.stanfy.contest.a.a.b.b b1)
    {
        if(b == null)
            b = new HashMap();
        c c1;
        if((c1 = (c)b.get(b1)) != null)
        {
            return c1;
        } else
        {
            c c2 = new c();
            b.put(b1, c2);
            c2.a(b1, com/stanfy/contest/a/a/a/a/k);
            c2.a(b1, com/stanfy/contest/a/a/a/a/d);
            c2.a(b1, com/stanfy/contest/a/a/a/a/a);
            c2.a(b1, com/stanfy/contest/a/a/a/a/c);
            c2.a(b1, com/stanfy/contest/a/a/a/a/i);
            c2.a(b1, com/stanfy/contest/a/a/a/a/g);
            c2.a(b1, com/stanfy/contest/a/a/a/a/l);
            c2.a(b1, com/stanfy/contest/a/a/a/a/m);
            c2.a(b1, com/stanfy/contest/a/a/a/a/j);
            c2.a(b1, com/stanfy/contest/a/a/a/a/h);
            c2.a(b1, com/stanfy/contest/a/a/a/a/f);
            c2.a(b1, com/stanfy/contest/a/a/a/a/e);
            c2.a(b1, com/stanfy/contest/a/a/a/a/b);
            c2.b(b1, com/stanfy/contest/a/a/l);
            c2.b(b1, com/stanfy/contest/a/a/c);
            c2.b(b1, com/stanfy/contest/a/a/h);
            c2.b(b1, com/stanfy/contest/a/a/d);
            c2.b(b1, com/stanfy/contest/a/a/k);
            c2.b(b1, com/stanfy/contest/a/a/i);
            c2.b(b1, com/stanfy/contest/a/a/j);
            return c2;
        }
    }

    private void a(com.stanfy.contest.a.a.b.b b1, Class class1)
    {
        if(c == null)
            c = new HashMap();
        try
        {
            class1 = (n)class1.newInstance();
            c.put(a(true, class1.a(), b1.a().v()), class1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Class class1)
        {
            a.error((new StringBuilder()).append("Cannot instantiate configuration part").append(class1.getMessage()).toString());
        }
    }

    private void b(com.stanfy.contest.a.a.b.b b1, Class class1)
    {
        b1 = (b1 = (u)com.stanfy.contest.a.a.a.b.a().a(b1, class1)).a_();
        if(d == null)
            d = new HashMap();
        if(b1 == null)
        {
            return;
        } else
        {
            d.putAll(b1);
            return;
        }
    }

    public final n a(String s)
    {
        return (n)c.get(s);
    }

    public final com.stanfy.contest.a.a.a.b.a b(String s)
    {
        return (com.stanfy.contest.a.a.a.b.a)d.get(s);
    }

}

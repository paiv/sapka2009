// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.b;
import com.stanfy.contest.b.c;
import com.stanfy.contest.b.d;
import com.stanfy.contest.b.f;
import com.stanfy.contest.b.g;
import com.stanfy.contest.b.h;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.o;
import com.stanfy.contest.b.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.stanfy.contest.c:
//            e, f, h, k, 
//            g

public class i
    implements com.stanfy.contest.c.f
{

    private List a;
    private static boolean b = !com/stanfy/contest/c/i.desiredAssertionStatus();

    public i(List list)
    {
        a = list;
    }

    public final com.stanfy.contest.c.g a(c c1)
    {
        com.stanfy.contest.b.i j = c1.a();
        com.stanfy.contest.c.h h1 = new com.stanfy.contest.c.h(null);
        for(this = a.iterator(); hasNext();)
        {
            b b1 = (b)next();
            h1 = h1.a(new e(com.stanfy.contest.c.k.b, b1));
            j.a(b1);
            ArrayList arraylist = new ArrayList();
            h h2;
            for(Iterator iterator = j.a(c1.e(), b1).iterator(); iterator.hasNext(); j.a(h2))
            {
                h2 = (h)iterator.next();
                c1.a(b1.c().c().b(), 10);
                h1 = h1.a(new e(com.stanfy.contest.c.k.b, h2));
                double d1;
                if(!(h2 instanceof g) || (d1 = Math.random()) >= c1.j().b())
                    continue;
                Object obj = c1.j().a(d1);
                if(!b && obj == null)
                    throw new AssertionError((new StringBuilder()).append("Bonus kind was not found. p = ").append(d1).toString());
                s s1;
                d d2;
                double d3;
                arraylist.add(new o(((h) (obj = h2)).e(), ((h) (obj)).d(), (d3 = Math.random()) < (d2 = ((h) (obj)).g()).a(), d2, s1 = ((s) (obj))));
            }

            Iterator iterator1 = arraylist.iterator();
            while(iterator1.hasNext()) 
            {
                o o1 = (o)iterator1.next();
                j.b(o1);
                h1 = h1.a(new e(k.a, o1));
            }
        }

        return h1;
    }

}

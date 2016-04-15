// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import com.stanfy.contest.a.a.a.b;
import com.stanfy.contest.a.a.b.a;
import com.stanfy.contest.a.a.o;
import com.stanfy.contest.a.b.c;
import com.stanfy.contest.a.b.d;
import com.stanfy.contest.a.b.e;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.v;
import com.stanfy.contest.c.g;
import com.stanfy.contest.c.h;
import com.stanfy.contest.c.j;
import java.util.HashMap;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            c, a, b, g, 
//            h

public class f extends com.stanfy.contest.c
    implements a, com.stanfy.contest.a.f
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/f);
    private com.stanfy.contest.a.e b[];
    private com.stanfy.contest.b.c c;
    private com.stanfy.contest.c d;
    private boolean e;
    private int f;
    private int g;
    private com.stanfy.contest.b h;
    private com.stanfy.contest.g i;
    private HashMap j;
    private static f k;

    public static f h()
    {
        return k;
    }

    public f(com.stanfy.contest.b.c c1, com.stanfy.contest.a.e ae[], com.stanfy.contest.g g1, boolean flag)
    {
        e = false;
        f = 0;
        g = 1;
        i = null;
        b = ae;
        for(ae = 0; ae < b.length; ae++)
        {
            b[ae].a(c1.d());
            b[ae].a(this);
            b[ae].a(com.stanfy.contest.a.a.a.b.a().a(b[ae], com/stanfy/contest/a/a/o));
        }

        i = g1;
        h = new com.stanfy.contest.b(c1.h());
        c = c1;
        j = new HashMap();
        k = this;
        if(g1 != null)
            g1.a(new com.stanfy.contest.a(this, c1));
        d = new com.stanfy.contest.h(this);
        g1.h();
        a.debug("Tracer out");
        if(!flag)
        {
            a.info("Init delay: 5000");
            try
            {
                Thread.sleep(5000L);
            }
            catch(InterruptedException _ex)
            {
                a.error("Failed to sleep.");
            }
        } else
        {
            a.info("Waitnig for all connectors.");
            e = true;
            c1 = (ae = b).length;
            for(g1 = 0; g1 < c1; g1++)
                if(!(flag = ae[g1]).k())
                    c();

            e = false;
        }
        a.info("========== Start main thread. ==========");
        b("Model controller");
        d.b("Awaker for model controller");
    }

    protected final void f()
    {
        a.info("Stopping awaker");
        d.e();
        a.info("Awaker was stopped");
        i.e();
        com.stanfy.contest.a.e ae[];
        int i1 = (ae = b).length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            com.stanfy.contest.a.e e1;
            for(e1 = ae[j1]; e1.l() != this && e1.k(); c())
                a.info((new StringBuilder()).append("Waiting for switching connector ").append(e1.a().b()).append(" to model controller.").toString());

            e1.e();
        }

    }

    public final void i()
    {
        l();
    }

    private synchronized void l()
    {
        if(!e)
            return;
        f++;
        if(f >= b.length)
            b();
    }

    private void a(com.stanfy.contest.a.b.b b1)
    {
        com.stanfy.contest.a.e ae[];
        int i1 = (ae = b).length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            com.stanfy.contest.a.e e1 = ae[j1];
            String s1 = b1 != null ? b1.a(e1.a()) : null;
            e1.b(this, s1);
        }

        k k1;
        if(i != null && (k1 = b[0].a()) != null)
        {
            String s = b1 != null ? b1.a(k1) : null;
            i.a(b1, s);
        }
    }

    private void m()
    {
        if(a.isDebugEnabled())
            a.debug("Round duration: 3600");
        for(; b_() && !c.i(); c.b().b())
        {
            c();
            h h1 = new h(null);
            com.stanfy.contest.a.e ae[];
            int i1 = (ae = b).length;
            for(int j1 = 0; j1 < i1; j1++)
            {
                Object obj = ae[j1];
                if((obj = (com.stanfy.contest.c.f)j.get(((com.stanfy.contest.a.e) (obj)).a())) != null && (obj = ((com.stanfy.contest.c.f) (obj)).a(c)) != null)
                    h1 = h1.a(((g) (obj)));
            }

            com.stanfy.contest.c.f f1;
            g g1;
            if((g1 = (f1 = c.b().c()).a(c)) != null)
                h1 = h1.a(g1);
            g g2;
            if((g2 = (new j()).a(c)) != null)
                h1 = h1.a(g2);
            e e1 = new e(c, h1);
            a(e1);
        }

    }

    private static int[] a(int ai[], int i1)
    {
        int ai1[][] = new int[2][i1];
        for(int j1 = 0; j1 < i1; j1++)
        {
            ai1[0][j1] = ai[j1];
            ai1[1][j1] = j1;
        }

        for(int k1 = 0; k1 < i1; k1++)
            for(ai = k1; ai > 0 && ai1[0][ai - 1] < ai1[0][ai]; ai--)
            {
                int l1 = ai1[0][ai];
                ai1[0][ai] = ai1[0][ai - 1];
                ai1[0][ai - 1] = l1;
                l1 = ai1[1][ai];
                ai1[1][ai] = ai1[1][ai - 1];
                ai1[1][ai - 1] = l1;
            }


        int ai2[] = new int[i1];
        for(ai = 0; ai < i1; ai++)
            ai2[ai1[1][ai]] = ai + 1;

        return ai2;
    }

    protected final void g()
    {
        a(new com.stanfy.contest.a.b.f(c));
        for(; b_() && g <= c.g(); g++)
        {
            try
            {
                Thread.sleep(2000L);
            }
            catch(InterruptedException _ex)
            {
                a.error("Failed to sleep.");
            }
            a.info((new StringBuilder()).append("Start new round ").append(g).toString());
            a(new c(g, c));
            m();
            a(new d(c, h));
            a.info("Reset");
            c.f();
        }

        a(new com.stanfy.contest.a.b.a(h, new com.stanfy.contest.b(a(com.stanfy.contest.b.a(h), b.length))));
        a.info("Finished main cycle.");
    }

    public final void a(k k1, String s)
    {
        if(s == null || s.isEmpty())
            return;
        int i1 = k1 != null ? k1.b() : 0x7fffffff;
        if(s.length() == 1)
        {
            j.put(k1, new com.stanfy.contest.a.d(i1, Character.valueOf(s.charAt(0)), null));
            return;
        } else
        {
            j.put(k1, new com.stanfy.contest.a.d(i1, Character.valueOf(s.charAt(0)), Character.valueOf(s.charAt(1))));
            return;
        }
    }

    public final com.stanfy.contest.b.c j()
    {
        return c;
    }

    public final void a(String s)
    {
        a.warn("Someone calls model controller parse without player. This can be BAD");
    }

    public final void a(com.stanfy.contest.a.a.b.b b1)
    {
        a.debug("This module cannot be initalized or switched");
    }

    public final void b(com.stanfy.contest.a.a.b.b b1)
    {
        a.debug("This module cannot be initalized or switched");
    }

    static Logger k()
    {
        return a;
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a;

import com.stanfy.contest.b.c;
import com.stanfy.contest.b.e;
import com.stanfy.contest.b.h;
import com.stanfy.contest.b.i;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.m;
import com.stanfy.contest.b.o;
import com.stanfy.contest.b.s;
import com.stanfy.contest.b.v;
import com.stanfy.contest.c.f;
import com.stanfy.contest.c.g;
import com.stanfy.contest.c.l;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a:
//            a, b, c

public class d
    implements f
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/a/d);
    private a b;
    private boolean c;
    private int d;

    public d()
    {
        b = com.stanfy.contest.a.a.e;
        c = false;
    }

    public d(int j, Character character, Character character1)
    {
        d = j;
        if((j = com.stanfy.contest.a.a.a(character.charValue())) != null)
        {
            b = j;
            a(character1);
            return;
        } else
        {
            a(character);
            return;
        }
    }

    private void a(Character character)
    {
        c = c || character != null && character.charValue() == 'b';
    }

    public final g a(c c1)
    {
        k k1;
        e e1;
        int j;
        i i1;
        int j1;
        int l1;
        m m1;
        com.stanfy.contest.c.h h1;
        Object obj;
        e1 = (k1 = c1.b(d)).u();
        if(!k1.m())
            return null;
        j = c1.a().c();
        i1 = c1.a();
        j1 = k1.e();
        l1 = k1.d();
        m1 = i1.a(j1, l1);
        if(b != null)
        {
            a a1 = k1.q() ? b : b.b();
            switch(c.a[a1.ordinal()])
            {
            default:
                break;

            case 1: // '\001'
                int i2;
                if((i2 = k1.c() - k1.i()) < 0)
                    i2 = 0;
                m m2;
                if((m2 = i1.a(j1, i2 / j)) != m1 && !m2.a(e1.u()))
                    i2 = k1.c() - k1.c() % j;
                k1.c(i2);
                break;

            case 2: // '\002'
                int j2;
                if((j2 = k1.c() + k1.i()) >= i1.a() * j)
                    j2 = i1.a() * j - 1;
                m m3;
                if((m3 = i1.a(j1, j2 / j)) != m1 && !m3.a(e1.u()))
                    j2 = (l1 + 1) * j - 1;
                k1.c(j2);
                break;

            case 3: // '\003'
                int k2;
                if((k2 = k1.h() - k1.i()) < 0)
                    k2 = 0;
                m m4;
                if((m4 = i1.a(k2 / j, l1)) != m1 && !m4.a(e1.u()))
                    k2 = k1.h() - k1.h() % j;
                k1.d(k2);
                break;

            case 4: // '\004'
                int l2;
                if((l2 = k1.h() + k1.i()) >= i1.b() * j)
                    l2 = i1.b() * j - 1;
                m m5;
                if((m5 = i1.a(l2 / j, l1)) != m1 && !m5.a(e1.u()))
                    l2 = (j1 + 1) * j - 1;
                k1.d(l2);
                break;
            }
        }
        h1 = null;
        j = c1.b().a();
        int j3 = k1.d();
        int i3 = k1.e();
        obj = i1;
        obj = i1.a(i3, j3).iterator();
_L4:
        if(!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        h h2;
        if(!((h2 = (h)((Iterator) (obj)).next()) instanceof o)) goto _L4; else goto _L3
_L3:
        (o)h2;
          goto _L5
_L2:
        null;
_L5:
        JVM INSTR dup ;
        obj;
        JVM INSTR ifnull 620;
           goto _L6 _L7
_L6:
        break MISSING_BLOCK_LABEL_537;
_L7:
        break MISSING_BLOCK_LABEL_620;
        s s1 = ((o) (obj)).a();
        i1.a(((h) (obj)));
        ((o) (obj)).b(k1);
        if(!s1.b())
        {
            k1.a(s1, j + 200);
            c1.b().a(200, new b(this, ((o) (obj)), k1));
        }
        h1 = new com.stanfy.contest.c.h(new com.stanfy.contest.c.e(com.stanfy.contest.c.k.b, ((h) (obj))));
        if(k1.s())
        {
            a.debug("Plan infecting other players.");
            c1.b().a(0, new l(k1));
        }
        if(c && e1.v() && k1.n() && m1.a(e1.u()))
        {
            g g1 = (new com.stanfy.contest.c.d(j1, l1, k1)).a(c1);
            c = false;
            if(h1 == null)
                return g1;
            h1 = h1.a(g1);
        }
        c = false;
        return h1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(b == null ? "null" : ((Object) (b.a()))).append(c ? "b" : "").append(";").toString();
    }

}

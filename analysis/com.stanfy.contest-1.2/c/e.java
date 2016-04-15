// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.b;
import com.stanfy.contest.b.f;
import com.stanfy.contest.b.g;
import com.stanfy.contest.b.h;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.o;
import com.stanfy.contest.b.t;

// Referenced classes of package com.stanfy.contest.c:
//            g, k

public final class e
    implements com.stanfy.contest.c.g
{

    private com.stanfy.contest.c.k a;
    private h b;

    public e(com.stanfy.contest.c.k k1, h h1)
    {
        a = k1;
        b = h1;
    }

    public final String a(k k1)
    {
        String s = k.a(a);
        if(b instanceof f)
            if(k1 != null && !k1.u().m())
            {
                return "";
            } else
            {
                f f1 = (f)b;
                return (new StringBuilder()).append(s).append(b.a(k1)).append(" ").append(a(b)).append(a != k.a ? "" : (new StringBuilder()).append(" ").append(f1.b()).append(" ").append(f1.a()).toString()).toString();
            }
        if(b instanceof o)
            if(k1 != null && !k1.u().o())
            {
                return "";
            } else
            {
                o o1 = (o)b;
                return (new StringBuilder()).append(s).append(o1.a(k1)).append(" ").append(a(b)).toString();
            }
        if(b instanceof b)
            if(k1 != null && !k1.u().n())
            {
                return "";
            } else
            {
                b b1 = (b)b;
                return (new StringBuilder()).append(s).append(b.a(k1)).append(" ").append(a(b)).append(a != k.a ? "" : (new StringBuilder()).append(" ").append(b1.b()).append(" ").append(b1.a()).toString()).toString();
            }
        if(b instanceof g)
            if(k1 != null && !k1.u().k())
                return "";
            else
                return (new StringBuilder()).append(s).append(b.a(k1)).append(" ").append(a(b)).toString();
        if(b instanceof t)
        {
            if(k1 != null && !k1.u().l())
                return "";
            else
                return (new StringBuilder()).append(s).append(b.a(k1)).append(" ").append(a(b)).toString();
        } else
        {
            return "";
        }
    }

    private static String a(h h1)
    {
        return (new StringBuilder()).append(h1.d()).append(" ").append(h1.e()).toString();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.b;

import com.stanfy.contest.b.c;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.v;
import com.stanfy.contest.c.g;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.stanfy.contest.a.b:
//            b

public final class e
    implements b
{

    private c a;
    private g b;

    public e(c c1, g g1)
    {
        b = g1;
        a = c1;
    }

    private String b(k k1)
    {
        com.stanfy.contest.b.e e1;
        if((e1 = k1 != null ? k1.u() : null) != null && !e1.f())
            return "?";
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = iterator();
label0:
        do
        {
            k k2;
label1:
            {
                if(!iterator.hasNext())
                    break label0;
                k2 = (k)iterator.next();
                stringbuilder.append('P').append(k2.b()).append(" ");
                if(!k2.m())
                {
                    stringbuilder.append("dead");
                    break label1;
                }
                Object obj = "? ?";
                if(k1 == null || k2 == k1 && e1.i() || k2 != k1 && e1.g())
                    if(k1 == null || (k2 != k1 ? e1.h() : e1.j()))
                        obj = (new StringBuilder()).append(k2.c()).append(" ").append(k2.h()).toString();
                    else
                        obj = (new StringBuilder()).append(k2.d()).append(" ").append(k2.e()).toString();
                stringbuilder.append((new StringBuilder()).append(((String) (obj))).append(" ").append(k1 != null && !e1.t() ? "?" : ((Object) (Integer.valueOf(k2.k() - k2.l())))).append(" ").append(k1 != null && !e1.s() ? "?" : ((Object) (Integer.valueOf(k2.j())))).append(" ").append(k1 != null && !e1.r() ? "?" : ((Object) (Integer.valueOf(k2.i())))).toString());
                if(k1 != null && (!k2.s() || !e1.q()))
                    break label1;
                if(k1 != null)
                {
                    obj = e1;
                } else
                {
                    stringbuilder.append(" ").append(k2.t());
                    break label1;
                }
                stringbuilder.append(" ").append('i');
            }
            if(k2 != get(size() - 1))
                stringbuilder.append(',');
        } while(true);
        return stringbuilder.toString();
    }

    public final String a(k k1)
    {
        com.stanfy.contest.b.e e1 = k1 != null ? k1.u() : null;
        k k2 = k1;
        e e2 = this;
        k2 = k1;
        e2 = this;
        return (new StringBuilder()).append(k2 != null && !k2.u().e() ? "?" : (new StringBuilder()).append("T").append(e2.a.b().a()).toString()).append("&").append(b(k1)).append("&").append(b.a(k2)).append(e1 != null && !e1.b() ? "" : a.c() <= 0 ? "" : (new StringBuilder()).append("&").append((new StringBuilder()).append("d ").append((e2 = this).a.c()).toString()).toString()).append(";").toString();
    }
}

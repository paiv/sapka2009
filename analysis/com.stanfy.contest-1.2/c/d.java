// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.c;
import com.stanfy.contest.b.f;
import com.stanfy.contest.b.i;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.v;

// Referenced classes of package com.stanfy.contest.c:
//            b, e, f, k, 
//            g

public final class d
    implements com.stanfy.contest.c.f
{

    private k a;
    private int b;
    private int c;

    public d(int j, int l, k k1)
    {
        c = l;
        a = k1;
        b = j;
    }

    public final g a(c c1)
    {
        i j = c1.a();
        c1 = c1.b();
        int l = a.g().c();
        f f1 = new f(a, b, c, l);
        e e1 = new e(k.a, f1);
        j.b(f1);
        a.o();
        c1.a(l, new b(f1));
        return e1;
    }
}

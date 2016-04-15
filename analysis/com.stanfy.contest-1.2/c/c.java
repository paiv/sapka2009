// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.i;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.m;
import com.stanfy.contest.b.t;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.stanfy.contest.c:
//            e, f, h, k, 
//            g

public final class c
    implements f
{

    private h a;

    public c()
    {
        a = null;
    }

    public final g a(com.stanfy.contest.b.c c1)
    {
        int j;
        if((j = c1.c()) == 1)
            return null;
        i l;
        int j1 = (l = c1.a()).a();
        int i1 = l.b();
        for(int k1 = j - 2; k1 <= (j1 - j) + 1; k1++)
            if(j - 2 <= (i1 - j) + 1)
            {
                a(c1, j - 2, k1);
                a(c1, (i1 - j) + 1, k1);
            }

        for(int l1 = j - 2; l1 <= (i1 - j) + 1; l1++)
            if(j - 2 <= (j1 - j) + 1)
            {
                a(c1, l1, j - 2);
                a(c1, l1, (j1 - j) + 1);
            }

        return a;
    }

    private void a(com.stanfy.contest.b.c c1, int j, int l)
    {
        Object obj;
        if(((m) (obj = c1.a().a(j, l))).c())
            return;
        obj = new t(j, l, null);
        c1.a().b(((com.stanfy.contest.b.h) (obj)));
        obj = new e(k.a, ((com.stanfy.contest.b.h) (obj)));
        if(a == null)
            a = new h(((g) (obj)));
        else
            a = a.a(((g) (obj)));
        this = c1.e().iterator();
        do
        {
            if(!hasNext())
                break;
            k k1;
            if((k1 = (k)next()).m() && (k1.e() == j && k1.d() == l))
                c1.a(k1);
        } while(true);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.c;
import com.stanfy.contest.b.f;
import com.stanfy.contest.b.h;
import com.stanfy.contest.b.i;
import com.stanfy.contest.b.k;
import com.stanfy.contest.b.m;
import com.stanfy.contest.b.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.stanfy.contest.c:
//            e, f, h, i, 
//            k, g

public final class b
    implements com.stanfy.contest.c.f
{

    private f a;

    public b(f f1)
    {
        a = f1;
    }

    public final g a(c c1)
    {
        i j;
        Object obj;
        Object obj1;
        i l = j = c1.a();
        obj1 = a;
        obj = l;
        if(!l.a(((h) (obj1)).e(), ((h) (obj1)).d()).contains(obj1))
            return null;
        this = new com.stanfy.contest.b.b(a, 3);
        obj = new com.stanfy.contest.c.h(null);
        ((ArrayList) (obj1 = new ArrayList())).add(this);
        Object obj2;
        ((ArrayList) (obj2 = new ArrayList())).add(this);
        do
        {
            if(((ArrayList) (obj2)).isEmpty())
                break;
            this = new ArrayList();
            for(obj2 = ((ArrayList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext();)
            {
                com.stanfy.contest.b.b b1;
                Object obj3 = (b1 = (com.stanfy.contest.b.b)((Iterator) (obj2)).next()).c();
                obj = ((com.stanfy.contest.c.h) (obj)).a(new e(k.b, ((h) (obj3)))).a(new e(k.a, b1));
                j.a(((h) (obj3)));
                ((f) (obj3)).c().p();
                j.b(b1);
                obj3 = j.a(c1.e(), b1).iterator();
                while(((Iterator) (obj3)).hasNext()) 
                {
                    h h1;
                    if((h1 = (h)((Iterator) (obj3)).next()) instanceof f)
                    {
                        com.stanfy.contest.b.b b2 = new com.stanfy.contest.b.b((f)h1, 3);
                        add(b2);
                        ((ArrayList) (obj1)).add(b2);
                    }
                    if(h1 instanceof k)
                    {
                        char c2 = b1.c().c() != h1 ? '\u03E8' : '\uFC18';
                        c1.a(b1.c().c().b(), c2);
                        c1.a((k)h1);
                    }
                }
            }

            obj2 = this;
        } while(true);
        c1.b().a(3, new com.stanfy.contest.c.i(((List) (obj1))));
        return ((g) (obj));
    }
}

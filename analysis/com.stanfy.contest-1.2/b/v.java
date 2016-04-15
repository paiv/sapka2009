// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import com.stanfy.contest.c.a;
import com.stanfy.contest.c.f;
import java.util.LinkedList;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.b:
//            a, u

public class v
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/b/v);
    private static final f b = new u();
    private int c;
    private int d;
    private LinkedList e;

    public v()
    {
        c = 0;
        d = -1;
        e = new LinkedList();
    }

    public final int a()
    {
        return c;
    }

    public final void b()
    {
        c++;
    }

    public final f c()
    {
        if(d == c)
            throw new com.stanfy.contest.b.a("Server time was not changed!");
        d = c;
        if(e.size() > 0)
            return (f)e.removeFirst();
        else
            return b;
    }

    public final void a(int i, f f1)
    {
        if(i < 0)
            throw new com.stanfy.contest.b.a("Incorrect delay.");
        f1 = f1 != null ? f1 : b;
        int j = e.size() - i;
        if(a.isDebugEnabled())
            a.debug((new StringBuilder()).append("delay: ").append(i).toString());
        if(j <= 0)
        {
            if(a.isDebugEnabled())
                a.debug((new StringBuilder()).append("dif: ").append(j).toString());
            for(int k = 0; k < -j; k++)
                e.add(b);

            e.add(f1);
            return;
        }
        f f2;
        if((f2 = (f)e.get(i)) == b)
        {
            e.set(i, f1);
            return;
        } else
        {
            a a1 = new a(f2);
            e.set(i, a1.a(f1));
            return;
        }
    }

    public final void d()
    {
        c = 0;
        d = -1;
        e.clear();
    }

}

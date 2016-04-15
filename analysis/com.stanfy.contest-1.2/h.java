// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            c, f

final class h extends c
{

    private f a;

    h(f f1)
    {
        a = f1;
        super();
    }

    protected final void f()
    {
    }

    protected final synchronized void g()
    {
        com.stanfy.contest.f.k().info("Starting awaker for map controller.");
        while(b_()) 
        {
            a.b();
            try
            {
                Thread.sleep(50L);
            }
            catch(InterruptedException interruptedexception)
            {
                com.stanfy.contest.f.k().error("Awake thread failed to sleep.", interruptedexception);
            }
        }
        com.stanfy.contest.f.k().info("Awaker finished.");
    }
}

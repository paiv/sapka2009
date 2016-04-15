// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            ServerStarter, f, g

final class d extends Thread
{

    private g a;
    private boolean b;

    d(String s, g g, boolean flag)
    {
        a = g;
        b = flag;
        super(s);
    }

    public final void run()
    {
        ServerStarter.a(new f(ServerStarter.a(), ServerStarter.b(), a, b));
        ServerStarter.c().info("Model controller started!");
    }
}

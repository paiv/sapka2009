// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.c:
//            c, f, g

public class j
    implements f
{


    public final g a(c c1)
    {
        this = Math.max(c1.a().b(), c1.a().a()) / 2 + 2;
        int k = c1.c();
        v v1;
        int l;
        if((l = (v1 = c1.b()).a() - 2400) < 0)
            return null;
        if((this = (l * this) / 1200) <= k)
        {
            return null;
        } else
        {
            c1.a(this);
            return (new com.stanfy.contest.c.c()).a(c1);
        }
    }

    static 
    {
        Logger.getLogger(com/stanfy/contest/c/j);
    }
}

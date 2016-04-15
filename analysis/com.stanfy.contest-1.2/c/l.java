// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;

import com.stanfy.contest.b.*;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.c:
//            f, m, g

public class l
    implements f
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/c/l);
    private k b;

    public l(k k1)
    {
        b = k1;
    }

    public final g a(c c1)
    {
        int ai[] = b.r();
        Object obj = c1.b(b.e(), b.d());
        if(a.isDebugEnabled())
            a.debug((new StringBuilder()).append("Try to infect: ").append(obj).toString());
        c1 = c1.b();
        obj = ((List) (obj)).iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
                break;
            k k1;
            if((k1 = (k)((Iterator) (obj)).next()) != b)
            {
                Object obj1 = b.b(k1);
                k1 = k1;
                obj1 = ((List) (obj1)).iterator();
                while(((Iterator) (obj1)).hasNext()) 
                {
                    s s1 = (s)((Iterator) (obj1)).next();
                    int i = ai[s1.ordinal()] - c1.a();
                    a.debug((new StringBuilder()).append("Infection duration: ").append(i).toString());
                    s1 = s1;
                    c1.a(i, new m(this, k1, s1));
                }
            }
        } while(true);
        return null;
    }

}

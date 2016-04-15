// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.b;

import com.stanfy.contest.b.k;
import java.util.*;

// Referenced classes of package com.stanfy.contest.a.b:
//            b

public final class a
    implements b
{

    private Map a;
    private Map b;

    public a(Map map, Map map1)
    {
        a = map;
        b = map1;
    }

    public final String a(k k1)
    {
        (k1 = new StringBuilder()).append("GEND").append(" ");
        int i;
        for(Iterator iterator = b.keySet().iterator(); iterator.hasNext(); k1.append(" ").append(b.get(Integer.valueOf(i))).append(","))
        {
            i = ((Integer)iterator.next()).intValue();
            k1.append("P").append(i).append(" ").append(a.get(Integer.valueOf(i)));
        }

        k1.delete(k1.length() - 1, k1.length());
        k1.append(";");
        return k1.toString();
    }
}

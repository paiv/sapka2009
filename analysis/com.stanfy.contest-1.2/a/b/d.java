// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.b;

import com.stanfy.contest.b.*;
import java.io.Serializable;
import java.util.Map;

// Referenced classes of package com.stanfy.contest.a.b:
//            b

public final class d
    implements b
{

    private Map a;

    public d(c c, Map map)
    {
        a = map;
    }

    public final String a(k k1)
    {
        int i = k1 != null ? k1.b() : 0x7fffffff;
        e e1;
        if((e1 = k1 != null ? k1.u() : null) == null || e1.d())
            return (new StringBuilder()).append("REND ").append(k1 != null ? ((Object) ((Serializable)a.get(Integer.valueOf(i)))) : "?").append(";").toString();
        else
            return null;
    }
}

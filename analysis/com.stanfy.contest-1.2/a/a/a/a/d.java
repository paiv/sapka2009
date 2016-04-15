// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.a.a;

import com.stanfy.contest.b.e;

// Referenced classes of package com.stanfy.contest.a.a.a.a:
//            n

public class d extends n
{


    public final String a(e e1)
    {
        this = !e1.m() || !e1.l() || !e1.o() || !e1.n() ? "" : "re";
        String s = e1.p() ? "re" : "";
        e1.l(true);
        e1.k(true);
        e1.n(true);
        e1.m(true);
        e1.o(true);
        return (new StringBuilder()).append("Sensors was successfully ").append(this).append("activated...\r\nPrecision sensors ").append(s).append("configuration ... done").toString();
    }

    public final String a()
    {
        return "RhkyCmdgAemW9x8TWVSu";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.*;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class g extends o
{

    private am a;

    g(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        a.d("\r\n");
        a.d(" == REGISTERED WORDS == \r\n");
        a.d("  :System words \r\n");
        o ao[];
        Arrays.sort(ao = (o[])am.c(am1).values().toArray(new o[0]));
        int i = (ao = ao).length;
        for(int j = 0; j < i; j++)
        {
            o o1 = ao[j];
            a.d((new StringBuilder()).append("    ").append(o1.b()).append("\r\n").toString());
        }

        a.d("  :User defined words \r\n");
        Arrays.sort(ao = (o[])am.d(am1).values().toArray(new o[0]));
        o ao1[];
        int k = (ao1 = ao).length;
        for(int l = 0; l < k; l++)
        {
            am1 = ao1[l];
            a.d((new StringBuilder()).append("    ").append(am1.b()).append("\r\n").toString());
        }

        a.d(" == REGISTERED WORDS END== \r\n");
        return "REGISTERED WORDS";
    }

    public final String a()
    {
        return "Outputs ALL Registered Words. Doesn't changing stack.\r\n All types are allowed : <> WORDS -> <>";
    }
}

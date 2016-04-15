// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.c;


// Referenced classes of package com.stanfy.contest.c:
//            e

public final class k extends Enum
{

    public static final k a;
    public static final k b;
    private String c;
    private static final k d[];

    public static k[] values()
    {
        return (k[])d.clone();
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/stanfy/contest/c/k, s);
    }

    private k(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    static String a(k k1)
    {
        return k1.c;
    }

    static 
    {
        a = new k("ADD", 0, "+");
        b = new k("REMOVE", 1, "-");
        d = (new k[] {
            a, b
        });
    }
}

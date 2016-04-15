// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


// Referenced classes of package com.stanfy.contest.b:
//            k, p, q, r

public class s extends Enum
{

    private static s f;
    private static s g;
    private static s h;
    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e[];
    private boolean i;
    private char j;
    private double k;
    private static final s l[];

    public static s[] values()
    {
        return (s[])l.clone();
    }

    public static s valueOf(String s1)
    {
        return (s)Enum.valueOf(com/stanfy/contest/b/s, s1);
    }

    private s(String s1, int i1, boolean flag, char c1, double d1, byte byte0)
    {
        super(s1, i1);
        i = flag;
        j = c1;
        k = d1;
    }

    protected void a(k k1)
    {
        k1.a(this, true);
    }

    protected final void b(k k1)
    {
        k1.a(this, false);
    }

    public final char a()
    {
        return j;
    }

    public final boolean b()
    {
        return i;
    }

    public final double c()
    {
        return k;
    }

    s(String s1, int i1, boolean flag, char c1, double d1)
    {
        this(s1, i1, flag, c1, d1, (byte)0);
    }

    static char a(s s1)
    {
        return s1.j;
    }

    static 
    {
        f = new r("BOMB_COUNT_INCREMENT", 0, true, 'b', 0.074999999999999997D);
        g = new q("BOMB_STRENGTH_INCREMENT", 1, true, 'f', 0.074999999999999997D);
        h = new p("SPEED_INCREMENT", 2, true, 'v', 0.074999999999999997D);
        a = new s("REVERSE", 3, false, 'r', 0.025999999999999999D, (byte)0);
        b = new s("MAKE_SLOW", 4, false, 's', 0.025000000000000001D, (byte)0);
        c = new s("BOMB_UNABLE", 5, false, 'u', 0.025999999999999999D, (byte)0);
        d = new s("BOMB_STRENGTH_NULL", 6, false, 'o', 0.025000000000000001D, (byte)0);
        l = (new s[] {
            f, g, h, a, b, c, d
        });
        e = (new s[] {
            a, b, c, d
        });
    }
}

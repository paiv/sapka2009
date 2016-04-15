// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a;


// Referenced classes of package com.stanfy.contest.a:
//            c, d

public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    private static final a f[];

    public static a[] values()
    {
        return (a[])f.clone();
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/stanfy/contest/a/a, s);
    }

    private a(String s, int i)
    {
        super(s, i);
    }

    public final Character a()
    {
        switch(c.a[ordinal()])
        {
        case 1: // '\001'
            return Character.valueOf('l');

        case 2: // '\002'
            return Character.valueOf('r');

        case 3: // '\003'
            return Character.valueOf('u');

        case 4: // '\004'
            return Character.valueOf('d');

        case 5: // '\005'
            return Character.valueOf('s');
        }
        return null;
    }

    public final a b()
    {
        switch(c.a[ordinal()])
        {
        case 1: // '\001'
            return b;

        case 2: // '\002'
            return a;

        case 3: // '\003'
            return d;

        case 4: // '\004'
            return c;

        case 5: // '\005'
            return e;
        }
        return null;
    }

    static a a(char c1)
    {
        switch(c1 = c1)
        {
        case 108: // 'l'
            return a;

        case 114: // 'r'
            return b;

        case 117: // 'u'
            return c;

        case 100: // 'd'
            return d;

        case 115: // 's'
            return e;
        }
        return null;
    }

    static 
    {
        a = new a("LEFT", 0);
        b = new a("RIGHT", 1);
        c = new a("UP", 2);
        d = new a("DOWN", 3);
        e = new a("STOP", 4);
        f = (new a[] {
            a, b, c, d, e
        });
    }
}

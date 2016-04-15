// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;


// Referenced classes of package com.stanfy.contest.a.a.c:
//            y, am

public abstract class o
    implements Comparable
{

    private String a;

    public o(String s)
    {
        a = s;
    }

    public abstract Object a(am am);

    public abstract String a();

    public final int hashCode()
    {
        if(a == null)
            return super.hashCode();
        else
            return a.hashCode();
    }

    public final String toString()
    {
        return a;
    }

    public final String b()
    {
        return a;
    }

    public final volatile int compareTo(Object obj)
    {
        obj = (o)obj;
        this = this;
        return a.compareTo(((o) (obj)).a);
    }
}

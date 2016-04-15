// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import java.util.*;

final class b
    implements Map
{

    private int a[];

    private b(int ai[], byte byte0)
    {
        a = ai;
    }

    public final Set keySet()
    {
        TreeSet treeset = new TreeSet();
        for(int i = 0; i < a.length; i++)
            treeset.add(Integer.valueOf(i));

        return treeset;
    }

    public final void clear()
    {
    }

    public final boolean containsKey(Object obj)
    {
        return false;
    }

    public final boolean containsValue(Object obj)
    {
        return false;
    }

    public final Set entrySet()
    {
        return null;
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final void putAll(Map map)
    {
    }

    public final int size()
    {
        return 0;
    }

    public final Collection values()
    {
        return null;
    }

    public final volatile Object remove(Object obj)
    {
        return null;
    }

    public final volatile Object put(Object obj, Object obj1)
    {
        return null;
    }

    public final volatile Object get(Object obj)
    {
        obj = obj;
        this = this;
        obj = ((Integer)obj).intValue();
        return Integer.valueOf(a[obj]);
    }

    b(int ai[])
    {
        this(ai, (byte)0);
    }

    static int[] a(b b1)
    {
        return b1.a;
    }
}

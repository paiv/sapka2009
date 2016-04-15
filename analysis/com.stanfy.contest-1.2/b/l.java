// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;


public final class l extends RuntimeException
{

    public l(String s)
    {
        super(s);
    }

    public l(Throwable throwable)
    {
        super("Map configuration is not correct!", throwable);
    }
}

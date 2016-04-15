// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;


public final class y extends Exception
{

    public y(String s)
    {
        super(s);
    }

    public static final y a()
    {
        return new y("Not enough data in stack.");
    }

    public static final y b()
    {
        return new y("Divizion by zero.");
    }

    public static final y a(String s)
    {
        return new y((new StringBuilder()).append("Data in stack must be int(").append(s).append(").").toString());
    }

    public static y b(String s)
    {
        return new y((new StringBuilder()).append("Unknown variable(").append(s).append(")").toString());
    }

    public static y c(String s)
    {
        return new y((new StringBuilder()).append("Unexpected word (").append(s).append(")").toString());
    }

    public static y a(String s, int i, int j)
    {
        return new y((new StringBuilder()).append("Incorrect String index (").append(i).append(i == j ? "" : (new StringBuilder()).append(" or ").append(j).toString()).append(") at ").append(s).toString());
    }
}

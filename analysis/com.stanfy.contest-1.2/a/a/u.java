// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.a.a;
import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.a.a.b.c;
import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;
import java.util.HashMap;

public abstract class u
    implements c
{

    protected b a;
    protected boolean b;


    public HashMap a_()
    {
        return new HashMap();
    }

    public final void b(b b1)
    {
        a = b1;
    }

    public void a(b b1)
    {
        a = b1;
    }

    public final void b(String s)
    {
        if(a != null)
            a.a(this, s);
    }

    public final c a(Class class1)
    {
        if(a == null)
            return null;
        else
            return a.a(class1);
    }

    public final void c(String s)
    {
        if(a != null)
            a.b(this, s);
    }

    public final String d(String s)
    {
        if(a != null)
            return com.stanfy.contest.a.a.a.a.a(false, s, a.a().v());
        else
            return com.stanfy.contest.a.a.a.a.a(false, s, "");
    }

    public final String e(String s)
    {
        if(a != null)
            return com.stanfy.contest.a.a.a.a.a(true, s, a.a().v());
        else
            return com.stanfy.contest.a.a.a.a.a(true, s, "");
    }

    public final void a(String as[])
    {
        a(as, 500L);
    }

    public final void a(String as[], long l)
    {
        b = true;
        int i = (as = as).length;
        for(int j = 0; j < i; j++)
        {
            String s = as[j];
            c(s);
            try
            {
                Thread.currentThread();
                Thread.sleep((long)(Math.random() * (double)l));
            }
            catch(InterruptedException _ex) { }
        }

        b = false;
    }

    protected final void f()
    {
        e e1 = a.a().u();
        c((new StringBuilder()).append("Additional sattelites data, will be visible at Sapka launch in format:\r\n  sapkas-info ::= <sapka-info> [ { ',' <sapka-info> } ]\r\n  sapka-info  :: = 'P' <number> <sep> ( ").append(e1.g() ? "<details>" : "'?'").append(" | 'dead' )\r\n").append(e1.g() ? "<x-coord> <sep> <y-coord>" : "'?' <sep> '?'").append(" <sep> ").append(e1.t() ? "<annihilators-left>" : "'?'").append(" <sep> ").append(e1.s() ? "<annihilators-strength>" : "'?'").append(" <sep> ").append(e1.r() ? "<speed>" : "'?'").append(e1.q() ? " [ <sep> <infected>] " : "").append(e1.h() ? "\r\n <x-coord> ::= <number) // coordinate in POINTS \r\n <y-coord> ::= <number) // coordinate in POINTS " : "\r\n <x-coord> ::= <number) // coordinate in CELLS \r\n <y-coord> ::= <number) // coordinate in CELLS ").toString());
    }

    public abstract String b();

    public final String g()
    {
        return (new StringBuilder()).append("\r\n").append(b()).append(">").toString();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import org.apache.log4j.Logger;

public abstract class c
    implements Runnable
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/c);
    private boolean b;
    private boolean c;


    public final void b(String s)
    {
        (new Thread(this, (new StringBuilder()).append(getClass().getName()).append(" ").append(s).toString())).start();
    }

    public void run()
    {
        c = true;
        b = true;
        g();
        h();
    }

    private synchronized void h()
    {
        a.info((new StringBuilder()).append("Shutdown worker ").append(getClass().getName()).toString());
        f();
        a.info((new StringBuilder()).append("Shutdown of ").append(getClass().getName()).append(" was performed.").toString());
        c = false;
        notify();
    }

    protected final boolean b_()
    {
        return b;
    }

    protected final void a(boolean flag)
    {
        b = false;
    }

    protected final synchronized void b()
    {
        notify();
    }

    protected final synchronized void c()
    {
        try
        {
            wait();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(c this)
        {
            a.error("Map controller failed to wait.", this);
        }
    }

    protected final synchronized void d()
    {
        while(b) 
        {
            a.info((new StringBuilder()).append(getClass().getName()).append(": Worker cycle is finished by still active.").toString());
            try
            {
                wait(1000L);
            }
            catch(InterruptedException interruptedexception)
            {
                a.error("Failed wait while active.", interruptedexception);
            }
        }
    }

    public void e()
    {
        a.info((new StringBuilder()).append("Stopping worker ").append(getClass().getName()).toString());
        b = false;
        while(c) 
            try
            {
                synchronized(this)
                {
                    wait(1000L);
                }
            }
            catch(InterruptedException interruptedexception)
            {
                a.error("Failed wait for shutdown.", interruptedexception);
            }
    }

    protected abstract void f();

    protected abstract void g();

}

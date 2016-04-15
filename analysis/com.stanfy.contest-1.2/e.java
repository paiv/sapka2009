// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            c

public abstract class e extends c
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/e);
    private byte b[];
    private StringBuilder c;
    private boolean d;

    public e()
    {
        b = new byte[512];
        c = new StringBuilder();
        d = false;
    }

    protected void g()
    {
        a.info((new StringBuilder()).append("Start ").append(getClass()).toString());
        try
        {
            InputStream inputstream = h();
            d = true;
            do
            {
                if(!b_())
                    break;
                int l;
                if((l = inputstream.available()) > 0)
                {
                    if(l > 512)
                        l = 512;
                    if((l = inputstream.read(b, 0, l)) > 0)
                    {
                        c.append(new String(b, 0, l));
                        i();
                    }
                } else
                {
                    try
                    {
                        Thread.sleep(10L);
                    }
                    catch(InterruptedException interruptedexception)
                    {
                        a.error("Failed to sleep.", interruptedexception);
                    }
                }
            } while(true);
        }
        catch(IOException ioexception)
        {
            a.warn(ioexception.getMessage());
        }
        d();
        a.info((new StringBuilder()).append("Finish ").append(getClass()).toString());
    }

    protected abstract InputStream h();

    protected abstract void i();

    protected final StringBuilder j()
    {
        return c;
    }

    public final boolean k()
    {
        return d;
    }

}

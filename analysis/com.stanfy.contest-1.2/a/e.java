// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a;

import com.stanfy.contest.a.a.a.b;
import com.stanfy.contest.a.a.b.a;
import com.stanfy.contest.a.a.b.c;
import com.stanfy.contest.a.a.b.d;
import com.stanfy.contest.b.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a:
//            f

public class e extends com.stanfy.contest.e
    implements com.stanfy.contest.a.a.b.b, d
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/a/e);
    private int b;
    private k c;
    private ServerSocket d;
    private Socket e;
    private OutputStream f;
    private StringBuilder g;
    private f h;
    private c i;

    public e(int j)
    {
        g = new StringBuilder();
        b = j;
        b((new StringBuilder()).append("Client conector ").append(j).toString());
    }

    public final void a(f f1)
    {
        h = f1;
    }

    private void a(String s)
    {
        if((s == null || s.length() == 0) && g.length() == 0)
            return;
        if(f == null)
        {
            g.append(s);
            a.warn((new StringBuilder()).append("Client ").append(c).append(" (port: ").append(b).append(") is not ready.").toString());
            return;
        }
        if(a.isDebugEnabled())
            a.debug((new StringBuilder()).append("Sending data: ").append(s).toString());
        try
        {
            if(g.length() > 0)
                f.write(g.toString().getBytes());
            g.delete(0, g.length());
            if(s != null)
                f.write(s.toString().getBytes());
            f.flush();
            return;
        }
        catch(IOException _ex)
        {
            g.append(s);
        }
        a.warn((new StringBuilder()).append("Unable to send data to the client. PID: ").append(c).append(", port: ").append(b).toString());
    }

    private void a(int j)
    {
        j().delete(0, j);
    }

    protected final void i()
    {
        if(i == null)
        {
            a(j().length());
            return;
        }
        int j;
        if((j = j().lastIndexOf(";")) < 0)
            return;
        String s;
        String as[] = (s = j().substring(0, j)).split(";");
        a(j + 1);
        int k = (as = as).length;
        for(int i1 = 0; i1 < k; i1++)
        {
            String s1;
            for(s1 = as[i1]; s1.contains("\b"); s1 = s1.replaceFirst(".?\\x08", ""));
            s1 = s1.replaceFirst("^[\\r\\n]+", "");
            if(i instanceof a)
                ((a)i).a(c, s1);
            else
                i.a(s1);
        }

        if(j < 1)
        {
            a.warn((new StringBuilder()).append("Incorrect command => ignore it (port ").append(b).append(")").toString());
            a(j + 1);
            return;
        } else
        {
            return;
        }
    }

    public final void e()
    {
        if(d != null)
            try
            {
                d.close();
            }
            catch(IOException ioexception)
            {
                a.error("Failed to close the server", ioexception);
            }
        a(false);
        super.e();
    }

    protected final InputStream h()
    {
        try
        {
            d = new ServerSocket(b);
        }
        // Misplaced declaration of an exception variable
        catch(e this)
        {
            a.fatal("Cannot init client connector.", this);
            System.exit(1);
            return null;
        }
        e = d.accept();
        a.debug((new StringBuilder()).append("Set output for port ").append(b).toString());
        if(h != null)
            h.i();
        f = e.getOutputStream();
        a("");
        return e.getInputStream();
    }

    protected final void g()
    {
        a.info((new StringBuilder()).append("Create server socket for port ").append(b).toString());
        super.g();
        a.debug("Client connector work is finished.");
    }

    protected final void f()
    {
        a.info((new StringBuilder()).append("Shutdown for port ").append(b).toString());
        if(f != null)
            try
            {
                f.close();
            }
            catch(IOException ioexception)
            {
                a.error((new StringBuilder()).append("Cannot close output for port ").append(b).toString(), ioexception);
            }
        if(e != null)
            try
            {
                e.close();
            }
            catch(IOException ioexception1)
            {
                a.error((new StringBuilder()).append("Cannot close socket for port ").append(b).toString(), ioexception1);
            }
        if(d != null)
            try
            {
                d.close();
                return;
            }
            catch(IOException ioexception2)
            {
                a.error((new StringBuilder()).append("Cannot close server for port ").append(b).toString(), ioexception2);
            }
    }

    public final void a(c c1)
    {
        i = c1;
        synchronized(i)
        {
            i.notifyAll();
        }
        if(c1 != null)
            c1.a(this);
    }

    public final void b(c c1, String s)
    {
        if(c1 == i)
            a(s);
    }

    public final k a()
    {
        return c;
    }

    public final void a(k k)
    {
        c = k;
    }

    public final void a(c c1, String s)
    {
        if((c1 = com.stanfy.contest.a.a.a.b.a().a(this, c1, s)) != null)
            a(c1);
    }

    public final c a(Class class1)
    {
        return com.stanfy.contest.a.a.a.b.a().a(this, class1);
    }

    public final c l()
    {
        return i;
    }

}

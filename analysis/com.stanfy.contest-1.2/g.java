// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import com.stanfy.contest.a.b.a;
import com.stanfy.contest.a.b.b;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            c, a

public final class g extends c
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/g);
    private List b;
    private OutputStream c;
    private OutputStream d;
    private ServerSocket e;
    private LinkedList f;
    private boolean g;

    public g(File file, File file1, int i)
    {
        c = null;
        d = null;
        e = null;
        f = new LinkedList();
        g = false;
        try
        {
            if(file != null)
                c = new FileOutputStream(file);
            if(file1 != null)
                d = new FileOutputStream(file1);
            if(i > 0)
            {
                a.info((new StringBuilder()).append("Create visualizer server socket on ").append(i).toString());
                e = new ServerSocket(i);
            }
        }
        // Misplaced declaration of an exception variable
        catch(File file)
        {
            a.error("Cannot create some trace out.", file);
        }
        b("Tracer");
    }

    public final void a(com.stanfy.contest.a a1)
    {
        if(b == null)
            b = new ArrayList();
        b.add(a1);
    }

    public final void b(boolean flag)
    {
        g = flag;
    }

    public final void a(b b1, String s)
    {
        if(s == null)
            return;
        if(c != null)
            try
            {
                c.write(s.getBytes());
            }
            catch(IOException ioexception)
            {
                a.error("Cannot write to the trace.", ioexception);
            }
        if(d != null && (b1 instanceof a))
            try
            {
                d.write(s.getBytes());
            }
            catch(IOException ioexception1)
            {
                a.error("Cannot write to the results.", ioexception1);
            }
        if(e != null)
        {
            LinkedList linkedlist = new LinkedList();
            b1 = f.iterator();
            do
            {
                if(!b1.hasNext())
                    break;
                Socket socket = (Socket)b1.next();
                a.debug("Send to visualizer...");
                if(!a(socket, s))
                    linkedlist.add(socket);
            } while(true);
            f.removeAll(linkedlist);
        }
    }

    public static boolean a(Socket socket, String s)
    {
        try
        {
            socket.getOutputStream().write(s.getBytes());
        }
        catch(IOException _ex)
        {
            a.error("Error while sending data to the visualizer(socket)");
            return false;
        }
        return true;
    }

    public final void e()
    {
        if(e != null)
        {
            a(false);
            try
            {
                e.close();
            }
            catch(IOException ioexception)
            {
                a.error("Failed to close the server", ioexception);
            }
        }
        super.e();
    }

    protected final void f()
    {
        if(b != null)
            b.clear();
        try
        {
            if(c != null)
                c.close();
        }
        catch(IOException ioexception)
        {
            a.error("Cannot close traceOut.", ioexception);
        }
        try
        {
            if(c != null)
                d.close();
            return;
        }
        catch(IOException ioexception1)
        {
            a.error("Cannot close resultOut.", ioexception1);
        }
    }

    public final void h()
    {
        a.info("Wait for the first visualizer");
        for(; g && f.size() == 0; c())
            a.info("Tracer is waiting...");

    }

    protected final void g()
    {
        while(b_()) 
            try
            {
                Socket socket = e.accept();
                a.info("New visualizer!");
                com.stanfy.contest.a a1;
                for(Iterator iterator = b.iterator(); iterator.hasNext(); (a1 = (com.stanfy.contest.a)iterator.next()).a(this, socket));
                f.add(socket);
                b();
            }
            catch(IOException ioexception)
            {
                a.info(ioexception.getMessage());
            }
    }

}

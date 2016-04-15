// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest;

import com.stanfy.contest.a.e;
import com.stanfy.contest.b.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest:
//            d, f, g

public final class ServerStarter
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/ServerStarter);
    private static int b[];
    private static e c[];
    private static f d;
    private static c e;

    private ServerStarter()
    {
    }

    private static boolean a(String s)
    {
        return "yes".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s) || "y".equalsIgnoreCase(s);
    }

    public static void main(String args[])
    {
        if(args.length < 1)
        {
            a.fatal("Incorrect parameter.\nUsage: java -cp '<path to jars>' com.stanfy.contest.ServerStarter <config-file-name>");
            System.exit(1);
        }
        Logger.getRootLogger().setLevel(Level.ERROR);
        Object obj;
        if(!((File) (obj = new File(args[0]))).exists())
        {
            a.fatal((new StringBuilder()).append("Configuration file does not exist! (").append(args[0]).append(")").toString());
            System.exit(1);
        }
        a.info("Read configuration file.");
        args = new Properties();
        try
        {
            args.load(new FileInputStream(((File) (obj))));
        }
        catch(Throwable throwable)
        {
            a.fatal("Cannot read configuration file.", throwable);
            System.exit(1);
        }
        a.info("Read map, create game model.");
        throwable = args.getProperty("map");
        Object obj1 = new File((new StringBuilder()).append(throwable).append(".map").toString());
        Object obj2 = new File((new StringBuilder()).append(throwable).append(".properties").toString());
        if(!((File) (obj1)).exists())
        {
            a.fatal((new StringBuilder()).append("Incorrect path to the map: ").append(throwable).append(".map").toString());
            System.exit(1);
        }
        if(!((File) (obj2)).exists())
        {
            a.fatal((new StringBuilder()).append("Incorrect path to the map configuration: ").append(throwable).append(".properties").toString());
            System.exit(1);
        }
        try
        {
            e = new c(new FileInputStream(((File) (obj1))), new FileInputStream(((File) (obj2))));
        }
        catch(Throwable throwable1)
        {
            a.fatal((new StringBuilder()).append("Unable to create game model: ").append(throwable1.getMessage()).toString(), throwable1);
            System.exit(1);
        }
        a.info("Create client connectors.");
        throwable1 = args.getProperty("client.ports");
        String args1[];
        try
        {
            args1 = throwable1.split("\\s*,\\s*");
        }
        catch(Exception _ex)
        {
            a.fatal((new StringBuilder()).append("Incorrect 'client.ports' parameter: ").append(throwable1).toString());
            System.exit(1);
            return;
        }
        int i = args1.length;
        a.info((new StringBuilder()).append("Clients count: ").append(i).append(" ").append(Arrays.toString(args1)).toString());
        c = new e[i];
        b = new int[i];
        for(int j = 0; j < i; j++)
        {
            try
            {
                b[j] = Integer.parseInt(args1[j]);
            }
            catch(NumberFormatException _ex)
            {
                a.fatal((new StringBuilder()).append("Incorrect port number ").append(args1[j]).toString());
                if(d != null)
                    d.e();
                System.exit(1);
            }
            a.debug((new StringBuilder()).append("Start connector on port ").append(b[j]).toString());
            c[j] = new e(b[j]);
        }

        a.info("Read misc parameters.");
        j = args.getProperty("trace.out");
        i = args.getProperty("result.out");
        args1 = args.getProperty("visualizer.port");
        String s = args.getProperty("client.wait");
        args = args.getProperty("visualizer.wait");
        j = j != null ? ((int) (new File(j))) : null;
        i = i != null ? ((int) (new File(i))) : null;
        int k = 0;
        if(args1 != null)
            try
            {
                k = Integer.parseInt(args1);
            }
            catch(NumberFormatException _ex)
            {
                a.warn("Incorrect visualizer port. Ignore it.");
            }
        i = new g(j, i, k);
        boolean flag = false;
        if(args != null)
            flag = a(args);
        a.debug((new StringBuilder()).append("Wait visualizer: ").append(flag).toString());
        i.b(flag);
        args = 0;
        if(s != null)
            args = a(s);
        flag = args;
        a.debug((new StringBuilder()).append("waitAllConnectors = ").append(args).toString());
        a.debug("Start model controller");
        (new d("Model controller starter", i, flag)).start();
    }

    static f a(f f1)
    {
        return d = f1;
    }

    static c a()
    {
        return e;
    }

    static e[] b()
    {
        return c;
    }

    static Logger c()
    {
        return a;
    }

}

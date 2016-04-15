// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.a.a.b;
import com.stanfy.contest.a.a.a.a.n;
import com.stanfy.contest.a.a.a.b.a;
import com.stanfy.contest.a.a.a.c;
import com.stanfy.contest.b.k;
import com.stanfy.contest.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a.a:
//            u

public class o extends u
{

    private static final Pattern c = Pattern.compile("^launch\\s+(.+?)\\s+(.+?)$");
    private static final Logger d = Logger.getLogger(com/stanfy/contest/a/a/o);
    private static c e;
    private String f;
    private static Pattern g = Pattern.compile("config\\s+(.*)");
    private static Pattern h = Pattern.compile("dma\\s+(.*)");
    private static Pattern i = Pattern.compile("team\\s+(.*)");

    public o()
    {
        f = null;
    }

    public final void a(com.stanfy.contest.a.a.b.b b1)
    {
        super.a(b1);
        c("\r\nLoading... ");
        c("done.\r\n");
        c(" This is preconfiguration module for SAPKA.\r\n");
        if(f == null)
        {
            c(" ");
            (b1 = this).c("\r\nPlease, specify your team name in format 'team teamname;'\r\n");
        }
        c((new StringBuilder()).append(" Use 'help;' command for information.").append(g()).toString());
    }

    private String f(String s)
    {
        s = s.split("#");
        HashSet hashset = new HashSet();
        int j = (s = s).length;
        for(int l = 0; l < j; l++)
        {
            String s1 = s[l];
            d.debug((new StringBuilder()).append("Config token found ").append(s1).toString());
            n n1;
            if((n1 = e.a(s1)) != null)
            {
                hashset.add(n1);
            } else
            {
                a(new String[] {
                    "\r\n", "checking config tokens", ".", ".", ".", ".", ".", ".", ".", ".", 
                    ".", ".", ".", ".", ".", ".", ".", "."
                });
                c((new StringBuilder()).append("\r\nIncorrect configuration token").append(g()).toString());
                return null;
            }
        }

        s = new StringBuilder();
        com.stanfy.contest.b.c c1 = ((f)a(com/stanfy/contest/f)).j();
        k k1 = a.a();
        String s2;
        for(Iterator iterator = hashset.iterator(); iterator.hasNext(); s.append("\r\n").append(s2))
        {
            n n2;
            s2 = (n2 = (n)iterator.next()).a(a.a().u());
            if(n2 instanceof b)
                c1.a(k1.b(), 20);
        }

        c1.a(k1.b(), hashset.size() << 1);
        return s.toString();
    }

    private void c()
    {
        a.a().a(f);
        d.info((new StringBuilder()).append("getting modulesConfiguration for player ").append(a.a()).toString());
        e = com.stanfy.contest.a.a.a.c.a(a);
    }

    public final void a(String s)
    {
        if(b)
            return;
        Object obj;
        if(((Matcher) (obj = i.matcher(s))).matches())
        {
            f = ((Matcher) (obj)).group(1);
            c((new StringBuilder()).append("\r\nCurrent team name is '").append(f).append("'. Now you are able to configure SAPKA.'").append(g()).toString());
            c();
            return;
        }
        obj = c.matcher(s);
        if(d.isDebugEnabled())
            d.debug((new StringBuilder()).append("input[").append(s).append("] via pattern ").append(c.pattern()).toString());
        if(((Matcher) (obj)).matches())
        {
            f = ((Matcher) (obj)).group(1);
            c();
            f(((Matcher) (obj)).group(2));
            b("launch");
            return;
        }
        if(f == null)
        {
            (s = this).c("\r\nPlease, specify your team name in format 'team teamname;'\r\n");
            c(g());
            return;
        }
        if(s.equals("help"))
        {
            c("\r\n ============ SAPKA PRECONFIGURATION HELP =============\r\n");
            c(" All commands are separated by ';' character.\r\n");
            c(" Some commands will need parameters, which can be specified by adding ' ' (space) character.\r\n");
            c(" \r\n");
            c(" To configure SAPKA, input 'config <config-token>[#<config-token>...];'.\r\n");
            c(" All configuration tokens can be found in your manual at page 42. It was reviewed by Caesar.\r\n");
            c(" \r\n");
            c(" To load DMA tokens, input 'dma <dma-token>[#<dma-token>...];'.\r\n");
            c(" \r\n");
            c(" To access memory, input 'memconfig;'\r\n");
            c(" To launch SAPKA, input 'launch;'\r\n");
            c(" You can use 'launch <team-name> <config-token>[#<config-token> ...];'\r\n");
            c(" to launch SAPKA instantly before defining the team name with the 'team' command.'\r\n");
            c(" \r\n");
            c(" NOTE: It's strongly recommended to configure SAPKA before launching,\r\n");
            c((new StringBuilder()).append("       and always use as many configuration tokens and dma tokens as you can.").append(g()).toString());
            return;
        }
        if(s.equals("memconfig"))
        {
            c("\r\nAccessing memory...");
            b("memConfig");
            return;
        }
        if(s.equals("launch"))
        {
            c("\r\nLaunching SAPKA...");
            b("launch");
            return;
        }
        if(((Matcher) (obj = g.matcher(s))).matches())
            c(f(((Matcher) (obj)).group(1)));
        if(((Matcher) (obj = h.matcher(s))).matches())
        {
            s = ((Matcher) (obj)).group(1).split("#");
            obj = new ArrayList();
            int j = (s = s).length;
            for(int l = 0; l < j; l++)
            {
                Object obj1 = s[l];
                d.debug((new StringBuilder()).append("DMA token found ").append(((String) (obj1))).toString());
                if((obj1 = e.b(((String) (obj1)))) != null)
                {
                    ((ArrayList) (obj)).add(obj1);
                } else
                {
                    a(new String[] {
                        "\r\n", "checking DMA token", ".", ".", ".", ".", ".", ".", ".", "."
                    });
                    c((new StringBuilder()).append("\r\nIncorrect DMA token").append(g()).toString());
                    return;
                }
            }

            Object obj2;
            for(s = ((ArrayList) (obj)).iterator(); s.hasNext(); c((new StringBuilder()).append("\r\n").append(((String) (obj2))).toString()))
            {
                a a1;
                Class class1 = (a1 = (a)s.next()).a();
                obj2 = a(class1);
                obj2 = a1.a(((com.stanfy.contest.a.a.b.c) (obj2)));
            }

        }
        c(g());
    }

    public final String b()
    {
        return "config";
    }

}

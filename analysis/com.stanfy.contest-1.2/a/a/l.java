// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, a, b, d, 
//            h, i, j, k

public class l extends u
{


    public final void a(b b1)
    {
        super.a(b1);
        c();
    }

    public final void a(String s)
    {
        if(b)
            return;
        i i1 = (i)a(com/stanfy/contest/a/a/i);
        if(s.equals("engine"))
        {
            b("enginecontrol");
            return;
        }
        if(s.equals("lexinterpr"))
        {
            b("lexicalinterpreter");
            return;
        }
        if(i1.d())
        {
            if(s.equals("dnalab"))
            {
                b("dnaLab");
                return;
            }
            if(s.equals("sattelite"))
            {
                b("sattelite");
                return;
            }
            if(s.equals("fifth"))
            {
                b("fifthModule");
                return;
            }
            if(s.equals("aar"))
            {
                b("bfModule");
                return;
            }
            if(s.equals("clock"))
            {
                b("xorModule");
                return;
            }
        }
        if(s.equals("quit"))
        {
            b("statusExit");
            return;
        }
        if(s.equals("status"))
        {
            c();
            return;
        } else
        {
            c(g());
            return;
        }
    }

    private void c()
    {
        c("\r\n= System status = \r\n");
        a(new String[] {
            "Getting system status", ".", ".", "..", "...", ".", ".\r\n"
        });
        i i1 = (i)a(com/stanfy/contest/a/a/i);
        c((new StringBuilder()).append(" * <lexinterpr> ").append(i1.c()).append("\r\n").toString());
        c((new StringBuilder()).append(" * <engine>     ").append(((k)a(com/stanfy/contest/a/a/k)).c()).append("\r\n").toString());
        if(i1.d())
        {
            c((new StringBuilder()).append(" * <dnalab>     ").append(((h)a(com/stanfy/contest/a/a/h)).d()).append("\r\n").toString());
            c((new StringBuilder()).append(" * <sattelite>  ").append(((d)a(com/stanfy/contest/a/a/d)).e()).append("\r\n").toString());
            c((new StringBuilder()).append(" * <fifth>      ").append(((j)a(com/stanfy/contest/a/a/j)).c()).append("\r\n").toString());
            c((new StringBuilder()).append(" * <aar>        ").append(((com.stanfy.contest.a.a.b)a(com/stanfy/contest/a/a/b)).a()).append("\r\n").toString());
            c((new StringBuilder()).append(" * <clock>      ").append(((a)a(com/stanfy/contest/a/a/a)).a()).append("\r\n").toString());
        }
        c((new StringBuilder()).append("System status check DONE.").append(g()).toString());
    }

    public final String b()
    {
        return "sys-stat";
    }
}

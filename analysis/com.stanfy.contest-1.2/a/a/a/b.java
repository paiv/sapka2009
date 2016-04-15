// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.a;

import com.stanfy.contest.a.a.a;
import com.stanfy.contest.a.a.b.c;
import com.stanfy.contest.a.a.d;
import com.stanfy.contest.a.a.h;
import com.stanfy.contest.a.a.i;
import com.stanfy.contest.a.a.j;
import com.stanfy.contest.a.a.k;
import com.stanfy.contest.a.a.l;
import com.stanfy.contest.a.a.o;
import com.stanfy.contest.f;
import java.util.HashMap;
import org.apache.log4j.Logger;

public final class b
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/a/a/a/b);
    private static b b;
    private HashMap c;
    private HashMap d;

    private b()
    {
        c = new HashMap();
        d = new HashMap();
    }

    public static b a()
    {
        if(b == null)
        {
            b b1;
            (b1 = b = new b()).a(com/stanfy/contest/a/a/o, "memConfig", com/stanfy/contest/a/a/c);
            b1.a(com/stanfy/contest/a/a/o, "launch", com/stanfy/contest/f);
            b1.a(com/stanfy/contest/a/a/c, "passwordIsOk", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/l, "dnaLab", com/stanfy/contest/a/a/h);
            b1.a(com/stanfy/contest/a/a/l, "sattelite", com/stanfy/contest/a/a/d);
            b1.a(com/stanfy/contest/a/a/l, "enginecontrol", com/stanfy/contest/a/a/k);
            b1.a(com/stanfy/contest/a/a/l, "lexicalinterpreter", com/stanfy/contest/a/a/i);
            b1.a(com/stanfy/contest/a/a/l, "fifthModule", com/stanfy/contest/a/a/j);
            b1.a(com/stanfy/contest/a/a/l, "bfModule", com/stanfy/contest/a/a/b);
            b1.a(com/stanfy/contest/a/a/l, "xorModule", com/stanfy/contest/a/a/a);
            b1.a(com/stanfy/contest/a/a/j, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/k, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/h, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/d, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/i, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/b, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/a, "statusExit", com/stanfy/contest/a/a/l);
            b1.a(com/stanfy/contest/a/a/l, "statusExit", com/stanfy/contest/a/a/o);
        }
        return b;
    }

    public final c a(com.stanfy.contest.a.a.b.b b1, c c1, String s)
    {
        a.debug((new StringBuilder()).append("Getting next module for ").append(c1.getClass().getSimpleName()).append(" and exit result ").append(s).toString());
        Object obj;
        if((obj = (HashMap)c.get(c1.getClass())) == null)
        {
            a.error((new StringBuilder()).append("Cannot find any exit results for ").append(c1.getClass().getSimpleName()).toString());
            return null;
        }
        if((obj = (Class)((HashMap) (obj)).get(s)) == null)
        {
            a.error((new StringBuilder()).append("Cannot find any next module class for ").append(c1.getClass().getSimpleName()).append(" and exit result ").append(s).toString());
            return null;
        } else
        {
            return a(b1, ((Class) (obj)));
        }
    }

    public final c a(com.stanfy.contest.a.a.b.b b1, Class class1)
    {
        a.debug((new StringBuilder()).append("Getting ").append(class1.getSimpleName()).append(" module instance for player ").append(b1).toString());
        HashMap hashmap;
        if((hashmap = (HashMap)d.get(b1)) == null)
        {
            a.debug("Such player is not registered yet, adding instances map for him");
            hashmap = new HashMap();
            d.put(b1, hashmap);
        }
        if((this = (c)hashmap.get(class1)) == null)
        {
            a.debug((new StringBuilder()).append("Module instance is not instantiated. Creating new ").append(class1.getSimpleName()).append(" module instance").toString());
            if(class1 == com/stanfy/contest/f)
            {
                this = f.h();
                a.debug((new StringBuilder()).append("Received modelController : ").append(this).toString());
            } else
            {
                try
                {
                    b(b1);
                }
                // Misplaced declaration of an exception variable
                catch(b this)
                {
                    a.error((new StringBuilder()).append("Cannot instantiate module : ").append(getMessage()).toString());
                    return null;
                }
            }
            hashmap.put(class1, this);
        }
        return this;
    }

    private void a(Class class1, String s, Class class2)
    {
        HashMap hashmap;
        if((hashmap = (HashMap)c.get(class1)) == null)
        {
            a.debug((new StringBuilder()).append("Currently there's no forwarding rules for ").append(class1).toString());
            hashmap = new HashMap();
            c.put(class1, hashmap);
        }
        hashmap.put(s, class2);
        a.debug((new StringBuilder()).append("Rule added : ").append(class1.getSimpleName()).append("(").append(s).append(") -> ").append(class2.getSimpleName()).toString());
    }

}

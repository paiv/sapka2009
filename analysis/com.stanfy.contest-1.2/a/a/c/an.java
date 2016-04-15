// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.ArrayList;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, ao, y

public final class an extends o
{

    private ArrayList a;
    private ArrayList b;
    private ArrayList c;

    public an(String s)
    {
        super(s);
        c = new ArrayList();
        a = new ArrayList();
        b = new ArrayList();
    }

    public final Object a(am am1)
    {
        Object obj = null;
        if(c.size() > 0)
        {
            am1 = a.toString();
            this = "ENDIF";
            throw new y((new StringBuilder()).append("Expecting '").append(this).append("', but ").append(am1).append(" found.").toString());
        }
        int i = 0;
        do
        {
            if(i >= a.size())
                break;
            String s;
            if((s = (String)a.get(i)).matches("IFTHEN\\d+"))
            {
                s = Integer.valueOf(s.substring("IFTHEN".length())).intValue();
                int j;
                if((j = am.a(am1.b("DROP")).intValue()) == 0)
                {
                    if((s = (ao)b.get(s)).b())
                        i = s.a();
                    else
                        i = s.c();
                    continue;
                }
                if(j != -1)
                {
                    this = String.valueOf(j);
                    throw new y((new StringBuilder()).append("Data must be boolean (0 = FALSE), (-1 = TRUE)(").append(this).append(").").toString());
                }
            } else
            {
                if(s.matches("ELSE\\d+"))
                {
                    s = Integer.valueOf(s.substring("ELSE".length())).intValue();
                    ao ao1;
                    i = (ao1 = (ao)b.get(s)).c();
                    continue;
                }
                if(!s.matches("ENDIF\\d+"))
                    obj = am1.b(s);
            }
            i++;
        } while(true);
        return obj;
    }

    public final void a(String s)
    {
        if(s.equals("IFTHEN"))
        {
            a.add((new StringBuilder()).append("IFTHEN").append(b.size()).toString());
            s = new ao(a.size());
            b.add(s);
            c.add(Integer.valueOf(b.size() - 1));
            return;
        }
        if(s.equals("ELSE"))
            if(c.size() == 0)
            {
                throw y.c("ELSE");
            } else
            {
                s = ((Integer)c.get(c.size() - 1)).intValue();
                a.add((new StringBuilder()).append("ELSE").append(s).toString());
                ((ao)b.get(s)).a(a.size());
                return;
            }
        if(s.equals("ENDIF"))
        {
            if(c.size() == 0)
            {
                throw y.c("ENDIF");
            } else
            {
                s = ((Integer)c.get(c.size() - 1)).intValue();
                a.add((new StringBuilder()).append("ENDIF").append(s).toString());
                ((ao)b.get(s)).b(a.size() - 1);
                c.remove(c.size() - 1);
                return;
            }
        } else
        {
            a.add(s);
            return;
        }
    }

    public final String a()
    {
        return (new StringBuilder()).append("USER-DEFINED WORD : ").append(a.toString()).toString();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.b:
//            l, o, s

public final class d
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/b/d);
    private int b;
    private double c[];
    private double d;
    private double e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    public d(InputStream inputstream)
    {
        try
        {
            Properties properties;
            (properties = new Properties()).load(inputstream);
            b = Integer.parseInt(properties.getProperty("rounds.count"));
            a.debug((new StringBuilder()).append("roundsCount = ").append(b).toString());
            f = Integer.parseInt(properties.getProperty("width"));
            a.debug((new StringBuilder()).append("width = ").append(f).toString());
            g = Integer.parseInt(properties.getProperty("height"));
            a.debug((new StringBuilder()).append("height = ").append(g).toString());
            h = Integer.parseInt(properties.getProperty("cell.size"));
            a.debug((new StringBuilder()).append("cellSize = ").append(h).toString());
            c = new double[s.values().length];
            int i1 = (inputstream = s.values()).length;
            for(int k1 = 0; k1 < i1; k1++)
            {
                s s1 = inputstream[k1];
                String s2 = properties.getProperty((new StringBuilder()).append("bonus.").append(s1.toString()).toString());
                c[s1.ordinal()] = s2 == null ? s1.c() : Double.parseDouble(s2);
                a.debug((new StringBuilder()).append(s1.toString()).append(" = ").append(c[s1.ordinal()]).toString());
            }

            inputstream = properties.getProperty("bonus.unknown");
            e = inputstream == null ? 0.37D : Double.parseDouble(inputstream);
            a.debug((new StringBuilder()).append("unknownBonusProbability = ").append(e).toString());
        }
        catch(Exception exception)
        {
            throw new l(exception);
        }
        for(int k = 1; k < c.length; k++)
            c[k] += c[k - 1];

        d = c[c.length - 1];
        if(d > 0.90000000000000002D)
            throw new l((new StringBuilder()).append("Probability of bonus appearence is to big: ").append(d).toString());
        i = h >> 2;
        int j1;
        if((j1 = h / i) == 0)
            j1 = 1;
        j1 <<= 1;
        j = j1 << 2;
    }

    public final double a()
    {
        return e;
    }

    public final double b()
    {
        return d;
    }

    public final int c()
    {
        return j;
    }

    public final int d()
    {
        return i;
    }

    public final int e()
    {
        return b;
    }

    public final int f()
    {
        return f;
    }

    public final int g()
    {
        return g;
    }

    public final int h()
    {
        return h;
    }

    public final int i()
    {
        return h;
    }

    public final s a(double d1)
    {
        for(int k = 0; k < c.length; k++)
            if(d1 < c[k])
                return s.values()[k];

        return null;
    }

}

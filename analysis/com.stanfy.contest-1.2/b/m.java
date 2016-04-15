// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.b;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.b:
//            b, f, g, h, 
//            n, o, t

public class m extends ArrayList
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/b/m);
    private static final h b = new n(-1, -1, null);


    private m(int i)
    {
        super(i);
    }

    public final h a()
    {
        if(size() == 0)
            return b;
        else
            return (h)get(size() - 1);
    }

    public final boolean a(boolean flag)
    {
        for(this = iterator(); hasNext();)
        {
            h h1;
            if((h1 = (h)next()) instanceof f)
                return false;
            if(h1 instanceof g)
                return false;
            if(h1 instanceof t)
                return false;
            if(!flag && (h1 instanceof b))
                return false;
        }

        return true;
    }

    public final boolean b()
    {
        h h1;
        for(this = iterator(); hasNext();)
            if(((h1 = (h)next()) instanceof t) || (h1 instanceof f) || (h1 instanceof g) || (h1 instanceof o))
                return false;

        return true;
    }

    public final boolean c()
    {
        h h1;
        for(this = iterator(); hasNext();)
            if((h1 = (h)next()) instanceof t)
                return true;

        return false;
    }

    public final boolean d()
    {
        return !(a() instanceof t);
    }

    public final m e()
    {
        m m1 = new m(size());
        for(int i = 0; i < size(); i++)
        {
            h h1 = (h)get(i);
            try
            {
                m1.add(h1.f());
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                a.error("Cannot clone bcel!!!!!!!!!!", clonenotsupportedexception);
            }
        }

        return m1;
    }

    public volatile Object clone()
    {
        return e();
    }

}

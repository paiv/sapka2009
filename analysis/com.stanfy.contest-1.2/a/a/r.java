// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.a.a.j;
import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.a.a.c.am;
import com.stanfy.contest.a.a.c.o;
import com.stanfy.contest.a.a.c.y;
import com.stanfy.contest.b.k;
import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a:
//            j, u

final class r extends o
{

    private com.stanfy.contest.a.a.j a;

    r(com.stanfy.contest.a.a.j j1, String s)
    {
        a = j1;
        super(s);
    }

    public final Object a(am am1)
    {
        Stack stack = am1.b();
        for(int i = 0; i < 20; i++)
        {
            int l = (int)(Math.random() * 1000D);
            int i1 = (int)(Math.random() * 1000D);
            int j1 = (int)(Math.random() * 50D);
            int k1 = (int)(Math.random() * 50D);
            int l1 = (int)(Math.random() * 5D);
            int i2 = (int)(Math.random() * 5D);
            int k2 = (int)(Math.random() * 25D) << 1;
            int l2 = (int)(Math.random() * 1000D);
            int i3 = (int)(Math.random() * 1000D);
            int j3 = (int)(Math.random() * 50D);
            int k3 = (int)(Math.random() * 50D);
            int l3 = (int)(Math.random() * 5D);
            int i4 = (int)(Math.random() * 5D);
            int j4 = (int)(Math.random() * 25D) << 1;
            int k4 = (int)(Math.random() * 25D) << 1;
            stack.push(Integer.valueOf(l));
            stack.push(Integer.valueOf(i1));
            stack.push(Integer.valueOf(j1));
            stack.push(Integer.valueOf(k1));
            stack.push(Integer.valueOf(l1));
            stack.push(Integer.valueOf(i2));
            stack.push(Integer.valueOf(k2));
            stack.push(Integer.valueOf(l2));
            stack.push(Integer.valueOf(i3));
            stack.push(Integer.valueOf(j3));
            stack.push(Integer.valueOf(k3));
            stack.push(Integer.valueOf(l3));
            stack.push(Integer.valueOf(i4));
            stack.push(Integer.valueOf(j4));
            stack.push(Integer.valueOf(k4));
            try
            {
                am1.b("GET_DISTANCE");
                Object obj;
                if(!((obj = am1.b("DROP")) instanceof Integer))
                    throw y.a(obj.toString());
                j4 = k4 - j4 >= 0 ? k4 - j4 : 0;
                k2 = k4 - k2 >= 0 ? k4 - k2 : 0;
                l2 = l2 + j3 * j4 + (l3 * j4 * j4) / 2;
                i3 = i3 + k3 * j4 + (i4 * j4 * j4) / 2;
                l = l + j1 * k2 + (l1 * k2 * k2) / 2;
                i1 = i1 + k1 * k2 + (i2 * k2 * k2) / 2;
                l = (l2 - l) * (l2 - l) + (i3 - i1) * (i3 - i1);
                if(((Integer)obj).intValue() != l)
                    throw new y((new StringBuilder()).append("There's no object at distance ").append(obj).append(". Closest object is now at ").append(l).toString());
            }
            catch(Exception exception)
            {
                a.c((new StringBuilder()).append("Cannot locate object by specified GET_COORD function - ").append(exception.getMessage()).toString());
                return null;
            }
            a.c((new StringBuilder()).append("\r\nCheck").append(i).append(" done.").toString());
        }

        a.c("Object has been located!\r\n");
        String as[] = {
            "Getting info.", ".", ".", ".", ".", ".\r\n"
        };
        long l4 = 500L;
        am1 = a;
        a.a(as, l4);
        a.c(" - Object speed has been determined. \r\n");
        a.c(" - Object annihilators strength has been determined. \r\n");
        a.c(" - Object annihilators count has been deermined. \r\n");
        a.c((new StringBuilder()).append(" To activate this 'Scanning and detection' module use configuration token : ").append(a.e("loo0wTSQvgAOWpcoJD36")).append("\r\n").toString());
        a.c((new StringBuilder()).append(" To save that this problem was solved, use this DMA token : ").append(a.d("mwyV8xyrWHPxjh5mEIbu")).append("\r\n").toString());
        a.c("Updating sattelite data....\r\n");
        com.stanfy.contest.b.e e = a.a.a().u();
        j j2;
        (j2 = new j()).a(e);
        a.f();
        j.a(a, true);
        return "GET_DISTANCE_CHECK = TRUE";
    }

    public final String a()
    {
        return "Checks GET_DISTANCE function";
    }
}

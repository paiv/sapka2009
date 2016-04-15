// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.a.a.h;
import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.a.a.c.am;
import com.stanfy.contest.a.a.c.o;
import com.stanfy.contest.a.a.c.y;
import com.stanfy.contest.b.k;
import com.stanfy.contest.d.a;
import java.util.HashMap;
import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a:
//            j, u

final class q extends o
{

    private j a;

    q(j j1, String s)
    {
        a = j1;
        super(s);
    }

    public final Object a(am am1)
    {
        if(am1.c("MAJEDOC") == null)
        {
            a.c("\r\n MAJEDOC function is not found.\r\n");
            return "MAJEDOC ins't found";
        }
        for(int i = 0; i < 25; i++)
        {
            Object obj = new HashMap();
            int l = (int)(Math.random() * 15D) + 1;
            String s = "";
            for(int i1 = 0; i1 < l; i1++)
            {
                char c;
                for(c = com.stanfy.contest.d.a.a(); s.contains((new StringBuilder()).append(c).append("").toString()) || c == ' '; c = com.stanfy.contest.d.a.a());
                s = (new StringBuilder()).append(s).append(c).toString();
                ((HashMap) (obj)).put(Character.valueOf(c), Integer.valueOf(i1));
            }

            int k1 = (int)(Math.random() * 5D) + 1;
            obj = "";
            l = 0;
            int j1 = 1;
            for(int l1 = 0; l1 <= k1; l1++)
            {
                int i2 = (int)((double)s.length() * Math.random());
                obj = (new StringBuilder()).append(s.charAt(i2)).append(((String) (obj))).toString();
                l += i2 * j1;
                j1 *= s.length();
            }

            am1.b().push(s);
            am1.b().push(obj);
            try
            {
                am1.b("MAJEDOC");
                Object obj1;
                if(!((obj1 = am1.b("DROP")) instanceof Integer))
                    throw y.a(obj1.toString());
                if(l != ((Integer)obj1).intValue())
                {
                    a.c((new StringBuilder()).append("\r\nMAJEDOC returned ").append(obj1).append(" on input ").append(s).append(" ").append(((String) (obj))).append(", but correct result is ").append(l).append("\r\n").toString());
                    return null;
                }
            }
            catch(Exception exception)
            {
                a.c((new StringBuilder()).append("Cannot run MAJEDOC function - ").append(exception.getMessage()).toString());
                return null;
            }
        }

        a.c("MAJEDOC function works correctly!\r\n");
        String as[] = {
            "Connecting to sattelites.", ".", ".", ".", ".", ".\r\n"
        };
        long l2 = 300L;
        am1 = a;
        a.a(as, l2);
        as = (new String[] {
            "Translating coordinates.", ".", ".", ".", ".", "Done.\r\n"
        });
        l2 = 300L;
        am1 = a;
        a.a(as, l2);
        (am1 = new h()).a(a.a.a().u());
        a.c("Updating sattelite data....\r\n");
        a.f();
        a.c((new StringBuilder()).append("\r\n To activate this 'Numerical systems translate' module use configuration token : ").append(a.e("xkupLmctzs7BGKISFzE1")).append("\r\n").toString());
        a.c((new StringBuilder()).append(" To save that this problem was solved, use this DMA token : ").append(a.d("NldhUVcw9g1H9wcDbZrA")).append("\r\n").toString());
        com.stanfy.contest.a.a.j.b(a, true);
        return "MAJEDOC OK";
    }

    public final String a()
    {
        return "Checks MAJEDOC function \r\n MAJEDOC function is function that translates one NS to another\r\n INPUT PARAMETERS(IN STACK)\r\n   -------------------------BOTTOM OF STACK -----------------------------------------------\r\n   <SOURCE_NS_DIGITS> - String that contains all source numeral system chars i.e. '01'\r\n   <SOURCE_NS_NUMBER> - String that contains Number that written in SOURCE_NS i.e. '10011'\r\n   -------------------------  TOP OF STACK -----------------------------------------------\r\n OUTPUT PARAMETERS(TO STACK)\r\n   <DECIMAL_NS_NUMBER> - Number that written in DECIMAL_NS i.e. 17 \r\n";
    }
}

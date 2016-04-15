// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.a.a.c.am;
import com.stanfy.contest.a.a.c.y;
import java.util.HashMap;
import org.apache.log4j.Logger;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, d, q, r, 
//            s, t

public class j extends u
{

    private static final Logger c = Logger.getLogger(com/stanfy/contest/a/a/j);
    private boolean d;
    private boolean e;
    private am f;

    public j()
    {
        f = new am();
    }

    public final void a(b b1)
    {
        super.a(b1);
        f.a(this);
        c("\r\n ====== 'FIFTH' INTERPRETER  =============\r\n");
        c("Use 'HELP;' for help, 'QUIT;' for quit;, 'TASKS' for unresolved tasks.\r\n");
        if(!d)
        {
            c("Unresolved task found : MOVING OBJECT IDENTIFICATION problem (PROBLEM349)\r\n");
            ((j) (b1 = this)).f.a(new r(b1, "GET_DISTANCE_CHECK"));
        }
        if(!e && ((d)a(com/stanfy/contest/a/a/d)).d())
        {
            c("Unresolved task found : DIFFERENT NUMERAL SYSTEMS problem (PROBLEM954)\r\n");
            ((j) (b1 = this)).f.a(new q(b1, "MAJEDOC_CHECK"));
        }
        c((new StringBuilder()).append("").append(g()).toString());
    }

    public final void a(String s1)
    {
        c("\r\n");
        if(s1.equals("PROBLEM349"))
        {
            (s1 = this).c(" ====== PROBLEM #349 DESCRIPTION  =============\r\n");
            s1.c(" Objects 'move function' cannot be identified.\r\n");
            s1.c(" Likely error : not correct coordinate system.\r\n");
            s1.c(" Function is needed to determine the distance for deeper object analysis. \r\n");
            s1.c(" Current GET_DISTANCE function must be replaced. input GET_DISTANCE to get more info. \r\n");
            if(((j) (s1)).f.c("GET_DISTANCE") == null)
                try
                {
                    ((j) (s1)).f.b(": GET_DISTANCE  'Current realisation of this function just describes input and output parameters\r\n' 'INPUT PARAMS(FROM STACK) : \r\n'  '  -------------------------BOTTOM OF STACK -----------------------------------------\r\n'  '  OBJX OBJY - object starting coordinates\r\n'  '  OBJVELX OBJVELY - object starting velocities (by each dimension)\r\n'  '  OBJACCELX OBJACCELY - object accelerations (by each dimension)\r\n'  '  OBJSTARTTIME - Time, when object began to move\r\n'  '  SELFX SELFY - SAPKA starting coordinates\r\n'  '  SELFVELX SELFVELY - SAPKA starting velocities (by each dimension)\r\n'  '  SELFACCELX SELFACCELY - SAPKA accelerations (by each dimension)\r\n'  '  SELFSTARTTIME - Time, when object began to move\r\n'  '  CURRTIME - current time  <-- HERE IS TOP OF STACK \r\n'  '  -------------------------  TOP OF STACK ------------------------------------------\r\n' 'OUTPUT PARAMS(TO STACK)\r\n' '  CURR_DISTANCE - SQUARE of distance between OBJECT and SAPKA \r\n' + + + + + + + + + + + + . DROP  //");
                }
                catch(y y1)
                {
                    s1.c((new StringBuilder()).append("Error when getting distance").append(y1.getMessage()).toString());
                }
            s1.c(" Input GET_DISTANCE_CHECK, to resolve problem with CURRENT GET_DISTANCE function \r\n");
            c((new StringBuilder()).append("").append(g()).toString());
            return;
        }
        if(((d)a(com/stanfy/contest/a/a/d)).d() && s1.equals("PROBLEM954"))
        {
            (s1 = this).c(" ====== PROBLEM #954 DESCRIPTION  =============\r\n");
            s1.c(" Sattelites use different numeral systems(NS).\r\n");
            s1.c(" Different sattelites data is needed to get SAPKA's coordinates with high precision.\r\n");
            s1.c(" MAJEDOC Function that translates sattelites NS cannot be found. \r\n");
            s1.c(" At now, only sattelites with '0123456789' NS can be used. \r\n");
            s1.c(" All sattelites send data in format : 'all NS digits' 'number in specified NS'\r\n");
            s1.c(" Example : \r\n");
            s1.c(" 'a'  'aaaaa' ==> 4 (decimal NS) \r\n");
            s1.c(" 'ab' 'baaaab' ==> 33 (decimal NS) \r\n");
            s1.c(" '01234567890abcdef' 'ff' ==> 255 (decimal numeral system) \r\n");
            s1.c(" MAJEDOC function is needed for translating one NS to another\r\n");
            s1.c("Input ?MAJEDOC_CHECK to get more info about MAJEDOC input-output parameters \r\n");
            s1.c("Input MAJEDOC_CHECK to check current MAJEDOC function implementation \r\n");
            c((new StringBuilder()).append("").append(g()).toString());
            return;
        }
        if(s1.equals("TASKS"))
        {
            String as[] = {
                "Searching for unresolved tasks", ".", ".", ".", ".", ".", ".\r\n"
            };
            long l = 1000L;
            s1 = this;
            a(as, l);
            if(!d)
                c("Unresolved task found : MOVING OBJECT IDENTIFICATION problem (PROBLEM349)\r\n");
            if(!e && ((d)a(com/stanfy/contest/a/a/d)).d())
                c("Unresolved task found : DIFFERENT NUMERAL SYSTEMS problem (PROBLEM954)\r\n");
        } else
        {
            try
            {
                f.b(s1);
            }
            // Misplaced declaration of an exception variable
            catch(String s1)
            {
                c.warn("Error inside the Fifth interpreter", s1);
                c(s1.getMessage());
            }
        }
        c(g());
    }

    public final HashMap a_()
    {
        HashMap hashmap;
        (hashmap = super.a_()).put(d("mwyV8xyrWHPxjh5mEIbu"), new t(this, com/stanfy/contest/a/a/j));
        hashmap.put(d("NldhUVcw9g1H9wcDbZrA"), new s(this, com/stanfy/contest/a/a/j));
        return hashmap;
    }

    public final String c()
    {
        this = (d ? 0 : 1) + (!e && ((d)a(com/stanfy/contest/a/a/d)).d() ? 1 : 0);
        return (new StringBuilder()).append("FIFTH module ").append(this != 0 ? (new StringBuilder()).append(" has ").append(this).append(" unresolved problems.").toString() : " has no unresolved problems.").toString();
    }

    public final boolean d()
    {
        return d;
    }

    public final String b()
    {
        return (new StringBuilder()).append("fifth").append(f.c() ? "|def" : "").toString();
    }

    static boolean a(j j1, boolean flag)
    {
        return j1.d = true;
    }

    static boolean b(j j1, boolean flag)
    {
        return j1.e = true;
    }

}

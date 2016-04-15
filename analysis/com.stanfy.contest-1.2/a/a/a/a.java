// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.a;

import org.apache.log4j.Logger;

public final class a
{

    private static final Logger a = Logger.getLogger(com/stanfy/contest/a/a/a/a);

    private a()
    {
    }

    public static String a(boolean flag, String s, String s1)
    {
        s1 = new StringBuilder(s1.substring(0, Math.min(80, s1.length())));
        int i = 1;
        do
        {
            if(s1.length() >= 80)
                break;
            s1.append(i);
            if((i += 2) > 8)
                i -= 8;
        } while(true);
        s1 = s1.toString().getBytes();
        s = s.toString().getBytes();
        char ac[] = new char[20];
        int j = 8726;
        for(int k = 0; k < 20; k++)
        {
            int l = s1[k] * s1[k + 20] * j + s1[k + 40] * s1[k + 60];
            j = (j | l) << 4 ^ (l | s[k] + k);
            ac[k] = (char)(64 + (j >= 0 ? j : -j) % 58);
            for(int i1 = 0; ac[k] >= '[' && ac[k] <= '`' || ac[k] < '@' || ac[k] > 'z'; i1++)
            {
                char c = (char)(64 + (ac[k] << 3 + (k + 1) + s[k] ^ (j >= 0 ? j : -j) + i1) % 58);
                c = (char)(64 + (c + i1) % 58);
                ac[k] = c;
                a.debug((new StringBuilder()).append("Current resultChar is ").append(ac[k]).toString());
            }

        }

        return (new StringBuilder()).append(flag ? "CFG" : "DMA").append(String.valueOf(ac)).toString();
    }

}

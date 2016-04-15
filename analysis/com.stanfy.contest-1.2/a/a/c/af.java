// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class af extends o
{

    private am a;

    af(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.b(am.a(am1).pop());
        try
        {
            int i = Integer.valueOf(this).intValue();
            am.a(am1).push(Integer.valueOf(i));
            return Integer.valueOf(i);
        }
        catch(NumberFormatException _ex)
        {
            throw y.a(this);
        }
    }

    public final String a()
    {
        return "Converts String to int, ant puts result at top of stack\r\n Only String is alllowed : <STRING> STRTOINT -> <INT> \r\n EXAMPLE: '42' STRTOINT . OUTPUT:42";
    }
}

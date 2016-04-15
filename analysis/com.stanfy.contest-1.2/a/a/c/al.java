// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class al extends o
{

    private am a;

    al(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        this = am.b(am.a(am1).pop());
        try
        {
            char c = charAt(0);
            am.a(am1).push(Integer.valueOf(c));
            return Integer.valueOf(c);
        }
        catch(StringIndexOutOfBoundsException _ex)
        {
            throw y.a(this, 0, 0);
        }
    }

    public final String a()
    {
        return "Gets String's first character, converts it to ordinal value and puts it at top of stack\r\n Only Strings are allowed : <STRING> ORD -> <INT> \r\n EXAMPLE: 'stake' ORD . OUTPUT:115\r\n          'a' ORD . OUTPUT:97";
    }
}

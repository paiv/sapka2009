// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.HashMap;
import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class r extends o
{

    private am a;

    r(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        am1 = am.b(am.a(am1).pop());
        a.a(am1);
        return am.b(a).get(am1);
    }

    public final String a()
    {
        return "Creates variable with name, than is in String at top of stack\r\n Only Strings are allowed : <STRING> VAR -> <>\r\n Variables redeclaring is allowed, but only one instance of variable can be at same time\r\n Use ->A to store data to variable, and @A to get data from it\r\n EXAMPLE: 'A' VAR 3 ->A  @A . OUTPUT:3";
    }
}

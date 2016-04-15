// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class x extends o
{

    private am a;

    x(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        if((this = ((x) (am.a(am1).pop()))) instanceof String)
        {
            this = (String)this;
            String s = am.b(am.a(am1).pop());
            am.a(am1).push((new StringBuilder()).append(s).append(this).toString());
            return (new StringBuilder()).append(s).append(this).toString();
        } else
        {
            this = am.a(this).intValue();
            int i = am.a(am.a(am1).pop()).intValue();
            am.a(am1).push(Integer.valueOf(this + i));
            return Integer.valueOf(this + this);
        }
    }

    public final String a()
    {
        return "Adds two operands at top of stack, returns result to top of stack\r\n Strings or Ints are allowed : <INT> <INT> + -> <INT>, <STRING> <STRING> -> + <STRING>\r\n EXAMPLE: 3 2 + . OUTPUT:5\r\n          'a' 'b' +. OUTPUT:ab";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import java.util.Stack;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class f extends o
{

    private am a;

    f(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        am1 = ((am) (am.a(am1).isEmpty() ? "Stack is empty" : ((am) (am.a(am1).peek()))));
        a.d(am1.toString());
        return am1;
    }

    public final String a()
    {
        return "Outputs value at top of stack. Doesn't changing stack.\r\n All types are allowed : <OBJ1> . -> <OBJ1> \r\n EXAMPLE: 115 . OUTPUT:115\r\n          'arkanzas' . OUTPUT:arkanzas\r\n          . OUTPUT:Stack is empty";
    }
}

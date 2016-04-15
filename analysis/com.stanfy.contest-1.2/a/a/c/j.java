// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;


// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class j extends o
{

    j(am am1, String s)
    {
        super(s);
    }

    public final Object a(am am1)
    {
        return "ENDIF";
    }

    public final String a()
    {
        return "Part of LOGICAL BRANCH creation. \r\nFORMAT  :  (EXPRESSION)IFTHEN <LIST OF COMMANDS ON TRUE> [ELSE <LIST OF COMMANDS ON FALSE> ] ENDIF\r\nEXAMPLE :  @A @B > IFTHEN  @A ->C ELSE @B ->C ENDIF ; Calculates max and puts it in variable C\r\n";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;


// Referenced classes of package com.stanfy.contest.a.a.c:
//            o, am, y

final class d extends o
{

    private am a;

    d(am am1, String s)
    {
        a = am1;
        super(s);
    }

    public final Object a(am am1)
    {
        a.d("\r\n");
        a.d(" == 'FIFTH' INTERPRETER == \r\n");
        a.d(" Fifth is stack-based programming language.\r\n");
        a.d(" It relies on exlicit use of data stack and postfix notation, so operators are placed after operands. \r\n");
        a.d(" Extending the compiler reques writing a new word (input '?DEFINITION;' to get more information)\r\n");
        a.d(" To see all registered defitions, input 'WORDS;'\r\n");
        a.d(" To get info about definition, input '?<DEFITION_NAME>;'\r\n");
        a.d(" \r\n");
        a.d(" EXAMPLE : ");
        a.d("     5 3 4 + * .  ;   Calculates (4 + 3) * 5.  '.' outputs result(top of stack)\r\n");
        a.d("     : MULBY5 5 * // \r\n");
        a.d("     2 MULBY5 . ;   Adds definition MULBY5 and Calculates 2 * 5. \r\n>");
        return "'FIFTH' HELP";
    }

    public final String a()
    {
        return "Outputs Help. Doesn't changing stack.\r\n All types are allowed : <> HELP -> <>";
    }
}

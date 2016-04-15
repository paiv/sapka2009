// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.b.e;
import com.stanfy.contest.b.k;
import com.stanfy.contest.d.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, p

public class i extends u
{

    private boolean c;
    private String d;
    private static final Pattern e = Pattern.compile("([^&]+)&([^&]+)&([^&]*)(&(d\\s\\d+))?");
    private static final Pattern f = Pattern.compile("([\\+|\\-])(.)\\s(\\d+)\\s(\\d+)(\\s(\\d+)\\s(\\d+))?");
    private static Pattern g = Pattern.compile("\\?|((P\\d+)\\s(dead|\\x3F|((\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)\\s([^\\s,]+)(\\si)?))).*");


    public final void a(b b1)
    {
        super.a(b1);
        c("\r\n ====== Lexical interpreter =============\r\n");
        c("Input 'help;' for help, 'quit;' for quit, 'dump;' for get current interpreting data\r\n");
        c("To set the data for interpretation input 'data <data-to-interpret>;'\r\n");
        c((new StringBuilder()).append("To interpret data input 'interpret'").append(g()).toString());
        b1 = this;
        String s = "star What do you know about Doom II GOD MODE? Try it, when typing password explanation mark";
        String s1 = (new StringBuilder()).append("*To get other SAPKAs info at launch, use this config token ").append(b1.e("nAtyB40emoaUDb1iBrKF")).append(". Did you know, that not ").append("only first character can be valid? By the way, this module can interpret all data, that you'll").append(" get at SAPKA launch. But at first, turn this module on, by using this : ").append(b1.d("jnonSXard7wSSPDLesnc")).append(" !").toString();
        String s2 = "star each third exclamation mark";
        s = (new StringBuilder()).append(a(s, 2, 0)).append(s2).toString();
        s2 = "*each second!";
        s1 = (new StringBuilder()).append(a(s1, 1, 0)).append(s2).toString();
        s2 = "*Each 2nd symbol is valid!";
        s = (new StringBuilder()).append(a(s1, s, 0)).append(s2).toString();
        s1 = "*Each 2nd character is valid. But apply shuffle before!";
        s = (new StringBuilder()).append(f(a(s, 1, 0))).append(s1).toString();
        s1 = "*Each 2nd character is valid!";
        s = (new StringBuilder()).append(a(s, 1, 0)).append(s1).toString();
        s1 = "*For each five characters from start, apply shuffle : abcde = eadbc. Do nothing with tail (<5)!";
        s = (new StringBuilder()).append(f(s)).append(s1).toString();
        s1 = "*Each 3rd character in this string is valid. First character is always valid. This is one big string without CR or LF. Always remove information strings at the tail (from * to !). GO!";
        s = (new StringBuilder()).append(a(s, 2, 0)).append(s1).toString();
        b1.d = s;
        if(!c)
            e();
    }

    public final void a(String s)
    {
        if(b)
            return;
        if(s.equals("quit"))
        {
            b("statusExit");
            return;
        }
        if(s.startsWith("data "))
        {
            int j = "data ".length();
            d = s.substring(j, s.length());
            c((new StringBuilder()).append("\r\nInterpretation data was successfully changed").append(g()).toString());
            return;
        }
        if(s.equals("help"))
        {
            c("\r\nLexical Interpreter module can interpret data about changes, that SAPKA will receive.\r\n");
            c("Interpreter uses current configuration. If some parts is unknown, reconfigure SAPKA.\r\n");
            c("Each command that SAPKA will receive at launch phase delimited by ';' character.\r\n");
            c("Examples of commands received by SAPKA, that this interpreter can 'translate'\r\n");
            c(" ?&?& \r\n");
            c(" T34&P0 ?& \r\n");
            c(" T34&P0 3 4 ? 3 ? ?&\r\n");
            c("USAGE example:\r\n");
            c(" dump;      // get current data \r\n");
            c(" data ?&?&; // set data \r\n");
            c(" interpret; // interpret specified data\r\n");
            c((new StringBuilder()).append("It's highly recommended to use this interpreter if you are uncertain about resolved data.").append(g()).toString());
            return;
        }
        if(s.equals("dump"))
        {
            c("\r\n Interpretation data : \r\n");
            c(d);
            c((new StringBuilder()).append("").append(g()).toString());
            return;
        }
        if(s.equals("interpret"))
        {
            e();
            return;
        } else
        {
            c((new StringBuilder()).append("").append(g()).toString());
            return;
        }
    }

    private void e()
    {
        c("Interpreter uses current configuration. If some parts is unknown, reconfigure SAPKA.\r\n");
        c((new StringBuilder()).append("\r\nInterpreting ").append(d).append("\r\n").toString());
        e e1 = a.a().u();
        Matcher matcher;
        if((matcher = e.matcher(d)).matches())
        {
            if(!c)
            {
                c((new StringBuilder()).append("\r\nInterpreter must be turned on. DMA token is needed.").append(g()).toString());
                return;
            }
            c("Matched for 'change-info'\r\n");
            String s = matcher.group(1);
            c((new StringBuilder()).append(" ").append(s).append(e1.e() ? " - Time info. Time, when change occurred." : " - Unknown message part").append("\r\n").toString());
            s = matcher.group(2);
            Object obj1 = g.matcher(s);
            if(e1.f())
            {
                c("SAPKA's info found\r\n");
                if(((Matcher) (obj1)).matches() && !s.equals("?"))
                {
                    if(((Matcher) (obj1)).group(2) != null)
                        c((new StringBuilder()).append(" ").append(((Matcher) (obj1)).group(2)).append(" - SAPKA identifier\r\n").toString());
                    if(((Matcher) (obj1)).group(3).equals("dead"))
                    {
                        c((new StringBuilder()).append(" ").append(((Matcher) (obj1)).group(3)).append(" - SAPKA status\r\n").toString());
                    } else
                    {
                        s = ((Matcher) (obj1)).group(5);
                        String s3 = ((Matcher) (obj1)).group(6);
                        String s5 = ((Matcher) (obj1)).group(7);
                        String s6 = ((Matcher) (obj1)).group(8);
                        String s7 = ((Matcher) (obj1)).group(9);
                        obj1 = ((Matcher) (obj1)).group(10);
                        if(e1.g())
                        {
                            c((new StringBuilder()).append(" ").append(s).append(" - SAPKA x-coordinate (in ").append(e1.h() ? "points" : "cells").append(" )\r\n").toString());
                            c((new StringBuilder()).append(" ").append(s3).append(" - SAPKA y-coordinate (in ").append(e1.h() ? "points" : "cells").append(" )\r\n").toString());
                        } else
                        {
                            c((new StringBuilder()).append(" ").append(s).append(" - Unknown message part\r\n").toString());
                            c((new StringBuilder()).append(" ").append(s3).append(" - Unknown message part\r\n").toString());
                        }
                        if(e1.t())
                            c((new StringBuilder()).append(" ").append(s5).append(" - Annihilators left count\r\n").toString());
                        else
                            c((new StringBuilder()).append(" ").append(s5).append(" - Unknown message part\r\n").toString());
                        if(e1.s())
                            c((new StringBuilder()).append(" ").append(s6).append(" - Annihilators left count\r\n").toString());
                        else
                            c((new StringBuilder()).append(" ").append(s6).append(" - Unknown message part\r\n").toString());
                        if(e1.r())
                            c((new StringBuilder()).append(" ").append(s7).append(" - SAPKA speed\r\n").toString());
                        else
                            c((new StringBuilder()).append(" ").append(s7).append(" - Unknown message part\r\n").toString());
                        if(e1.q() && obj1 != null)
                            c((new StringBuilder()).append(" ").append(((String) (obj1))).append(" - SAPKA is infected\r\n").toString());
                        else
                            c((new StringBuilder()).append(" ").append(((String) (obj1))).append(" - Unknown message part\r\n").toString());
                    }
                } else
                {
                    c((new StringBuilder()).append(" ").append(s).append(" - SAPKAs info part\r\n").toString());
                }
            } else
            {
                c((new StringBuilder()).append(" ").append(s).append(" - Unknown message part\r\n").toString());
            }
            if((s = matcher.group(3)) != null && !s.isEmpty())
            {
                String as[] = s.split(",");
                c((new StringBuilder()).append("MAP CHANGES(").append(as.length).append(") info found\r\n").toString());
                String as1[];
                int j = (as1 = as).length;
                for(int l = 0; l < j; l++)
                {
                    String s2 = as1[l];
                    Object obj;
                    if(((Matcher) (obj = f.matcher(s2))).matches())
                    {
                        String s1 = ((Matcher) (obj)).group(1);
                        s2 = ((Matcher) (obj)).group(1).equals("-") ? "remove substance prefix" : "add substance prefix";
                        String s4 = ((Matcher) (obj)).group(2);
                        String s8 = "unknown substance type";
                        char c1;
                        switch(c1 = s4.charAt(0))
                        {
                        default:
                            break;

                        case 88: // 'X'
                            if(e1.l())
                                s8 = "indestructable substance";
                            break;

                        case 119: // 'w'
                            if(e1.k())
                                s8 = "destructable substance";
                            break;

                        case 42: // '*'
                            if(e1.m())
                                s8 = "annihilator";
                            break;

                        case 98: // 'b'
                            if(e1.o())
                                s8 = "consumable substance, than can be processed into annihilator";
                            break;

                        case 118: // 'v'
                            if(e1.o())
                                s8 = "consumable substance, than affects engine speed";
                            break;

                        case 102: // 'f'
                            if(e1.o())
                                s8 = "consumable substance, than affects annihilator strength";
                            break;

                        case 114: // 'r'
                            if(e1.o())
                                s8 = "consumable substance, than temporarly moving controls";
                            break;

                        case 115: // 's'
                            if(e1.o())
                                s8 = "consumable substance, than temporarly decrease engine speed";
                            break;

                        case 117: // 'u'
                            if(e1.o())
                                s8 = "consumable substance, than temporarly blocks ability to place anihilators";
                            break;

                        case 111: // 'o'
                            if(e1.o())
                                s8 = "consumable substance, than temporarly significally decrease anihilator strength";
                            break;

                        case 35: // '#'
                            if(e1.n())
                                s8 = "extremely dangerous substance with hight temperature";
                            break;
                        }
                        String s9 = ((Matcher) (obj)).group(3);
                        String s10 = ((Matcher) (obj)).group(4);
                        String s11 = ((Matcher) (obj)).group(6);
                        obj = ((Matcher) (obj)).group(7);
                        c((new StringBuilder()).append(" ").append(s1).append(" - ").append(s2).append("\r\n").toString());
                        c((new StringBuilder()).append(" ").append(s4).append(" - ").append(s8).append("\r\n").toString());
                        c((new StringBuilder()).append(" ").append(s9).append(" - substance x-coordinate (in cells)\r\n").toString());
                        c((new StringBuilder()).append(" ").append(s10).append(" - substance y-coordinate (in cells)\r\n").toString());
                        if(s11 != null)
                            c((new StringBuilder()).append(" ").append(s11).append(" - substance strength\r\n").toString());
                        if(obj != null)
                            c((new StringBuilder()).append(" ").append(((String) (obj))).append(" - substance activation/deactivation time\r\n").toString());
                    } else
                    {
                        c((new StringBuilder()).append(" ").append(s2).append(" - Unknown message part\r\n").toString());
                    }
                }

            }
            c((new StringBuilder()).append("\r\nDone.").append(g()).toString());
            return;
        } else
        {
            c((new StringBuilder()).append("\r\nData cannot be interpreted! Please, make sure, that valid data was specified").append(g()).toString());
            return;
        }
    }

    private static String a(String s, int j, int l)
    {
        l = new StringBuilder();
        int i1 = 0;
        for(int j1 = 0; j1 < s.length(); j1++)
        {
            for(; i1 > 0; i1--)
                l.append(com.stanfy.contest.d.a.a());

            l.append(s.charAt(j1));
            i1 = j;
        }

        return l.toString();
    }

    private static String a(String s, String s1, int j)
    {
        j = new StringBuilder();
        for(int l = 0; l < Math.max(s.length(), s1.length()); l++)
        {
            char c1 = l >= s.length() ? com.stanfy.contest.d.a.a() : s.charAt(l);
            j.append(c1);
            c1 = l >= s1.length() ? com.stanfy.contest.d.a.a() : s1.charAt(l);
            j.append(c1);
        }

        return j.toString();
    }

    private static String f(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j;
        for(j = 0; j <= s.length() - 5; j += 5)
        {
            String s1 = s.substring(j, j + 5);
            stringbuilder.append(s1.charAt(1));
            stringbuilder.append(s1.charAt(3));
            stringbuilder.append(s1.charAt(4));
            stringbuilder.append(s1.charAt(2));
            stringbuilder.append(s1.charAt(0));
        }

        stringbuilder.append(s.substring(j, s.length()));
        return stringbuilder.toString();
    }

    public final String c()
    {
        return (new StringBuilder()).append("LEXICAL INTERPRETER - ").append(c ? " working." : " not configured.").toString();
    }

    public final HashMap a_()
    {
        HashMap hashmap;
        (hashmap = super.a_()).put(d("jnonSXard7wSSPDLesnc"), new p(this, com/stanfy/contest/a/a/i));
        return hashmap;
    }

    public final boolean d()
    {
        return c;
    }

    public final String b()
    {
        return "lex-interpr";
    }

    static boolean a(i j, boolean flag)
    {
        return j.c = true;
    }

}

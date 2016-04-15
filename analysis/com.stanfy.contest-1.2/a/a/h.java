// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import java.util.HashMap;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, e, f

public class h extends u
{

    private char c[][][];
    private char d[] = {
        'P', 'C', 'N', 'O', 'H', 'B'
    };
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private static final int i[] = {
        1, 4, 3, 5
    };
    private static final int j[] = {
        5, 3, 4, 1
    };

    public h()
    {
        c = new char[6][2][2];
        e = "ABABAGALAMAGA";
        f = "";
        g = false;
        for(int k = 0; k < 6; k++)
        {
            for(int i1 = 0; i1 < 2; i1++)
            {
                for(int j1 = 0; j1 < 2; j1++)
                    c[k][i1][j1] = d[k];

            }

        }

        for(int l = 0; l < 200; l++)
            if(l % 2 == 1)
                a((int)(Math.random() * 2D), Math.random() > 0.5D);
            else
                b((int)(Math.random() * 2D), Math.random() > 0.5D);

    }

    public final void a(b b1)
    {
        super.a(b1);
        c("\r\n======================== DNA LAB ====================\r\n");
        c("DNA LAB module initiated. Use (help|man) dna; to get help about the module\r\n");
        h();
    }

    public final void a(String s)
    {
        if(b)
            return;
        if(s.isEmpty())
            return;
        if(!e.startsWith((new StringBuilder()).append(f).append(s).toString().toUpperCase()))
            break MISSING_BLOCK_LABEL_78;
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        f;
        append();
        s;
        append();
        toString();
        f;
        break MISSING_BLOCK_LABEL_84;
        f = "";
        if(f.equalsIgnoreCase(e) && !g)
        {
            c("\r\nDeeper DNA processing is enabled. Process DNA to get correct DMA token\r\n");
            g = true;
        }
        if(s.equalsIgnoreCase("help dna") || s.equalsIgnoreCase("man dna") || s.equalsIgnoreCase("help"))
        {
            this = this;
            (s = new StringBuilder()).append("\r\n======================== DNA LAB ====================\r\n");
            s.append("DNA Lab is the tool with extremely high usabilty.\r\n");
            s.append("It uses twelve aminoacids for restructuring DNA parts.\r\n");
            s.append("Aminoacids that can be used in DNA LAB:\r\n");
            s.append(" - sigma dimension aminoacids :\r\n");
            s.append("     Lysine(LA), Proline(PR)\r\n");
            s.append(" - sigma dimension aminoacids antipodes:\r\n");
            s.append("     Tyrosine(TY), Methionine(MA)\r\n");
            s.append(" - theta dimension aminoacids :\r\n");
            s.append("     Alanine(A), Valin(BA)\r\n");
            s.append(" - theta dimension aminoacids antipodes:\r\n");
            s.append("     Serine(SE), Glycine(GA)\r\n");
            s.append("                                                        \r\n");
            s.append("      LA PR  <-----  sigma dimension                    \r\n");
            s.append("      ------   .------ theta dimension                  \r\n");
            s.append(" A  | CC NN | SE                                        \r\n");
            s.append(" BA | NN OO | GA                                        \r\n");
            s.append("      ------                                            \r\n");
            s.append("      TY MA <------- sigma dimension antipodes          \r\n");
            s.append("                                                        \r\n");
            s.append(" DNA reperesented as two intersected thoroidal dimensions\r\n");
            s.append("such as theta and sigma dimension. Using of aminoacid,\r\n");
            s.append("can be done by inputing it's short name i.e. 'A' for Alanine,\r\n");
            s.append("to process DNA, input 'process'. For correct DNA processing,\r\n");
            s.append("DNA must be in absolute form, when each projection of DNA on \r\n");
            s.append("each dimension are .equ.l. Do.not tr..us..D.A...B..for..t. \r\n");
            s.append("fr...I..a...v.....n...........................sdax........ \r\n");
            s.append("............sm,cia......F.................r....a.......... \r\n");
            s.append("n.................dpqf,a...k..vjikqoa..............o...... \r\n");
            s.append((new StringBuilder()).append(">> Data corrupted. End of data ").append(g()).toString());
            c(s.toString());
            return;
        }
        switch(s.toUpperCase().charAt(0))
        {
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
        case 70: // 'F'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 78: // 'N'
        case 79: // 'O'
        case 82: // 'R'
        default:
            break;

        case 65: // 'A'
            if(s.equalsIgnoreCase("A"))
            {
                a(0, true);
                h();
                return;
            }
            break;

        case 66: // 'B'
            if(s.equalsIgnoreCase("BA"))
            {
                a(1, true);
                h();
                return;
            }
            break;

        case 71: // 'G'
            if(s.equalsIgnoreCase("GA"))
            {
                a(1, false);
                h();
                return;
            }
            break;

        case 76: // 'L'
            if(s.equalsIgnoreCase("LA"))
            {
                b(0, true);
                h();
                return;
            }
            break;

        case 77: // 'M'
            if(s.equalsIgnoreCase("MA"))
            {
                b(1, false);
                h();
                return;
            }
            break;

        case 80: // 'P'
            if(s.equalsIgnoreCase("PR"))
            {
                b(1, true);
                h();
                return;
            }
            if(!s.equalsIgnoreCase("PROCESS"))
                break;
            if(!e())
                c((new StringBuilder()).append("\r\nCannot process DNA. DNA is not in absolute form").append(g()).toString());
            return;

        case 83: // 'S'
            if(s.equalsIgnoreCase("SE"))
            {
                a(0, false);
                h();
                return;
            }
            break;

        case 84: // 'T'
            if(s.equalsIgnoreCase("TY"))
            {
                b(0, false);
                h();
                return;
            }
            break;

        case 81: // 'Q'
            if(s.equalsIgnoreCase("QUIT"))
            {
                b("statusExit");
                return;
            }
            break;
        }
        c((new StringBuilder()).append("").append(g()).toString());
        return;
    }

    private boolean e()
    {
        for(int k = 0; k < 6; k++)
        {
            char c1 = c[k][0][0];
            for(int l = 0; l < 2; l++)
            {
                for(int i1 = 0; i1 < 2; i1++)
                    if(c1 != c[k][l][i1])
                        return false;

            }

        }

        h = true;
        a(new String[] {
            "DNA has been successfully processed....                                                \r\n", "Checking environment", ".", ".", ".", "............                                \r\n", "5 substance types found.                                                           \r\n", "Configuring sensors ....                                                            \r\n", "Destructable substance found. Identifier - 'w'.                                      \r\n", "Indestructable substance found. Identifier - 'X'.                                     \r\n", 
            "Unknown, possibly dangerous substance found. Identifier - '*'. Has constant life time. \r\n", "Extremely dangerous substance with high temperature. Identifier - '#'. Has cross shape. With constant ray length.\r\n", (new StringBuilder()).append("Potentially positive substance found. Has several types. Identifiers - 'b', 'f', 'v', '?'. \r\n").append(g ? " '?'  - type analizyng... Can contain several undesirable subtype - 'r', 's', 'u', 'o'.  \r\n" : " '?' - unknown substance type. Possibly positive.  Need deeper analysis through Gryc's Science approach. \r\n").toString(), "Sensor configuration token : ", (new StringBuilder()).append(g ? e("dGmoZ8uKLC0K0Mox0D3T") : e("RhkyCmdgAemW9x8TWVSu")).append("\r\n").toString(), "DNA processed token : ", (new StringBuilder()).append(g ? d("c4qKx5lSLufnzkrdeg7o") : d("KLJexj8DlAi4m1g5Xpf2")).append("\r\n").append("Information about substances format : \r\n").append("info ::= ( <game-info> | <start-round-info> | <map-change-info> | <finish-round-info> | <finish-game-info> ) ';'\r\n").append("map-change-info ::= <time-part> '&' <players-part> '&' <changes-part> [ '&' <danger-part>]\r\n").append("changes-part ::= [ <change-info> [ { ',' <change-info> } ] ]\r\n").append("change-info ::= <add-info> | <remove-info>\r\n").append("add-info ::= '+' ( <add-dangerous-substance> | <add-bonus-substance> | <add-hightemp-substance> | <add-destr-substance> | <add-indestr-substance> )\r\n").append("add-dangerous-substance ::= '*' <sep> <cell-position> <sep> <damaging-range> <sep> <boom-time>\r\n").append("add-bonus-substance ::= <bonus-type> <sep> <cell-position>\r\n").append("add-destr-substance ::= 'w' <sep> <cell-position>\r\n").append("add-indestr-substance ::= 'X' <sep> <cell-position>\r\n").append("add-hightemp-substance ::= '#' <sep> <cell-position> <sep> <damaging-range> <sep> <end-time>\r\n").append("boom-time ::= <number>\r\n").append("end-time ::= <number> \r\n").append("remove-info ::= '-' ( <remove-dangerous-substance> | <remove-bonus-substance> | <remove-hightemp-substance> | <remove-destr-substance> )\r\n").append("remove-dangerous-substance ::= '*' <sep> <cell-position>\r\n").append("remove-bonus-substance ::= <bonus-type> <sep> <cell-position>\r\n").append("remove-hightemp-substance ::= '#' <sep> <cell-position> <sep> <damaging-range>\r\n").append("remove-destr-substance ::= 'w' <sep> <cell-position>\r\n").append("bonus-type ::= 'b' | 'v' | 'f' | 'r' | 's' | 'u' | 'o' | '?'\r\n").append("damaging-range ::= <number>\r\n").append("cell-position ::= <x-cell> <sep> <y-cell>\r\n").append("x-cell ::= <number>\r\n").append("y-cell ::= <number>      \r\n").toString()
        });
        c(g());
        return true;
    }

    private void a(int k, boolean flag)
    {
        char ac[] = c[0][k];
        for(int l = 0; l < 3; l++)
            if(flag)
                c[l][k] = c[l + 1][k];
            else
                c[(4 - l) % 4][k] = c[(3 - l) % 4][k];

        if(flag)
        {
            c[3][k] = ac;
            return;
        } else
        {
            c[1][k] = ac;
            return;
        }
    }

    private void b(int k, boolean flag)
    {
        flag = flag ? ((boolean) (i)) : ((boolean) (j));
        int ai[] = new int[4];
        for(int k1 = 0; k1 < flag.length; k1++)
            ai[k1] = flag[k1] != 3 ? k : 3 - k;

        char ac[] = new char[2];
        for(int l = 0; l < 2; l++)
            ac[l] = c[flag[0]][l][k];

        for(int i1 = 0; i1 < flag.length - 1; i1++)
        {
            boolean flag1 = 3 == flag[i1];
            boolean flag2 = 3 == flag[i1 + 1];
            for(int l1 = 0; l1 < 2; l1++)
                c[flag[i1]][flag1 ? 1 - l1 : l1][flag1 ? 1 - k : k] = c[flag[i1 + 1]][flag2 ? 1 - l1 : l1][flag2 ? 1 - k : k];

        }

        for(int j1 = 0; j1 < 2; j1++)
            c[flag[3]][j1][k] = ac[j1];

    }

    private void h()
    {
        StringBuilder stringbuilder;
        (stringbuilder = new StringBuilder()).append("\r\n");
        for(int k = 0; k < 2; k++)
        {
            for(int l = 0; l < 2; l++)
            {
                for(int i1 = 0; i1 < 2; i1++)
                {
                    stringbuilder.append(" ");
                    stringbuilder.append(c[1][k][i1]);
                    stringbuilder.append(c[1][k][i1]);
                }

                stringbuilder.append("\r\n");
            }

        }

        c((new StringBuilder()).append(stringbuilder.toString()).append(">").toString());
    }

    public final HashMap a_()
    {
        HashMap hashmap;
        (hashmap = super.a_()).put(d("c4qKx5lSLufnzkrdeg7o"), new e(this, com/stanfy/contest/a/a/h));
        hashmap.put(d("KLJexj8DlAi4m1g5Xpf2"), new f(this, com/stanfy/contest/a/a/h));
        return hashmap;
    }

    public final boolean c()
    {
        return g;
    }

    public final String d()
    {
        return (new StringBuilder()).append("DNA LAB - DNA is ").append(h ? "" : "NOT").append(" processed. ").append(g ? "Deeper research done." : "").toString();
    }

    public final String b()
    {
        return "dnalab";
    }

    static boolean a(h h1, boolean flag)
    {
        return h1.g = true;
    }

    static boolean b(h h1, boolean flag)
    {
        return h1.h = true;
    }

}

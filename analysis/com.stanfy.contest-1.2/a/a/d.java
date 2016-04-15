// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a;

import com.stanfy.contest.a.a.b.b;
import com.stanfy.contest.a.a.d.a;
import java.io.Serializable;
import java.util.HashMap;

// Referenced classes of package com.stanfy.contest.a.a:
//            u, m, n

public class d extends u
{

    private boolean c;
    private boolean d;
    private com.stanfy.contest.a.a.d.b e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private a j[];


    public final void a(b b1)
    {
        super.a(b1);
        c("\r\n ====== Sattelite control =============\r\n");
        a(new String[] {
            "Sending command to sattelite", ".", ".", ".", "\r\n"
        });
        if(!c)
        {
            e = new com.stanfy.contest.a.a.d.b();
            if(((d) (b1 = this)).f)
            {
                b1.c("Finish the current game first!");
            } else
            {
                ((d) (b1)).e.a();
                b1.g = 1;
                b1.j = ((d) (b1)).e.a(1);
                b1.h = -1;
                b1.f = true;
            }
            a(new String[] {
                "Error!\r\n", "Cannot instantiate connection with sattelite.\r\n", "Check firewall or cont..!@#asdczko3SAT$D .. ch $@#@@@#$\r\n", "YEAH!!! OR PLAY WITH ME!!! I'M GOD!!! PLAY WITH ME, PLAY!!!!\r\n", "I THINK IT'S YOUR MOVE NOW!!!\r\n", g()
            });
            h();
            return;
        } else
        {
            c((new StringBuilder()).append("Sattelite connection state :").append(d ? "CONNECTED" : "DISCONNECTED").append(".").toString());
            c("Input 'sattelite on|off' to turn on/off sattelite.\r\n");
            c(g());
            return;
        }
    }

    public final void a(String s)
    {
        if(s.equals("state") && !c)
        {
            h();
            return;
        }
        if(s.equals("quit"))
        {
            if(((d) (s = this)).c)
            {
                c("\r\nSometimes viruses can turn the world head over heels.\r\n");
                c("Especially they like to replace '+' with '-' or '<' with '>'.\r\n");
            }
            b("statusExit");
            return;
        }
        if(s.equals("help") || s.equals("hint"))
        {
            if(!c)
            {
                String as[][] = {
                    {
                        "\r\nWHAT KIND OF HELP YOU WANT, MORTAL?\r\n", (new StringBuilder()).append("THERE'S NO CHANCE THAT I'LL HELP YOU!").append(g()).toString()
                    }, {
                        (new StringBuilder()).append("\r\nSUCKER!!! DO YOUR BEST!!! WIN!!!").append(g()).toString()
                    }, {
                        (new StringBuilder()).append("\r\nTHERE'S NO CHANCE FOR YOU!!!").append(g()).toString()
                    }, {
                        (new StringBuilder()).append("\r\nYOU MUST BEG ME!!! YOU CAN TRY 'please help, the chosen one'").append(g()).toString()
                    }
                };
                a(as[(int)(Math.random() * (double)as.length)]);
                return;
            }
            String as1[] = {
                "\r\n Sattelite control module\r\n", "===========================\r\n", "This module controls connection with sattelite.\r\n", "Input 'sattelite on|off' to turn on/off sattelite.\r\n"
            };
            a(as1);
            c(" Initializing part of the data is recieved in next format :\r\n  info ::= ( <game-info> | <start-round-info> | <map-change-info> | <finish-round-info> | <finish-game-info> ) ';'  game-info ::= <sapka-init-info> '&' <map-info>\r\n  sapka-init-info ::= PID <digit>\r\n  map-info ::= <map-cell-size> <string-terminator> { { <map-symbol> } <string-terminator> }\r\n  map-cell-size ::= <number>\r\n  map-symbol ::= '.' | 'X' | 'w'\r\n\r\n  sep ::= ' '\r\n  string-terminator ::= '\r\n'\r\n  number ::= { <digit> }\r\n  digit ::= '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'\r\n");
            f();
        }
        if(s.equals("please help, the chosen one") && !c)
        {
            String as2[] = {
                "\r\nLISTEN, MORTAL!!!\r\n", "WHAT DO YOU KNOW ABOUT GALACTIC WARS GAME?\r\n", "YOU KNOWS NOTHING!!!! WHA-HAHA!!!\r\n", "OBEY THE  G A M E  CREATOR. THE  G A M E  IS PERFECT. DON'T TRY TO UNDERSTAND THE RULES\r\n", "IT JUST WON'T WORK OUT. YOU'RE TOO HUMAN TO BE ABLE TO UNDERSTAND IT. I SAY.\r\n", "SO IF YOU WANT TO VIEW CURRENT STATE, INPUT 'state;'. DO YOU UNDERSTAND ME, SLUG?\r\n", "AND IF YOU WANT TO MAKE MOVE INPUT SOMETHING LIKE 'a1-b2;'.\r\n", (new StringBuilder()).append("BUT THIS WON'T HELP YOU!!! WHA-HA-HA!!!").append(g()).toString()
            };
            a(as2);
            return;
        }
        String as3[];
        if(!c && g == 1 && f && (as3 = s.split("-")) != null && as3.length == 2)
        {
            String s2 = as3[0];
            String s1 = as3[1];
            if(s2.length() == 2 && s1.length() == 2)
            {
                int i1 = s2.charAt(0) - 97;
                int l = s2.charAt(1) - 49;
                int j1 = s1.charAt(0) - 97;
                int k = s1.charAt(1) - 49;
                if(a(i1, l))
                    a(j1, k);
                if(g == 1)
                    c("\r\nMAKE YOUR MOVE, MORTAL!\r\n");
                else
                    while(g == 3 && f) 
                    {
                        c("\r\nMY MOVE IS:");
                        a aa[];
                        a a1 = (aa = e.a(3))[(int)(Math.random() * (double)aa.length)];
                        a(a1.a(), a1.b());
                        a(a1.c(), a1.d());
                        c((new StringBuilder()).append((char)(a1.a() + 97)).append("").append((char)(a1.b() + 49)).append("").append("-").append((char)(a1.c() + 97)).append("").append((char)(a1.d() + 49)).append("\r\n").toString());
                    }
            }
        }
        if(c && s.startsWith("sattelite"))
            if(s.equals("sattelite on"))
            {
                d = true;
                c("Sattelite connection state is CONNECTED\r\n");
                c((new StringBuilder()).append("Configuration token for sattelite connection:").append(e("99qzIHgvjcqNURGGDXI4")).append(g()).toString());
            } else
            if(s.equals("sattelite off"))
            {
                d = false;
                c((new StringBuilder()).append("Sattelite connection state is DISCONNECTED").append(g()).toString());
            }
        c(g());
    }

    private void h()
    {
        StringBuilder stringbuilder;
        (stringbuilder = new StringBuilder()).append("\r\n");
        for(int k = 0; k <= 8; k++)
        {
            stringbuilder.append((new StringBuilder()).append(k != 8 ? ((Object) (Character.valueOf((char)(k + 97)))) : " ").append("  ").toString());
            for(int l = 0; l < 8; l++)
                if(k != 8)
                    switch(e.a(k, l))
                    {
                    case 3: // '\003'
                        stringbuilder.append("b");
                        break;

                    case 1: // '\001'
                        stringbuilder.append("r");
                        break;

                    case 4: // '\004'
                        stringbuilder.append("B");
                        break;

                    case 2: // '\002'
                        stringbuilder.append("R");
                        break;

                    case 0: // '\0'
                        stringbuilder.append((l + k) % 2 != 1 ? "*" : ".");
                        break;
                    }
                else
                    stringbuilder.append(l + 1);

            stringbuilder.append("\r\n");
        }

        stringbuilder.append(">");
        c(stringbuilder.toString());
    }

    private boolean a(int k, int l)
    {
        if(k < 0 || k >= 8 || l < 0 || l >= 8)
            return false;
        for(int i1 = 0; i1 < j.length; i1++)
            if(j[i1].a() == k && j[i1].b() == l)
            {
                h = k;
                i = l;
                return true;
            }

        if(h < 0)
            return false;
        int j1 = 0;
label0:
        do
        {
label1:
            {
label2:
                {
                    if(j1 >= j.length)
                        break label0;
                    if(j[j1].a() != h || j[j1].b() != i || j[j1].c() != k || j[j1].d() != l)
                        break label1;
                    k = j[j1];
                    this = this;
                    j1 = k;
                    l = e;
                    e.a(j1.a(), j1.b(), j1.c(), j1.d());
                    if((l = k).a() - l.c() == 2 || l.c() - l.a() == 2)
                    {
                        j = e.a(g, k.c(), k.d());
                        if(j != null)
                        {
                            h = k.c();
                            i = k.d();
                            break label2;
                        }
                    }
                    k = g != 1 ? "BLACK" : "RED";
                    l = g != 1 ? "RED" : "BLACK";
                    g = g != 1 ? 1 : 3;
                    j = e.a(g);
                    if(j == null)
                    {
                        (new StringBuilder()).append(l).append(" has no moves.  ").append(k).append(" wins.");
                        l = this;
                        if(g == 1)
                        {
                            l.c("\r\nWHAT HAVE YOU DONE?! YOU WON!!. SO I'LL GIVE YOU A LITTLE SECRET:\r\n");
                            l.c("I DON'T KNOW WHAT IT IS, BUT\r\n");
                            l.c((new StringBuilder()).append(l.d("U8sGOxzc1TaIj9NaOOfZ")).append("\r\n").toString());
                            l.a(new String[] {
                                "10", " 9", " 8", " 7", " 6", " 5", " 4", " 3", " 2", " 1", 
                                " 0", " .", ".", ".", ".", ".", ".", ".", ".", ".", 
                                " -1", " -2", " -3", " -4\r\n"
                            }, 1000L);
                            l.c("JUST JOKING. TURNING SELF OFF...\r\n");
                            l.c = true;
                            l.a(((d) (l)).a);
                        } else
                        {
                            l.c("HA-HA, YOU LOSED. WHAT DID I TELL YOU? AND YOU REALLY THINK THAT YOU KNOW THE RULES?");
                        }
                        l.f = false;
                    }
                    h = -1;
                    if(j != null)
                    {
                        k = 1;
                        l = 1;
                        do
                        {
                            if(l >= j.length)
                                break;
                            if(j[l].a() != j[0].a() || j[l].b() != j[0].b())
                            {
                                k = 0;
                                break;
                            }
                            l++;
                        } while(true);
                        if(k != 0)
                        {
                            h = j[0].a();
                            i = j[0].b();
                        }
                    }
                }
                return true;
            }
            j1++;
        } while(true);
        return false;
    }

    public final HashMap a_()
    {
        HashMap hashmap;
        (hashmap = super.a_()).put(d("U8sGOxzc1TaIj9NaOOfZ"), new m(this, com/stanfy/contest/a/a/d));
        hashmap.put(d("veLn0pnyXvPEIsXZw5N8"), new n(this, com/stanfy/contest/a/a/d));
        return hashmap;
    }

    public final boolean c()
    {
        return c;
    }

    public final boolean d()
    {
        return d;
    }

    public final String e()
    {
        return (new StringBuilder()).append("SATTELITE CONTROL - ").append(c ? (new StringBuilder()).append(" sattelite connection state : ").append(d ? "CONNECTED" : "DISCONNECTED").toString() : "Unexpected behaviour. Possibly virus threat.").toString();
    }

    public final String b()
    {
        return "sat-control";
    }

    static boolean a(d d1, boolean flag)
    {
        return d1.c = true;
    }

    static boolean b(d d1, boolean flag)
    {
        return d1.d = true;
    }
}

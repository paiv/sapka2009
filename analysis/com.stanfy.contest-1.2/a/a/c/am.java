// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.c;

import com.stanfy.contest.a.a.u;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.stanfy.contest.a.a.c:
//            a, aa, ab, ac, 
//            ad, ae, af, ag, 
//            ah, ai, aj, ak, 
//            al, an, b, c, 
//            d, e, f, g, 
//            h, i, j, k, 
//            l, m, n, o, 
//            p, q, r, s, 
//            t, u, v, w, 
//            x, y, z

public final class am
{

    private Stack a;
    private HashMap b;
    private HashMap c;
    private HashMap d;
    private u e;
    private boolean f;
    private ArrayList g;
    private int h;
    private Pattern i;

    public am()
    {
        f = false;
        h = 0;
        i = Pattern.compile("('.*?')", 32);
        a = new Stack();
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        b.put("+", new x(this, "+"));
        b.put("-", new w(this, "-"));
        b.put("*", new t(this, "*"));
        b.put("/", new s(this, "/"));
        b.put("%", new v(this, "%"));
        b.put("SWAP", new com.stanfy.contest.a.a.c.u(this, "SWAP"));
        b.put("DUP", new q(this, "DUP"));
        b.put("DROP", new p(this, "DROP"));
        b.put("VAR", new r(this, "VAR"));
        b.put("<", new aa(this, "<"));
        b.put(">", new z(this, ">"));
        b.put("==", new ab(this, "=="));
        b.put("!=", new ac(this, "!="));
        b.put("=0", new ad(this, "=0"));
        b.put("LENGTH", new ae(this, "LENGTH"));
        b.put("STRTOINT", new af(this, "STRTOINT"));
        b.put("INTTOSTR", new ag(this, "INTTOSTR"));
        b.put("SUBSTR", new ah(this, "SUBSTR"));
        b.put("CHARAT", new ai(this, "CHARAT"));
        b.put("POS", new aj(this, "POS"));
        b.put("ORD", new al(this, "ORD"));
        b.put("CHR", new ak(this, "CHR"));
        b.put(".", new f(this, "."));
        b.put("WORDS", new g(this, "WORDS"));
        b.put("HELP", new d(this, "HELP"));
        b.put("?", new e(this, "?"));
        b.put(":", new b(this, ":"));
        b.put("//", new c(this, "//"));
        b.put("IFTHEN", new a(this, "IFTHEN"));
        b.put("ELSE", new k(this, "ELSE"));
        b.put("ENDIF", new j(this, "ENDIF"));
        b.put("->", new i(this, "->"));
        b.put("@", new h(this, "@"));
        b.put("CLEAR", new l(this, "CLEAR"));
        b.put("RESET", new m(this, "RESET"));
        b.put("QUIT", new n(this, "QUIT"));
    }

    public final void a(o o1)
    {
        b.put(o1.toString(), o1);
    }

    public final void a(String s1)
    {
        if(d.get(s1) != null)
        {
            return;
        } else
        {
            d.put(s1, Integer.valueOf(0));
            return;
        }
    }

    public final Object b(String s1)
    {
        Object obj = new ArrayList();
        Object obj1 = s1;
        Pattern pattern;
        for(Matcher matcher = (pattern = Pattern.compile("(.*?)('.*?')(.*)", 32)).matcher(((CharSequence) (obj1))); matcher.matches(); matcher = pattern.matcher(((CharSequence) (obj1))))
        {
            if(!matcher.group(1).isEmpty())
                ((ArrayList) (obj)).add(matcher.group(1));
            ((ArrayList) (obj)).add(matcher.group(2));
            obj1 = matcher.group(3);
        }

        ((ArrayList) (obj)).add(obj1);
        obj1 = null;
        for(obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s2;
            String as[];
            int i1 = (as = as = (s2 = (String)((Iterator) (obj)).next()).startsWith("'") ? (new String[] {
                s2
            }) : s2.replaceAll("\\s{2,}", " ").split(" ")).length;
            int j1 = 0;
            while(j1 < i1) 
            {
                String s3;
                if(!(s3 = as[j1]).isEmpty())
                {
                    h++;
                    if(h > 500)
                    {
                        h = 0;
                        this = s1;
                        throw new y((new StringBuilder()).append("Stack overflow. Possibly - endless recursion (").append(this).append(" called over 500 times").toString());
                    }
                    obj1 = e(s3);
                    h--;
                }
                j1++;
            }
        }

        return obj1;
    }

    private Object e(String s1)
    {
        if(s1.equals(":"))
            if(f)
            {
                throw new y("Definition is already defining.");
            } else
            {
                f = true;
                g = new ArrayList();
                d("Entering to definition creation. To close definition, input //\r\n");
                return ":";
            }
        if(f)
            if(s1.equals("//"))
            {
                if(g.isEmpty())
                    throw new y("Definition name is not specified.");
                String s2 = (String)g.get(0);
                an an1 = new an(s2);
                for(int i1 = 1; i1 < g.size(); i1++)
                    an1.a((String)g.get(i1));

                f = false;
                if(b.get(s2) != null)
                {
                    this = s2;
                    throw new y((new StringBuilder()).append("This word has been already declared (").append(this).append(")").toString());
                } else
                {
                    c.put(s2, an1);
                    return an1;
                }
            } else
            {
                g.add(s1);
                return s1;
            }
        if(s1.startsWith("?"))
        {
            String s3 = s1.substring("?".length(), s1.length());
            o o2;
            if((o2 = (o)b.get(s3)) == null)
                o2 = (o)c.get(s3);
            if(o2 == null)
            {
                this = s3;
                throw new y((new StringBuilder()).append("Unknown definition name (").append(this).append(")").toString());
            } else
            {
                d(o2.a());
                return o2.a();
            }
        }
        if(s1.startsWith("->"))
        {
            String s4 = s1.substring("->".length(), s1.length());
            if(d.get(s4) == null)
                throw y.b(s4);
            if(a.empty())
            {
                throw y.a();
            } else
            {
                Object obj = a.pop();
                d.put(s4, obj);
                return obj;
            }
        }
        if(s1.startsWith("@"))
        {
            String s5 = s1.substring("@".length(), s1.length());
            Object obj1;
            if((obj1 = d.get(s5)) == null)
            {
                throw y.b(s5);
            } else
            {
                a.push(obj1);
                return obj1;
            }
        }
        o o1;
        if((o1 = (o)c.get(s1)) != null)
            try
            {
                return o1.a(this);
            }
            catch(EmptyStackException _ex)
            {
                throw y.a();
            }
            catch(NoSuchElementException _ex)
            {
                throw y.a();
            }
        o o3;
        if((o3 = (o)b.get(s1)) != null)
            try
            {
                return o3.a(this);
            }
            catch(EmptyStackException _ex)
            {
                throw y.a();
            }
            catch(NoSuchElementException _ex)
            {
                throw y.a();
            }
        Matcher matcher;
        if((matcher = i.matcher(s1)).matches())
        {
            String s6 = s1.substring(1, s1.length() - 1);
            a.push(s6);
            return s6;
        }
        try
        {
            Integer integer = Integer.valueOf(Integer.parseInt(s1));
            a.push(integer);
            return integer;
        }
        catch(NumberFormatException _ex)
        {
            throw y.a(s1);
        }
    }

    public final void a()
    {
        a.clear();
        c.clear();
        d.clear();
    }

    public static Integer a(Object obj)
    {
        if(!(obj instanceof Integer))
            throw y.a(obj.toString());
        else
            return (Integer)obj;
    }

    public static String b(Object obj)
    {
        if(!(obj instanceof String))
        {
            obj = obj.toString();
            throw new y((new StringBuilder()).append("Data in stack must be string(").append(((String) (obj))).append(").").toString());
        } else
        {
            return (String)obj;
        }
    }

    public final o c(String s1)
    {
        o o1;
        if((o1 = (o)b.get(s1)) != null)
            return o1;
        else
            return (o)c.get(s1);
    }

    public final void d(String s1)
    {
        if(e != null)
            e.c(s1);
    }

    public final void a(u u1)
    {
        e = u1;
    }

    public final Stack b()
    {
        return a;
    }

    public final boolean c()
    {
        return f;
    }

    static Stack a(am am1)
    {
        return am1.a;
    }

    static HashMap b(am am1)
    {
        return am1.d;
    }

    static HashMap c(am am1)
    {
        return am1.b;
    }

    static HashMap d(am am1)
    {
        return am1.c;
    }

    static u e(am am1)
    {
        return am1.e;
    }
}

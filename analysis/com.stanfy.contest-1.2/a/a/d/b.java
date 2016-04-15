// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst noctor 

package com.stanfy.contest.a.a.d;

import java.util.Vector;

// Referenced classes of package com.stanfy.contest.a.a.d:
//            a

public final class b
{

    private int a[][];

    public b()
    {
        a = new int[8][8];
        a();
    }

    public final void a()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
                if(i % 2 == j % 2)
                {
                    if(i < 3)
                    {
                        a[i][j] = 3;
                        continue;
                    }
                    if(i > 4)
                        a[i][j] = 1;
                    else
                        a[i][j] = 0;
                } else
                {
                    a[i][j] = 0;
                }

        }

    }

    public final int a(int i, int j)
    {
        return a[i][j];
    }

    public final void a(int i, int j, int k, int l)
    {
        a[k][l] = a[i][j];
        a[i][j] = 0;
        if(i - k == 2 || i - k == -2)
        {
            i = (i + k) / 2;
            j = (j + l) / 2;
            a[i][j] = 0;
        }
        if(k == 0 && a[k][l] == 1)
            a[k][l] = 2;
        if(k == 7 && a[k][l] == 3)
            a[k][l] = 4;
    }

    public final a[] a(int i)
    {
        if(i != 1 && i != 3)
            return null;
        byte byte0 = ((byte)(i != 1 ? 4 : 2));
        Vector vector = new Vector();
        for(int j = 0; j < 8; j++)
        {
            for(int l = 0; l < 8; l++)
            {
                if(a[j][l] != i && a[j][l] != byte0)
                    continue;
                if(a(i, j, l, j + 1, l + 1, j + 2, l + 2))
                    vector.addElement(new a(j, l, j + 2, l + 2));
                if(a(i, j, l, j - 1, l + 1, j - 2, l + 2))
                    vector.addElement(new a(j, l, j - 2, l + 2));
                if(a(i, j, l, j + 1, l - 1, j + 2, l - 2))
                    vector.addElement(new a(j, l, j + 2, l - 2));
                if(a(i, j, l, j - 1, l - 1, j - 2, l - 2))
                    vector.addElement(new a(j, l, j - 2, l - 2));
            }

        }

        if(vector.size() == 0)
        {
            for(int k = 0; k < 8; k++)
            {
                for(int i1 = 0; i1 < 8; i1++)
                {
                    if(a[k][i1] != i && a[k][i1] != byte0)
                        continue;
                    if(a(i, k, i1, k + 1, i1 + 1))
                        vector.addElement(new a(k, i1, k + 1, i1 + 1));
                    if(a(i, k, i1, k - 1, i1 + 1))
                        vector.addElement(new a(k, i1, k - 1, i1 + 1));
                    if(a(i, k, i1, k + 1, i1 - 1))
                        vector.addElement(new a(k, i1, k + 1, i1 - 1));
                    if(a(i, k, i1, k - 1, i1 - 1))
                        vector.addElement(new a(k, i1, k - 1, i1 - 1));
                }

            }

        }
        if(vector.size() == 0)
            return null;
        a aa[] = new a[vector.size()];
        for(int j1 = 0; j1 < vector.size(); j1++)
            aa[j1] = (a)vector.elementAt(j1);

        return aa;
    }

    public final a[] a(int i, int j, int k)
    {
        if(i != 1 && i != 3)
            return null;
        byte byte0 = ((byte)(i != 1 ? 4 : 2));
        Vector vector = new Vector();
        if(a[j][k] == i || a[j][k] == byte0)
        {
            if(a(i, j, k, j + 1, k + 1, j + 2, k + 2))
                vector.addElement(new a(j, k, j + 2, k + 2));
            if(a(i, j, k, j - 1, k + 1, j - 2, k + 2))
                vector.addElement(new a(j, k, j - 2, k + 2));
            if(a(i, j, k, j + 1, k - 1, j + 2, k - 2))
                vector.addElement(new a(j, k, j + 2, k - 2));
            if(a(i, j, k, j - 1, k - 1, j - 2, k - 2))
                vector.addElement(new a(j, k, j - 2, k - 2));
        }
        if(vector.size() == 0)
            return null;
        this = new a[vector.size()];
        for(i = 0; i < vector.size(); i++)
            this[i] = (a)vector.elementAt(i);

        return this;
    }

    private boolean a(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        if(j1 < 0 || j1 >= 8 || k1 < 0 || k1 >= 8)
            return false;
        if(a[j1][k1] != 0)
            return false;
        if(i == 1)
        {
            if(a[j][k] == 1 && j1 > j)
                return false;
            return a[l][i1] == 3 || a[l][i1] == 4;
        }
        if(a[j][k] == 3 && j1 < j)
            return false;
        return a[l][i1] == 1 || a[l][i1] == 2;
    }

    private boolean a(int i, int j, int k, int l, int i1)
    {
        if(l < 0 || l >= 8 || i1 < 0 || i1 >= 8)
            return false;
        if(a[l][i1] != 0)
            return false;
        if(i == 1)
            return a[j][k] != 1 || l <= j;
        return a[j][k] != 3 || l >= j;
    }
}

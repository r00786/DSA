package com.example.programs.pathcompression;

/**
 *
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class EquationsCheck {
    public static void main(String[] args) {
        System.out.println(new EquationsCheck().equationsPossible(new String[]{"a==e","c==a", "a==e", "b!=a"}));
    }


    int uf[];

    public boolean equationsPossible(String[] equations) {
        uf = new int[26];
        for (int i = 0; i < 26; i++)
            uf[i] = i;

        for (String e : equations)
            if (e.charAt(1) == '=') {
                int p1 = find(e.charAt(0) - 'a');
                int p2 = find(e.charAt(3) - 'a');

                if (p1 != p2)
                    uf[p2] = p1;
            }

        for (String e : equations)
            if (e.charAt(1) == '!') {
                int p1 = find(e.charAt(0) - 'a');
                int p2 = find(e.charAt(3) - 'a');

                if (p1 == p2)
                    return false;
            }

        return true;
    }

    private int find(int x) {
        if (uf[x] == x) {
            return x;
        } else {
            uf[x] = find(uf[x]);
            return uf[x];
        }

    }
}

package org.example.yandex.sprint3;

import java.util.HashMap;

public class Combinations_B {


    public static String combination(int n, String[] s, String prefix) {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"d", "e", "f"};
        if (n < 0) {
            return prefix;
        }
        prefix += s[n];
        combination(n - 1, s2, prefix);
        return combination(n-1, s1, prefix);

    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        System.out.println(combination(2, ""));
    }

}

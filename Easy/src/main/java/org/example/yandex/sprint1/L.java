package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L {

    private static char getExcessiveLetter(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (sMap.containsKey(c)) {
                int current = sMap.get(c);
                sMap.put(c, ++current);
            } else {
                sMap.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (tMap.containsKey(c)) {
                int current = tMap.get(c);
                tMap.put(c, ++current);
            } else {
                tMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> e : tMap.entrySet()) {
            if (sMap.containsKey(e.getKey()) && sMap.get(e.getKey()) == e.getValue()) {
                continue;
            } else {
                return e.getKey();
            }
        }
        return '.';
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));
        }
    }
}
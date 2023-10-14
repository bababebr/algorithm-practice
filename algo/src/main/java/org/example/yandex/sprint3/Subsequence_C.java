package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequence_C {

    public static boolean isSub(String s, String t) {
        if (s.length() > t.length()) return false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            if (j >= s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            if (isSub(s, t)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

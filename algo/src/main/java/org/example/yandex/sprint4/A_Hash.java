package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class A_Hash {

    public static long hash(int a, int m, String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) {
            return ((long) s.codePointAt(0)) % m;
        }
        long hash = ((long) s.codePointAt(0) * a) + s.codePointAt(1);
        int n = s.length();

        for (int i = 2; i < n; i++) {
            hash = (hash * a) % m + (s.codePointAt(i) % m);
        }
        return hash % m;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

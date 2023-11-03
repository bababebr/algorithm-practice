package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void printSubHash(String s, List<String> indexes, int a, int m, int t) {
        if (s.isEmpty()) {
            for (int i = 0; i < t; i++) {
                System.out.println(0);
            }
            return;
        }

        long[] hashes = getSubHashes(s, a, m);

        long[] pows = new long[s.length() + 1];
        pows[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            pows[i] = (pows[i - 1] * a) % m;
        }
        for (String i : indexes) {
            List<Integer> index = Arrays.stream(i.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int idx1 = index.get(0) - 1;
            int ixd2 = index.get(1) - 1;
            long hash = ((hashes[ixd2]) - (hashes[idx1] * (pows[ixd2 - idx1 + 1]))) % m;
            System.out.println(hash);
            System.out.println("--------------------------------------------------------");
        }
    }

    public static long[] getSubHashes(String s, int a, int m) {
        long[] hashes = new long[s.length()];

        hashes[0] = (s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            long temp = hashes[i - 1] * a % m + s.charAt(i);
            hashes[i] = temp % m;
        }
        return hashes;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = readInt(reader);
            int m = readInt(reader);
            String s = reader.readLine();
            int t = readInt(reader);
            List<String> indexes = readIndexes(reader, t);
            printSubHash(s, indexes, a, m, t);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<String> readIndexes(BufferedReader reader, int t) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            result.add(reader.readLine());
        }
        return result;
    }
}
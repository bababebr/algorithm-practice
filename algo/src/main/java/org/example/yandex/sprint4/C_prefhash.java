package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_prefhash {

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
            int a = readInt(reader);
            int m = readInt(reader);
            String s = reader.readLine();
            int subStringCount = readInt(reader);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subStringCount; i++) {
                Integer[] arr = readArray(reader);
                sb.append(hash(a, m, s.substring(arr[0] - 1, (arr[1])))).append(System.lineSeparator());
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine()
                        .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}

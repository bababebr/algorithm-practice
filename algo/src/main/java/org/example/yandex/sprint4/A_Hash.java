package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A_Hash {

    public static long hash(int a, int m, String s) {
        long hash = 0;
        int n = s.length();
        long maxPow = pow(a, n-1);
        for (int i = 0; i < n - 1; i++) {
            hash += (long) s.codePointAt(i) * maxPow / (a*(i+1));
        }
        hash += (long) s.codePointAt(n - 1);
        return hash % m;
    }

    public static int pow(int a, int b) {
        if (b != 0) {
            // recursive call to power()
            return (a * pow(a, b - 1));
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = readInt(reader);
            int m = readInt(reader);
            String s = reader.readLine();
            System.out.println(hash(a, m, s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

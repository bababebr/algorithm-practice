package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class H {
    private static String sumOfBinaries(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA > lenB) {
            return sumBinary(a, b);
        } else {
            return sumBinary(b, a);
        }

    }

    private static String sumBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int j = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (j >= 0) {
                int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(j)));
                if (sum == 2) {
                    sb.append(0);
                    sb.append(1);
                } else {
                    sb.append(sum);
                }
            } else {
                sb.append(a.charAt(i));
            }
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        }
    }
}
package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class I {

    private static boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n % 4 != 0 || n == 0) return false;
        return isPowerOfFour(n/4);
    }

    public static int sqrt(int number) {
        int low = 0;
        int high = number;
        while (low <= high) {
            int mid = (low + high) / 2;
            int square = mid * mid;
            if (square == number) {
                return mid;
            } else if (square < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            if (isPowerOfFour(n)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
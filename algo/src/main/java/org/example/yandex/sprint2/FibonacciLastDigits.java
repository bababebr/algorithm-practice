package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciLastDigits {

    public static long fib(int n, int k) {
        long a = 1, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % powTen(k);
            a = b;
            b = c;
        }
        return b;
    }

    private static int powTen(int k) {
        int result = 10;
        for(int i = 1; i < k; i++) {
            result = result * 10;
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int[] input = readInt(reader);
            System.out.println(fib(input[0], input[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readInt(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        int[] result = {Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        return result;
    }

}

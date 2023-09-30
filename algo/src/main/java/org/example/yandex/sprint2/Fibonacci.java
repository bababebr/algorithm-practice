package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    public static int fib(int n) {
        if(n == 0 || n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(fib(readInt(reader)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}

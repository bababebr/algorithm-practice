package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E_House {

    public static void Houses(int balance, Integer[] houses) {
        int count = 0;
        for(int house : houses) {
            if(balance >= house) {
                balance = balance-house;
                count++;
            } else break;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Integer[] first = readArrayFirst(reader);
            Integer[] houses = readArray(reader);
            Houses(first[1], houses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(e -> Integer.parseInt(e)).sorted().toArray(Integer[]::new);
    }

    public static Integer[] readArrayFirst(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(e -> Integer.parseInt(e)).toArray(Integer[]::new);
    }

}

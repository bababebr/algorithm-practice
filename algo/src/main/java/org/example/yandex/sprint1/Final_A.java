package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Final_A {

    public static String zero(Integer[] arr) {
        int dist = 2147483647;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                dist = 0;
                arr[i] = dist;
            } else if (dist == 2147483647) {
                arr[i] = dist;
            } else {
                arr[i] = (++dist);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                dist = 0;
            } else if (arr[i] == 2147483647 || arr[i] > dist) {
                arr[i] = ++dist;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] arr = readList(reader);
            String result = zero(arr);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readList(BufferedReader reader) throws IOException {

        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem)).toArray(Integer[]::new);
    }
}
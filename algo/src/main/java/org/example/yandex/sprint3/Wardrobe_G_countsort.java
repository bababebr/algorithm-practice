package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wardrobe_G_countsort {

    public static void countSort(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] result = {0, 0, 0};
        for (int val : arr) {
            result[val]++;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i]; j++) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            if (n == 0) return;
                countSort(readArray(reader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(e -> Integer.parseInt(e)).toArray(Integer[]::new);
    }
}

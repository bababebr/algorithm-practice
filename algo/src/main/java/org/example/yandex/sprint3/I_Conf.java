package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I_Conf {

    public static void countSort(Integer[] arr, int k) {
        StringBuilder sb = new StringBuilder();
        int[] result = new int[arr.length];
        int max = 0;
        for (int val : arr) {
            result[val]++;
            if (result[val] > max) {
                max = result[val];
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max && k > 0) {
                sb.append(i).append(" ");
                k--;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] arr = readArray(reader);
            int k = readInt(reader);
            countSort(arr, k);

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

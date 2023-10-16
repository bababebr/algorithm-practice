package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class F_Triangle {

    public static void triangle(Integer[] sides) {
        int left = 0;
        int right = 2;
        int max = 0;
        while (right < sides.length) {
            if (sides[right] + sides[right - 1] > sides[left]) {
                max = sides[right] + sides[right - 1] + sides[left];
                break;
            }
            left++;
            right++;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] arr = readArray(reader);
            triangle(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(e -> Integer.parseInt(e)).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
    }
}

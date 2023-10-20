package org.example.yandex.sprint3;

import org.example.yandex.sprint1.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort_J {
    public static Integer[] bubbleSort_opt(Integer[] array) {
        int sortCount = 0;
        StringBuilder sb = new StringBuilder();
        int max = array.length - 1;
        boolean check;
        for (int i = 0; i < array.length; i++) {
            check = false;
            for (int j = 0; j < max; j++) {
                if (array[j] > array[j + 1]) {
                    sortCount++;
                    check = true;
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            if (sortCount == 0) {
                sb.append(toString(array)).append(System.lineSeparator());
                System.out.println(sb);
                return array;
            }
            if (!check) {
                System.out.println(sb);
                return array;
            } else if (sortCount != 0) {
                sb.append(toString(array)).append(System.lineSeparator());
            }
            max--;
        }
        return array;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            bubbleSort_opt(readArray(reader));
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


    public static int[] generateArray(int n) {
        Random rnd = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rnd.nextInt(n);
        }
        return result;
    }

    public static String toString(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}

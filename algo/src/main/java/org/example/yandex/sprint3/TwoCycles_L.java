package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoCycles_L {
    public static Integer binarySearch(Integer[] array, int n, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        int mid = (left + right) / 2;
        if (mid == 0 && array[mid] >= n) {
            return mid + 1;
        }
        if (array[mid] >= n && array[mid - 1] < n) {
            return mid + 1;
        } else if (n > array[mid]) {
            return binarySearch(array, n, mid + 1, right);
        } else {
            return binarySearch(array, n, left, mid);
        }
    }

    public static Integer[] twoCycles(Integer[] array, int cost) {
        Integer[] result = new Integer[2];
        result[0] = binarySearch(array, cost, 0, array.length);
        result[1] = binarySearch(array, cost * 2, result[0] - 1, array.length);
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] array = readArray(reader);
            int cost = readInt(reader);
            Integer[] result = twoCycles(array, cost);
            StringBuilder sb = new StringBuilder();
            sb.append(result[0] + " " + result[1]);
            System.out.println(sb);
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

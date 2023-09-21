package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static Integer[][] solution(int n, int m, Integer[][] matrix) {
        System.out.println(Arrays.toString(matrix));
        return null;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int m = readInt(reader);
            Integer[][] matrix = readMatrix(n, m, reader);

            solution(n, m, matrix);
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

    public static Integer[][] readMatrix(int n, int m, BufferedReader reader) throws IOException {
        Integer[][] matrix = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            matrix[n] = readArray(reader);
        }
        return matrix;
    }

}

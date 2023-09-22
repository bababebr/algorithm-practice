package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static String solution(int n, int m, Integer[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int[][] transposedMatrix = new int[m][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(transposedMatrix[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int m = readInt(reader);
            Integer[][] matrix = readMatrix(n, m, reader);
            System.out.println(solution(n, m, matrix));
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

            matrix[i] = readArray(reader);
        }
        return matrix;
    }

}

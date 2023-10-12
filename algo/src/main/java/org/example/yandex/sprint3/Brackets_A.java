package org.example.yandex.sprint3;

import org.example.yandex.sprint2.A;
import org.example.yandex.sprint2.Deq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Brackets_A {

    public static void generate(int maxLength, int left, int right,
                                ArrayList<String> result, StringBuilder sb) {
        if (left + right == maxLength) {
            if (left == right){
                result.add(sb.toString());
                System.out.println(sb);
            }
        } else if (left >= right) {
            generate(maxLength, left + 1, right, result, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);

            generate(maxLength, left, right + 1, result, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);

        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            ArrayList<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            generate(n*2, 0, 0, list, sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

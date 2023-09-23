package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Final_B {

    public static int maxScore(int k, ArrayList<String> field) {
        int score = 0;
        int[] counter = new int[10];
        for (int i = 0; i < 4; i++) {
            for (char c : field.get(i).toCharArray()) {
                if (c == '.') {
                    continue;
                }
                int num = Character.digit(c, 10);
                ++counter[num];
            }
        }

        for (int i = 0; i < 10; i++) {
            if (counter[i] <= k * 2 && counter[i] > 0) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = readInt(reader);
            ArrayList<String> field = readArray(reader);
            System.out.println(maxScore(k, field));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<String> readArray(BufferedReader reader) throws IOException {
        ArrayList<String> field = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            field.add(reader.readLine());
        }
        return field;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}

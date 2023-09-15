package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class E {

    private static String getLongestWord(String text) {
        int prefIdx = 0;
        int suffIdx = 0;
        String longestWord = "";
        String temp = "";
        text = text.trim();
        while (suffIdx != -1) {
            suffIdx = text.indexOf(" ", prefIdx);
            if (suffIdx == -1) {
                temp = text.substring(prefIdx);
            } else {
                temp = (text.substring(prefIdx, suffIdx));
            }
            if (temp.length() >= longestWord.length()) {
                longestWord = temp;
            }
            prefIdx = suffIdx + 1;
        }
        return longestWord;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int textLength = readInt(reader);
            String text = reader.readLine();
            String longestWord = getLongestWord(text);
            System.out.println(longestWord);
            System.out.println(longestWord.length());
        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}


package org.example.yandex.sprint1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F {

    private static boolean isPalindrome(String text) {
        String newText = text.replaceAll("[^\\w^\\d]|_", "").toLowerCase();
        int i = 0;
        int j = newText.length() - 1;
        System.out.println(newText);
        while (i < j) {
            if (newText.charAt(i++) != newText.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
package org.example.leet75.arraysString;

import java.util.Arrays;

public class CompressedString {

    public static int compress(char[] chars) {
        StringBuilder compressedString = new StringBuilder();
        int count = 0;
        char presentChar = chars[0];
        for (char c : chars) {
            if (c == presentChar) {
                count++;
            } else {
                if (count == 1) {
                    compressedString.append(presentChar);
                } else {
                    compressedString.append(presentChar).append(count);
                }
                presentChar = c;
                count = 1;
            }
        }
        if (count == 1) {
            compressedString.append(presentChar);
        } else {
            compressedString.append(presentChar).append(count);
        }

        compressedString.getChars(0, compressedString.length(), chars, 0);
        System.out.println(chars);
        return chars.length;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'c', 'b', 'b', 'b', 'b', 'b'};
        compress(chars);
    }
}

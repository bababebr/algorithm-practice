package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Combinations_B {

    public static Map<Character, String[]> buttons = Map.of(
            '2', new String[]{"a", "b", "c"},
            '3', new String[]{"d", "e", "f"},
            '4', new String[]{"g", "h", "i"},
            '5', new String[]{"j", "k", "l"},
            '6', new String[]{"m", "n", "o"},
            '7', new String[]{"p", "q", "r", "s"},
            '8', new String[]{"t", "u", "v"},
            '9', new String[]{"w", "x", "y", "z"});


    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inpStr = bufferedReader.readLine();
        genSequence(inpStr, 0, "");
        System.out.println(stringBuilder);
    }

    public static void genSequence(String segments, int letterIndex, String result) {
        if (letterIndex == segments.length()) {
            stringBuilder.append(result).append(" ");
        } else {
            String[] split = buttons.get(segments.charAt(letterIndex));
            for (int i = 0; i < split.length; i++) {
                genSequence(segments, letterIndex + 1, result + split[i]);
            }
        }
    }
}
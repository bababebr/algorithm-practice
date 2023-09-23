package org.example.leet75.arraysString;

import java.util.*;

public class ReverseVowel {

    public static String reverseVowels(String s) {
        /**TODO
         * Slow, increase.
         */
        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                characterStack.add(s.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                sb.append(s.charAt(i));
            } else {
                sb.append(characterStack.pop());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("qearro"));
    }
}

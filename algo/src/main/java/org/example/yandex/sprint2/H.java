package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class H {

    public static boolean is_correct_bracket_seq(String seq) {
        if (seq.isEmpty()) return true;
        if (seq.length() % 2 != 0) return false;
        ArrayList<Character> stack = new ArrayList<>();
        for (char c : seq.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if (stack.get(stack.size() - 1) == '[' && c == ']') {
                stack.remove(stack.size() - 1);
                continue;
            }
            if (stack.get(stack.size() - 1) == '(' && c == ')') {
                stack.remove(stack.size() - 1);
                continue;
            }
            if (stack.get(stack.size() - 1) == '{' && c == '}') {
                stack.remove(stack.size() - 1);
                continue;
            }
            stack.add(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (is_correct_bracket_seq(reader.readLine())) {
                System.out.println("True");
            } else System.out.println("False");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

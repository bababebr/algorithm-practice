package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class EffectiveStack {

    /**
     * Spring 2 - G
     */
    private ArrayList<Integer> stack;
    private ArrayList<Integer> maxArray;

    public EffectiveStack() {
        this.stack = new ArrayList<>();
        this.maxArray = new ArrayList<>();
        this.maxArray.add(Integer.MIN_VALUE);
    }

    public void push(int x) {
        stack.add(x);
        if (maxArray.get(stack.size() - 1) < x) {
            maxArray.add(x);
        } else {
            maxArray.add(maxArray.get(maxArray.size() - 1));
        }
    }

    public int pop() {
        maxArray.remove(maxArray.size() - 1);
        int remove = stack.remove(stack.size() - 1);
        return remove;
    }

    public int get_max() {
        return maxArray.get(maxArray.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}


public class EffectiveStackMain {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            EffectiveStack stack = new EffectiveStack();
            int n = readInt(reader);
            for (int i = 0; i < n; i++) {
                readCommand(reader, stack);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void readCommand(BufferedReader reader, EffectiveStack stack) throws IOException {
        String command = reader.readLine();
        if (command.equals("get_max")) {
            if (stack.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(stack.get_max());
            }
        }
        if (command.equals("pop")) {
            if (stack.isEmpty()) {
                System.out.println("error");
            } else {
                stack.pop();
            }
        }
        if (command.startsWith("push")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            stack.push(number);
        }
    }
}

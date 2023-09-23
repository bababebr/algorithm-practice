package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Stack {

    ArrayList<Integer> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(stack.size() - 1);
    }

    public int get_max() {
        int maxNumberInStack = stack.get(0);
        for (Integer i : stack) {
            if (i > maxNumberInStack) maxNumberInStack = i;
        }
        return maxNumberInStack;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class StackMax {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Stack stack = new Stack();
            int n = readInt(reader);
            for(int i = 0; i < n; i++) {
                readCommand(reader, stack);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void readCommand(BufferedReader reader, Stack stack) throws IOException {
        String command = reader.readLine();
        if(command.equals("get_max")) {
            if(stack.isEmpty()){
                System.out.println("None");
            } else {
                System.out.println(stack.get_max());
            }
        }

        if(command.equals("pop")) {
            if(stack.isEmpty()) {
                System.out.println("error");
            } else {
                stack.pop();
            }
        }

        if(command.startsWith("push")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            stack.push(number);
        }
    }
}

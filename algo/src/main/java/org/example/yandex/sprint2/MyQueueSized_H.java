package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

class MyQueueSized {

    ArrayList<Integer> queue;
    int maxSize;

    public MyQueueSized(int size) {
        this.queue = new ArrayList<>();
        this.maxSize = size;
    }

    public boolean push(int i) {
        if (queue.size() < maxSize) {
            queue.add(i);
            return true;
        } else {
            return false;
        }
    }

    public Integer pop() {
        if (queue.isEmpty()) return null;
        else return queue.remove(0);
    }

    public String peek() {
        if (queue.isEmpty()) return "None";
        else return String.valueOf(queue.get(0));
    }

    public int size() {
        return queue.size();
    }

}

public class MyQueueSized_H {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = readInt(reader);
            int size = readInt(reader);
            MyQueueSized queue = new MyQueueSized(size);
            for (int i = 0; i < n; i++) {
                readCommand(reader, queue);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void readCommand(BufferedReader reader, MyQueueSized queue) throws IOException {
        String command = reader.readLine();
        if (command.equals("peek")) {
            System.out.println(queue.peek());
        }
        if (command.equals("pop")) {
            Optional<Integer> result = Optional.ofNullable(queue.pop());
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get());
            }
        }
        if (command.startsWith("push")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            if (!queue.push(number)) {
                System.out.println("error");
            }
        }
        if(command.startsWith("size")) {
            System.out.println(queue.size());
        }
    }
}

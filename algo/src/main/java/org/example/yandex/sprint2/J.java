package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

class NodeJ<V> {
    public V value;
    public NodeJ<V> next;

    public NodeJ(V value, NodeJ<V> next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedQueue {

    private NodeJ<Integer> head = null;
    private NodeJ<Integer> lastNode = null;
    int size = 0;
    public LinkedQueue() {
    }

    public Optional<Integer> get() {
        if (head == null) {
            return null;
        } else {
            int value = head.value;
            head = head.next;
            size--;
            return Optional.of(value);
        }
    }

    public void put(int x) {
        if(head == null) {
            head = new NodeJ<>(x, null);
            lastNode = head;
        } else {
            lastNode.next = new NodeJ<>(x, null);
            lastNode = lastNode.next;
        }
        size++;
    }

    public int size() {
        return size;
    }
}

public class J {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = readInt(reader);
            LinkedQueue queue = new LinkedQueue();
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

    public static void readCommand(BufferedReader reader, LinkedQueue queue) throws IOException {
        String command = reader.readLine();

        if (command.equals("get")) {
            Optional<Integer> result = queue.get();
            if (result == null) {
                System.out.println("error");
            } else {
                System.out.println(result.get());
            }
        }
        if (command.startsWith("push")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            queue.put(number);
        }
        if(command.startsWith("size")) {
            System.out.println(queue.size());
        }
    }

}

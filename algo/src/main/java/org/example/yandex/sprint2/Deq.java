package org.example.yandex.sprint2;

import java.io.*;

/*
-- ПРИНЦИП РАБОТЫ --
Посылка - 92222484
За основу взял Дек из теории, который был релизован за зацикленном буфере.
Операции push_front крутят указатель head против часовой стреки, pop_front - по часовой.
push_back двигают tail по часовой, pop_back - против.


-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Указатель head всегда указывает самую первую не пустую ячейку, поэтому при добавлении эл-та вперед (push_front) сначала
вычисляется индекс следующией ячейки, а уже потом в нее записывается значение.

Указатель tail в свою очередь, наоборот, указывает на следующую пустую ячейку, поэтому при добавлении значения сначала
записываем в ячейку с индексом tail значение, а уже потом вычисляем следующий индекс.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --

Эти имплементация Дека фиксированного размера, это позволяет выполнять все операции за O(1)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Так как мы сразу знаем размер дека, то памяти выделяется O(n)
Так же память занимают переменные max_n, head, tail, size, но этим можно принебречь.
В так случае сложность равно O(n).
*/


public class Deq {

    private Integer[] queue;
    private int max_n;
    private int head;
    private int tail;
    private int size;

    public Deq(int n) {
        queue = new Integer[n];
        max_n = n;
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push_back(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
            return true;
        }
        return false;
    }

    public boolean push_front(int x) {
        if (size != max_n) {
            head = (head + max_n - 1) % max_n;
            queue[head] = x;
            size++;
            return true;
        }
        return false;
    }

    public Integer pop_front() {
        if (isEmpty()) {
            return null;
        }
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        return x;
    }

    public Integer pop_back() {
        if (isEmpty()) {
            return null;
        }
        tail = (tail + max_n - 1) % max_n;
        Integer x = queue[tail];
        queue[tail] = null;
        size--;
        return x;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int m = readInt(reader);
            Deq deq = new Deq(m);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                readCommand(reader, deq, sb);
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void readCommand(BufferedReader reader, Deq deq, StringBuilder sb) throws IOException {
        String command = reader.readLine();

        if (command.equals("pop_back")) {
            Integer result = deq.pop_back();
            if (result == null) {
                sb.append("error").append(System.lineSeparator());
            } else {
                sb.append(result).append(System.lineSeparator());
            }
        }

        if (command.equals("pop_front")) {
            Integer result = deq.pop_front();
            if (result == null) {
                sb.append("error").append(System.lineSeparator());
            } else {
                sb.append(result).append(System.lineSeparator());
            }
        }

        if (command.startsWith("push_back")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            if (!deq.push_back(number)) {
                sb.append("error").append(System.lineSeparator());
            }
        }

        if (command.startsWith("push_front")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            if (!deq.push_front(number)) {
                sb.append("error").append(System.lineSeparator());
            }
        }
    }
}

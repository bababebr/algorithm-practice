package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Взял за основу дек из теории, не знаю, правильно ли реализовал изменение указателя при pop_back и push_front.
При этих операция, счетчик идет в обратную сторону и тоже должен быть зациклен. Решил реализовать через тернарник,
но не уверен, что это правильное решение.

И были проблемы с TL на тестах, пришлось делать вывод через добавление StringBuilder в класс Deq. Так и читается лучше,
и вывести ответ просто.
 */

public class Deq {

    private Integer[] queue;
    private int max_n;
    private int head;
    private int tail;
    private int size;

    private StringBuilder log;

    public Deq(int n) {
        queue = new Integer[n];
        max_n = n;
        head = 0;
        tail = 0;
        size = 0;
        log = new StringBuilder();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push_back(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        } else {
            log.append("error").append(System.lineSeparator());
        }
    }

    public void push_front(int x) {
        if (size != max_n) {
            head = (head - 1) % max_n < 0 ? max_n + ((head - 1) % max_n) : (head - 1) % max_n;
            queue[head] = x;
            size++;
        } else {
            log.append("error").append(System.lineSeparator());
        }
    }

    public Integer pop_front() {
        if (isEmpty()) {
            log.append("error").append(System.lineSeparator());
            return null;
        }
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        log.append(x).append(System.lineSeparator());
        return x;
    }

    public Integer pop_back() {
        if (isEmpty()) {
            log.append("error").append(System.lineSeparator());
            return null;
        }
        tail = (tail - 1) % max_n < 0 ? max_n + ((tail - 1) % max_n) : (tail - 1) % max_n;
        Integer x = queue[tail];
        queue[tail] = null;
        size--;
        log.append(x).append(System.lineSeparator());
        return x;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int m = readInt(reader);
            Deq deq = new Deq(m);
            for (int i = 0; i < n; i++) {
                readCommand(reader, deq);
            }
            System.out.println(deq.log.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void readCommand(BufferedReader reader, Deq deq) throws IOException {
        String command = reader.readLine();

        if (command.equals("pop_back")) {
            deq.pop_back();
        }

        if (command.equals("pop_front")) {
            deq.pop_front();
        }

        if (command.startsWith("push_back")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            deq.push_back(number);
        }

        if (command.startsWith("push_front")) {
            int number = Integer.parseInt(command.split(" ")[1]);
            deq.push_front(number);
        }
    }

}

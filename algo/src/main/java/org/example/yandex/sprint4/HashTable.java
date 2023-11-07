package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class HashTable {
    /*
    -- ПРИНЦИП РАБОТЫ --
    Посылка - 96236429

    Класс хэш-мапы - Map состоит из константы размера корзин BUCKET_SIZE, массива Нод "table".
    Класс Ноды - Node<V,K> содержит V - value, K - key, next - след. нода.

    При инициализании Хэш-таблицы создается массив table и запоняется null-ми.
    Когда мы добавляем эл-т, внутри мапы вызывается метод bucket(hash(key)), где hash() -> метод получениях хэша.

    При возникновении коллизий они устраняются методом цепочек.

    Размер мапы выбран в размере 133337 т.к. по условию задачи в мапе не может быть более 10^5 эл-тов. Ближайшее простое
    к 10^5 - это 100003, делим его на коэффициент масштабирования 0.75 и получаем 133337.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

    Алгоритм хэширования является детерминированным т.к. состоит только и суммирования и побитовых операторов.
    Это гарантирует, что для одного и того же ключа будет выдаваться одинаковый хэш.

    Метод цепочек позволяет избежать коллизий т.к. эл-ты с одинаковым хэшем будут храниться в виде связанного списка.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --

    Считать команды -> O(n)
    Создать мапу фиксированного размера - O(1)
    Положить и достать эл-т в лучшем и среднем случаее O(1), худший случай возможен при неравномерном распределении хеша,
    в таком случае все эл-ты будут попадать в одну корзину. Тогда необходимо будет постоянно проходиться по списку, и
    удаление, добавление и поиск будет занимать O(n) времени.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
        Размер мапы выбран 1.25 * m, где m - максммальное кол-во эл-тов в мапе. Отсюда сложность в лучшем случаее O(m)
     */

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map map = new Map();
            int n = readInt(reader);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String[] command = reader.readLine().split(" ");
                long result = 0;
                switch (command[0]) {
                    case "put":
                        map.put(Integer.parseInt(command[1]), Long.parseLong(command[2]));
                        break;
                    case "delete":
                        result = map.delete(Integer.parseInt(command[1]));
                        if (result != -1) {
                            sb.append(result).append(System.lineSeparator());
                            break;
                        }
                        sb.append("None").append(System.lineSeparator());
                        break;
                    case "get":
                        result = map.get(Integer.parseInt(command[1]));
                        if (result != -1) {
                            sb.append(result).append(System.lineSeparator());
                            break;
                        }
                        sb.append("None").append(System.lineSeparator());
                        break;
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    static class Map {
        private final static int BUCKET_SIZE = 133337;
        private final Node<Integer, Long>[] table = new Node[BUCKET_SIZE];


        public void put(Integer key, Long value) {
            Node<Integer, Long> newNode = new Node<>(key, value);
            int bucket = bucket(key);
            if (table[bucket] != null) {
                Node<Integer, Long> node = table[bucket];
                if (Objects.equals(node.key, key)) {
                    node.value = value;
                    return;
                }
                while (node.hasNext()) {
                    if (Objects.equals(node.key, key)) {
                        node.value = value;
                        return;
                    }
                    node = node.next;
                }
                if (Objects.equals(node.key, key)) {
                    node.value = value;
                } else {
                    node.next = newNode;
                }
                return;
            }
            table[bucket] = newNode;
        }

        public long get(int key) {
            Node<Integer, Long> node = table[bucket(key)];
            if (node == null) return -1;
            if (node.key == key) {
                return node.value;
            }
            while (node != null) {
                if (node.key == key) return node.value;
                node = node.next;
            }
            return -1;
        }

        public long delete(Integer key) {
            int bucket = bucket(key);
            Node<Integer, Long> node = table[bucket];
            Node<Integer, Long> prev = null;
            if (node == null) return -1;

            if (Objects.equals(node.key, key)) {
                table[bucket] = node.next;
                return node.value;
            }

            while (node != null && !Objects.equals(node.key, key)) {
                prev = node;
                node = node.next;
            }

            if (node == null)
                return -1;

            prev.next = node.next;
            return node.value;
        }

        //Получение номера корзины из хэша с помощью получения остатка от деления на размер мапы.
        private int bucket(Integer key) {
            return (int) (hash(key) % BUCKET_SIZE);
        }

        //Алгоритм получения хэша по ключу, взят из офф документации по Java 7
        private long hash(Integer key) {
            key = key + 1_000_000_000; // чтобы исключить отрицательные индексы.
            key ^= (key >>> 20) ^ (key >>> 12);
            return key ^ (key >>> 7) ^ (key >>> 4);
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public boolean hasNext() {
            return next != null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

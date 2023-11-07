package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class HashTable {

    public static void main(String[] args) {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        //BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\unior1234\\IdeaProjects\\algorithm-practice\\algo\\src\\main\\resources\\input_18.txt")))
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map map = new Map();
            int n = readInt(reader);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String[] command = reader.readLine().split(" ");
                long result = 0;
                //System.out.println(command[0] + " " + command[1]);
                switch (command[0]) {
                    case "put":
                        map.put(Integer.parseInt(command[1]), Long.parseLong(command[2]));
                       /* map.printBucket(Integer.valueOf(command[1]));
                        System.out.println("---------------");
                       */ break;
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
        private final static int BUCKET_SIZE = 61633337;
        private final Node<Integer, Long>[] table = new Node[BUCKET_SIZE];
        public long size = 0;

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
                    return;
                } else {
                    node.next = newNode;
                    return;
                }
/*                while (node.hasNext()) {
                    if (Objects.equals(node.key, key)) {
                        node.value = value;
                        break;
                    }
                    node = node.next;
                }

                node.next = newNode;*/
            }
            size++;
            table[bucket] = newNode;
        }

        public void printBucket(Integer key) {
            Node<Integer, Long> node = table[bucket(key)];
            while (node != null) {
                System.out.println(node.key + " " + node.value);
                node = node.next;
            }
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
                size--;
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
            size--;
            return node.value;
        }

        private int bucket(Integer key) {
            return (int) (hash(key) % BUCKET_SIZE);
            //return 1;
        }

        private long hash(Integer key) {
            key = key + 1_000_000_000;
            key ^= (key >>> 20) ^ (key >>> 12);
            return key ^ (key >>> 7) ^ (key >>> 4);
        }
    }

    static class Node<K, V> {
        int hash;
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

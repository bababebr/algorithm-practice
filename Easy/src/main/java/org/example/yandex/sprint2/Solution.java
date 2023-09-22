package org.example.yandex.sprint2;

// <template>
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        int i = 0;
        Node<String> newHead = head;
        Node<String> prev = null;
        if (idx == 0) {
            newHead = head.next;
            return newHead;
        }
        while (head.next != null) {
            if (i == idx - 1) {
                prev = head;
            }
            if (i == idx + 1) {
                prev.next = head;
            }
            head = head.next;
            i++;

        }
        return head;
    }
    public static void print(Node<String> head) {
        while (head.next != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void test() {


        // result is : node0 -> node2 -> node3
    }

    public static void main(String[] args) {
        Node<String> node2 = new Node<>("node2", null);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 0);
        print(newHead);
    }

}
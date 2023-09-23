package org.example.yandex.sprint2;

class NodeD<V> {
    public V value;
    public NodeD<V> next;

    public NodeD(V value, NodeD<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class D {
    public static int solution(NodeD<String> head, String elem) {
        int idx = 0;
        while (head.next != null) {
            if(head.value.equals(elem) ) return idx;
            head = head.next;
            idx++;
        }
        return -1;
    }

    private static void test() {
        NodeD<String> node3 = new NodeD<>("node3", null);
        NodeD<String> node2 = new NodeD<>("node2", node3);
        NodeD<String> node1 = new NodeD<>("node1", node2);
        NodeD<String> node0 = new NodeD<>("node0", node1);
        int idx = solution(node0, "node2");
        assert idx == 2;
    }
}
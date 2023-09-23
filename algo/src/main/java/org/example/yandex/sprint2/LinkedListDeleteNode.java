package org.example.yandex.sprint2;

class NodeC<V> {
    public V value;
    public NodeC<V> next;

    public NodeC(V value, NodeC<V> next) {
        this.value = value;
        this.next = next;
    }
}


public class LinkedListDeleteNode {
    public static NodeC<String> solution(NodeC<String> head, int idx) {
        NodeC<String> newNode = new NodeC<>("", null);
        NodeC<String> prev;
        if (idx == 0) {
            newNode = head.next;
            return newNode;
        }
        prev = getNodeByIndex(head, idx - 1);
        prev.next = prev.next.next;
        return head;
    }

    public static NodeC getNodeByIndex(NodeC node, int index) {
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    private static void test() {
        NodeC<String> node3 = new NodeC<>("node3", null);
        NodeC<String> node2 = new NodeC<>("node2", node3);
        NodeC<String> node1 = new NodeC<>("node1", node2);
        NodeC<String> node0 = new NodeC<>("node0", node1);
        NodeC<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}








package org.example.leet75;


// Definition for singly-linked list.


import java.util.ArrayList;

public class DoubleNumberRepresentedLinkedList {

    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode presNode = head;

        do {
            sb.append(presNode.val);
            presNode = presNode.next;
        } while (presNode.next != null);
        sb.append(presNode.val);

        int doubled = Integer.parseInt(sb.toString()) * 2;
        String doubledString = String.valueOf(doubled);

        for(int i = 0; i < doubledString.length(); i++) {
            ListNode nextNode = new ListNode();
            ListNode presentNode = new ListNode(Character.getNumericValue(doubledString.charAt(i)), nextNode);

        }
        while
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

package com.liuguangqiang.structure.linkedlist;

public class LinkedList {

    public ListNode head;

    public ListNode last = null;

    private LinkedList() {
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void add(ListNode node) {
        if (last == null) {
            head.next = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public void print() {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

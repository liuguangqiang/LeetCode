package com.liuguangqiang.leetcode;

import com.liuguangqiang.structure.linkedlist.LinkedList;
import com.liuguangqiang.structure.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Created by Eric at 2021/3/19 4:16 下午
 */
public class ReverseLinkedList {

    /**
     * 使用递归
     * <p>
     * 假设整个链表只有两个节点head和next， 如果要反转链表， 只需要把链表中的两个节点换一个位置就可以了;
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedList linkedList = new LinkedList(head);
        linkedList.add(new ListNode(5));
        linkedList.add(new ListNode(4));
        linkedList.add(new ListNode(3));
        linkedList.add(new ListNode(2));
        linkedList.add(new ListNode(10));
        linkedList.head = reverseList(head);
        linkedList.print();
    }
}

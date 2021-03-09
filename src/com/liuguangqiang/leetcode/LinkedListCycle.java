package com.liuguangqiang.leetcode;

import com.liuguangqiang.structure.linkedlist.LinkedList;
import com.liuguangqiang.structure.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedList linkedList = new LinkedList(head);
        linkedList.add(new ListNode(5));
        linkedList.add(new ListNode(4));
        linkedList.add(new ListNode(3));
        linkedList.add(new ListNode(2));
        linkedList.add(new ListNode(10));
        linkedList.last.next = head;
        System.out.println("hasCycle:" + new LinkedListCycle().hasCycle(head));
    }
}

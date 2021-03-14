package com.liuguangqiang.leetcode;

import com.liuguangqiang.structure.linkedlist.LinkedList;
import com.liuguangqiang.structure.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * 双指针方法
     * <p>
     * 同时遍历该链表，一个走1步，一个走2步，如果最后2个指针相同，则表明该链表有环，否则很快就可以遍历完；
     *
     * @param head
     * @return
     */
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

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
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

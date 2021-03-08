package com.liuguangqiang.leetcode;

import java.util.PriorityQueue;

/**
 * 给一个流式数据，实时判断进入的第K大的数据；
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * <p>
 * 用java自带的优先队列实现，java默认的优先队列是一个小顶堆数据结构；
 * <p>
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * Created by eric on 29/1/2019.
 */
public class KthLargest {

    /**
     * Java的优先队列默认为小顶堆， 堆中最小的值永远在堆的顶部， 所以只需要维护一个容量为K的优先队列， 那么堆顶就是第K大的值；
     */
    final PriorityQueue<Integer> queue;

    final int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    /**
     * 添加新的数字时， 如果优先队列的容量小于K，直接放入队列即可；
     * 如果队列已经满了， 新的数字只需和堆顶的最小元素进行比较；
     * 如果小于堆顶， 那么就忽略这个新的数字；
     * 如果大于堆顶，则需要删除堆顶的数据， 然后插入新的数字，那么堆顶新的数字就是第K大的数字了；
     * <p>
     * 优先队列调整的时间复杂度是，log2k
     *
     * @param val
     * @return
     */
    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

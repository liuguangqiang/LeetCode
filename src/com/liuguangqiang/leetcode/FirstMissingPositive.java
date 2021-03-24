package com.liuguangqiang.leetcode;

import java.util.HashSet;

/**
 * 寻找数组中缺少的第一个正整数；
 * 0不是正整数；
 * <p>
 * https://leetcode.com/problems/first-missing-positive/description/
 * <p>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * Created by Eric at 2021/3/24 10:52 下午
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (i > 0) {
                hashSet.add(i);
            }
        }

        int t = 1;
        while (true) {
            if (!hashSet.contains(t)) {
                return t;
            }
            t++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }
}

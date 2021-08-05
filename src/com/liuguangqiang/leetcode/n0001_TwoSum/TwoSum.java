package com.liuguangqiang.leetcode.n0001_TwoSum;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * <p>
 * Created by Eric at 2021/3/26 11:17 下午
 */
public class TwoSum {

    /**
     * 这个问题就是x+y=target，反过来可以理解为，x = target-y，所以只用证明target-y在数组中就可以了,
     * 因为只遍历了一遍，所以时间复杂度O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (hashMap.containsKey(x)) {
                //如果hashMap中能找到x，则返回x对于index和i；
                return new int[]{hashMap.get(x), i};
            }
            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        int[] result = new TwoSum().twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

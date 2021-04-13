package com.liuguangqiang.leetcode;

import java.util.HashMap;

/**
 * 从数组中寻找出现次数超过一半的数字;
 * 假设这个数组不为空, 且数组中始终有众数;
 * <p>
 * https://leetcode.com/problems/majority-element/
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * Created by Eric at 2021/4/14 12:02 上午
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int count = hashMap.get(nums[0]);
        int k = nums[0];
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) > count) {
                count = hashMap.get(key);
                k = key;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 3};
//        int[] input = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(input));
    }
}

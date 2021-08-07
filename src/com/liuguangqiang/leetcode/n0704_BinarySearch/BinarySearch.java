package com.liuguangqiang.leetcode.n0704_BinarySearch;

/**
 * https://leetcode.com/problems/binary-search/
 * <p>
 * Given a sorted (in ascending order) integer array
 * nums of n elements and a target value, write a function to search target in nums. If target
 * exists, then return its index, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in nums and its index
 * is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not exist in nums so
 * return -1
 * Created by Eric at 2021/3/15 4:13 下午
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(nums, 9));
        System.out.println(binarySearch.search(nums, 3));
        System.out.println(binarySearch.search(nums, 12));
        System.out.println(binarySearch.search(nums, 2));
    }
}
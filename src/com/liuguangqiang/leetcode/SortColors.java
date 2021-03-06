package com.liuguangqiang.leetcode;

import com.liuguangqiang.utils.Utils;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * <p>
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i : nums) {
            switch (i) {
                case 0:
                    redCount++;
                    break;
                case 1:
                    whiteCount++;
                    break;
                case 2:
                    blueCount++;
                    break;
            }
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i < redCount) {
                nums[i] = 0;
            } else if (i < redCount + whiteCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        Utils.printArray(nums);
    }
}

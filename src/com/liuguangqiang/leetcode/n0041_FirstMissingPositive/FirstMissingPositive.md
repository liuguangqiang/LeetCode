## First Missing Positive

https://leetcode.com/problems/first-missing-positive/description/

## Description

```
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.
```

## Example 1:

```
Example 1:

Input: nums = [1,2,0]
Output: 3
```

## Example 2:

```
Input: nums = [3,4,-1,1]
Output: 2
```

## Example 3:

```
Input: nums = [7,8,9,11,12]
Output: 1
```

## Constraints:

- 1 <= nums.length <= 5 * 105
- 231 <= nums[i] <= 231 - 1

## 解题思路

* 找出缺少的最小正整数；
* 把数组中的所有大于0的数字都放入一个HashSet；
* 然后从1开始递增，依次去HashSet中查找，如果不存在则是缺少的最小正整数；

## Solution by java

```
    public int firstMissingPositive(int[] nums) {
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
```
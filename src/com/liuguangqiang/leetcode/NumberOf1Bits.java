package com.liuguangqiang.leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also
 * known as the Hamming weight). For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3. Credits:
 * <p>
 * Created by Eric at 2021/3/12 10:44 下午
 */
public class NumberOf1Bits {

    public static int hammingWeight(long n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}

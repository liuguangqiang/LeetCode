package com.liuguangqiang.leetcode;

/**
 * https://leetcode.com/problems/reverse-string/description/
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example: Given s = "hello", return "olleh".
 * Created by Eric at 2021/3/16 5:05 下午
 */
public class ReverseString {

    public String reverse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String can not be null.");
        }

        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverse("a"));
        System.out.println(rs.reverse("abc"));
        System.out.println(rs.reverse("hello"));
    }
}

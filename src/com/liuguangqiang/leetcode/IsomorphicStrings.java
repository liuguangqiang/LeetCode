package com.liuguangqiang.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * <p>
 * 求同构字符串，原字符串中的每个字符可由另外一个字符替代，可以被其本身替代，
 * 相同的字符一定要被同一个字符替代，且一个字符不能被多个字符替代，即不能出现一对多的映射。
 * <p>
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 * <p>
 * Created by Eric at 2021/3/28 11:23 下午
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) != hashMap2.get(t.charAt(i))) {
                return false;
            }
            hashMap.put(s.charAt(i), i);
            hashMap2.put(t.charAt(i), i);
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic(null, "1"));
        System.out.println(isomorphicStrings.isIsomorphic("add", "egg"));
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
        System.out.println(isomorphicStrings.isIsomorphic("paper", "titit"));
        System.out.println(isomorphicStrings.isIsomorphic("ababab", "bababa"));
    }
}

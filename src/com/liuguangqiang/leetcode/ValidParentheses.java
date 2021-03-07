package com.liuguangqiang.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 */
public class ValidParentheses {

    /**
     * 使用栈；
     * 遍历字符串；
     * 如果是左括号， 就往栈中放入对应的右括号；
     * 如果是右括号， 就取出栈顶的元素进行对比， 如果不相同， 则不合法；
     * 最后在判断栈是否为空， 为空的化， 则是合法的；
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "[()[](){}[]]";
        String s2 = "]][[";
        String s3 = "[";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }
}

package com.leetcode.stack.odd;

import java.util.Stack;

public class Stack01L020 {
    public boolean isValid(String s) {
        boolean valid = true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.pop() != '(') valid = false;
                    break;
                case ']':
                    if (stack.pop() != '[') valid = false;
                    break;
                case '}':
                    if (stack.pop() != '{') valid = false;
                    break;
            }
            if (!valid) break;
        }

        return valid;
    }

    public static void main(String[] args) {
        Stack01L020 solution = new Stack01L020();
        System.out.println(solution.isValid("({[(]]})"));
    }
}

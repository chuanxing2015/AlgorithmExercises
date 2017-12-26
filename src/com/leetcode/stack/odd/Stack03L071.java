package com.leetcode.stack.odd;

import java.util.Stack;

public class Stack03L071 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (".".equals(s) || "".equals(s)) {
            } else if ("..".equals(s)) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }

        String result = "";
        while (!stack.empty()) result = "/" + stack.pop() + result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Stack03L071().simplifyPath("/a/./b/../../c/"));
    }
}

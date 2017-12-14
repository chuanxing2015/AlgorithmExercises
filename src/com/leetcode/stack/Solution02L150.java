package com.leetcode.stack;

import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class Solution02L150 {

    public static int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return -1;
        }
        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int result = 0;
        for(int i = 0;i< tokens.length ; i++){
            if(tokens[i].equals("+")){
                String a1 = stack.pop();
                String a2 = stack.pop();
                if(a1 != null && a2 != null){
                    result = Integer.valueOf(a2) + Integer.valueOf(a1);
                    stack.push(String.valueOf(result));
                }else{
                    return -1;
                }
            }else if(tokens[i].equals("-")){
                String a1 = stack.pop();
                String a2 = stack.pop();
                if(a1 != null && a2 != null){
                    result = Integer.valueOf(a2) - Integer.valueOf(a1);
                    stack.push(String.valueOf(result));
                }else{
                    return -1;
                }
            }else if(tokens[i].equals("*")){
                String a1 = stack.pop();
                String a2 = stack.pop();
                if(a1 != null && a2 != null){
                    result = Integer.valueOf(a2) * Integer.valueOf(a1);
                    stack.push(String.valueOf(result));
                }else{
                    return -1;
                }
            }else if(tokens[i].equals("/")){
                String a1 = stack.pop();
                String a2 = stack.pop();
                if(a1 != null && a2 != null){
                    result = Integer.valueOf(a2) / Integer.valueOf(a1);
                    stack.push(String.valueOf(result));
                }else{
                    return -1;
                }
            }else {
                stack.push(tokens[i]);
            }
        }
        return result;
    }



    public static void main(String[] args){
        String[] strs = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(strs));
    }
}

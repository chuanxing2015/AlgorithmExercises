package com.leetcode.array;

public class Solution10L3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int count = 0;
        int size = 0;
        char[] arr = s.toCharArray();
        int index = 0;
        boolean isReply = false;//内部循环是否发现重复
        for(int i = 1;i < arr.length;i++){
           for(int j = index ;j < i ; j++){
                if(arr[j] == arr[i]){
                    count = i - index;
                    index = j+1;
                    isReply = true;
                }else {
                    count = i+1-index;
                }
           }
           if(isReply){
               isReply = false;
           }
           if(size < count){
                size = count;
           }
        }


        return size;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("bbb"));
    }
}

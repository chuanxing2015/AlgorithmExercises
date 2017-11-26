package com.leetcode.array;

/*

与数组03题条件相同，但是变更一个要求：可以允许元素最多重复2次。

比如，给定nums = [1, 1, 1, 2, 2, 3]， 返回length = 5， nums = [1, 1, 2, 2, 3]。同样不用考虑超出新长度之后的空间遗留。

 */

public class Solution04L80 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int size = nums.length;
        int temp = nums[0];
        int count = 0;
        int flag = -1;
        for(int i = 0; i< nums.length ; i++){
            if(nums[i] == temp){
               count++;
               if(count > 2){
                   size --;
                   if(flag == -1){
                        flag = i;//表示已经有元素超过两个
                   }
               }else if(count == 2 && flag != -1){//移动第二个元素
                   nums[flag]= nums[i];
                   flag++;
               }
            }else {
                if(flag != -1){//有元素超过两个之后，以后有不相同的元素都要向前移动
                    nums[flag]= nums[i];//移动第一元素
                    flag++;
                }
                count = 1;
                temp = nums[i];
            }
        }

        return size;
    }

    public static void main(String[] args){
        int[] arr = {1,1, 1, 2, 2,2,2,2, 3,3,3,4,4,4};
        removeDuplicates(arr);
        for(int a: arr){
            System.out.println(a);
        }
    }
}

package com.leetcode.array;

/*
 给定一个数组和一个值，原地移除数组中所有给定的值，并返回新数组的长度。 不允许申请额外空间，确保空间复杂度为O(1)。
 数组中的元素可以被改变，不用考虑超出新长度之后的空间遗留。

 比如： 给定nums = [3, 2, ,2 3]， val = 3， 你的函数应该返回length = 2， nums = [2, 2]。
 */
public class Solution02L27 {

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        int flag = -1;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){

            if(nums[i] == val){
                size --;
                count++;
                if(flag == -1){
                    flag = i;
                }
            }else{
                if(count != 0){
                    int temp = nums[i];
                    nums[i] = nums[flag];
                    nums[flag]= temp;
                    flag ++;
                }
            }
        }

        return size;
    }



    public static void main(String[] args){
        int[] arr = {3,2,2,3};
        removeElement(arr,3);
        for(int a: arr){
            System.out.println(a);
        }
    }

}

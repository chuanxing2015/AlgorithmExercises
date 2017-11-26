package com.leetcode.array;

/*
【题中包含的数组的进阶技术：对撞指针、快速排序】

在一个无序数组中找到第k大的元素。注意这里的第k大是指在排序顺序中第k大的元素，而不是第k个不同的元素。

比如： 给定[3, 2, 1, 5, 6, 4]，k = 2，则应该返回5。

注意： 你可以假设k的值是有效的。

提示： 使用快速排序的思想可以以O(n)的时间复杂度解决该问题。
 */

public class Solution08L215 {

    public static int findKthLargest(int[] nums, int k) {
        

        return nums[nums.length -k];
    }

    public static void main(String[] args){
        int[] arr = {5, 2, 1, 8, 6, 4};
        findKthLargest(arr,1);
        for(int a: arr){
            System.out.println(a);
        }
    }


}

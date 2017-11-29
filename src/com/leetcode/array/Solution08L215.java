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
        if(nums.length == 1 && k == 1) {
            return nums[0];
        }
        int key = sort(nums,0,nums.length-1,nums.length-k);
        return key;
    }


    public static int sort(int[] nums, int l,int h,int k){

        int low = l;
        int high = h;

        while (low < high){
            while (high > low && nums[high] > nums[low]){
                high--;
            }
            if(high > low){
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                low++;
            }
            while (high > low && nums[high] > nums[low]){
                low++;
            }
            if(high > low){
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                high --;
            }
        }

        if(k > low){
           return sort(nums,low+1,h,k) ;
        }else if(k < low){
            return sort(nums,l,low-1,k);
        }

        return nums[low];
    }

    public static void main(String[] args){
        int[] arr = {5,1,2};
        System.out.println(findKthLargest(arr,1));
    }


}

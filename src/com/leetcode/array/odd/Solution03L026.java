package com.leetcode.array.odd;

public class Solution03L026 {
    /*
     * 数组03 - 从有序数组中删除重复元素 - 简单 - 26
     *
     * 给定一个有序数组，原地删除重复元素使得数组中的元素只保留一个，并且返回新长度。
     * 禁止申请额外空间，确保空间复杂度为O(1)。
     *
     * 比如：
     * 给定nums = [1, 1, 2]，
     *
     * 你的函数应该返回length = 2，nums = [1, 2]。
     * 不用考虑超出新长度之后的空间遗留。
     *
     * O(N)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) nums[++i] = nums[j];
        }
        return i + 1;
    }
}

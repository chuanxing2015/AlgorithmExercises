package com.leetcode.array.odd;

public class Solution09L209 {
    /*
     * 数组09 - 最小尺寸子数组之和 - 中等 - 209
     *
     *【题中包含的数组的进阶技术：滑动窗口技术】
     *
     * 给定一个整形数组和一个整数s，找出数组中最短的一个连续子数组，使得连续子数组中的元素之和sum>=s。
     * 返回这个最短连续子数组。
     *
     * 比如：
     *   nums = [2, 3, 1, 2, 4, 3], s = 7
     *   答案为[4, 3]
     */

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int lo = 0, hi = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[lo];
        while (lo <= hi && hi < nums.length) {
            if (sum >= s) {
                min = min(min, hi - lo + 1);
                if (min == 1) break;
                sum -= nums[lo++];
            } else if (sum < s) {
                if (++hi < nums.length)
                    sum += nums[hi];
                else break;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int min(int min, int n) {
        return min < n ? min : n;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 2, 4, 3};
        int s = 8;
        int minSubArrayLen = new Solution09L209().minSubArrayLen(s, nums);
        System.out.println(minSubArrayLen);
    }
}

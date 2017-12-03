package com.leetcode.array.odd;

public class Solution05L167 {
    /*
     * 数组05 - 两数的和（输入数组已排序） - 简单 - 167
     *
     *【题中包含的数组的进阶技术：对撞指针技术】
     *
     * 给定一个整形数组，并且数组内元素已经按升序排列，找出两个元素，使得它们之和与给定的数相等。
     *
     * 函数应该返回找到的这两个元素的索引，并且第一个元素的索引小于等于第二个元素的索引，并且元素索引起始位置是基于1而不是基于0。
     *
     * 你可以假设给定的目标数在数组中必定找得到对应的两个元素。
     *
     * 比如：
     * 输入： numbers = [2, 7, 11, 15], target = 9
     * 输出： index = 1, index = 2
     *
     * O(N) 分治思想
     */

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if      (numbers[i] + numbers[j] == target) break;
            else if (numbers[i] + numbers[j]  > target) j--;
            else if (numbers[i] + numbers[j]  < target) i++;
        }

        return new int[]{i+1, j+1};
    }
}

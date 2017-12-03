package com.leetcode.array.odd;

import java.util.Arrays;

public class Solution01L283 {

    /*
    *
    * 数组01 - 0的移动 - 简单 - 283
    *
    * 给定一个数组nums，写一个函数，将数组内的0移动到数组末尾，并保持其他非零元素在原数组中的相对位置不变。
    * 比如，给定nums = [0, 1, 0, 3, 12]，调用你的函数之后，nums应该变成[1, 3, 12, 0, 0]。
    *
    * 注意：
    *  1. 请直接在传入的数组对象上修改，而不是另外创建一份拷贝（术语叫做 in-place，也有中译为“原地”）。
    *  2. 尽量减少操作指令代码的行数。
    *
    * O(N)
    */


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if      (nums[i] == 0) f++;
            else if (f > 0) exch(nums, i, i - f);
        }
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        new Solution01L283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

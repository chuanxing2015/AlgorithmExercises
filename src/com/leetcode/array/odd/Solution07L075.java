package com.leetcode.array.odd;

public class Solution07L075 {
    /*
     * 数组07 - 排序颜色 - 中等 - 75
     *
     *【题中包含的数组的进阶技术：对撞指针、三路快速排序】
     *
     * 给定一个数组，其中有n个元素，分别为红色、白色和蓝色，请将数组中的元素进行排序，使得颜色相同的元素排在一起，并且颜色顺序为红、白、蓝。
     * 我们使用整数0、1、2分别代表红、白、蓝3种颜色。
     *
     * 注意：禁止使用标准库提供的排序算法。
     * 提示：尝试使用三路快速排序的思路以O(n)的时间复杂度解决问题。
     *
     */


    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo + 1, lt = lo, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            int cmp = a[i] - v;
            if     (cmp < 0) {exch(a, i++, lt++);}
            else if(cmp > 0) {exch(a, i, gt--);}
            else   i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void main(String[] args) {
        
    }
}

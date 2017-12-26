package com.leetcode.util;

public class Util {
    public static void list(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

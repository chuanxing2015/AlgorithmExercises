package com.leetcode.linked.odd;

public class Solution01L092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode pre = head;
        for (int i = 1; i < m -1;i++) pre = pre.next;
        ListNode last;
        if (m == 1) {
            last = head;
        } else {
            last = pre.next;
        }
        for (int i = 1; i < (n - m + 1); i++) {
            if (m == 1) {
                ListNode tmp = head;
                head = last.next;
                last.next = head.next;
                head.next = tmp;
            } else {//pre.next 类比上面的 head思路一样。
                ListNode tmp = (pre.next);
                (pre.next) = last.next;
                last.next = (pre.next).next;
                (pre.next).next = tmp;
            }
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head,n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        list(head);
        head = new Solution01L092().reverseBetween(head, 1, 1);
        list(head);
    }

    static void list(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

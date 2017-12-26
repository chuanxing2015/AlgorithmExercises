package com.leetcode.linked.odd;

import com.leetcode.util.ListNode;

import static com.leetcode.util.Util.list;

public class Linked07L019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(Integer.MAX_VALUE);
        h.next = head;
        ListNode last = h;
        ListNode cur = h;
        int i = n + 1;
        while (cur.next != null) {
            cur = cur.next;
            if (i > 1) {
                i--;
            } else {
                last = last.next;
            }
        }

        last.next = last.next.next;

        return h.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        list(n1);
        ListNode result = new Linked07L019().removeNthFromEnd(n1, 1);
        list(result);
    }
}

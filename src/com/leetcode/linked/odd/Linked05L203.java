package com.leetcode.linked.odd;

import com.leetcode.util.ListNode;

import static com.leetcode.util.Util.list;
public class Linked05L203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(Integer.MIN_VALUE);
        h.next = head;
        ListNode tmp;
        ListNode pre = h;
        while ((tmp = pre.next) != null) {
            if (tmp.val == val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
        }

        return h.next;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        list(n1);
        ListNode result = new Linked05L203().removeElements(n1, 6);
        list(result);
    }
}

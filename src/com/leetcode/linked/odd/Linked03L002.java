package com.leetcode.linked.odd;

import com.leetcode.util.ListNode;

import static com.leetcode.util.Util.list;
public class Linked03L002 {

    /*
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        boolean f = false;
        ListNode lastl1 = l1;
        while (true) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val;
                f = sum(l1, sum, f);
                lastl1 = l1;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val;
                f = sum(l1, sum, f);
                lastl1 = l1;
                l1 = l1.next;
            } else if (l2 != null){
                int sum = l2.val;
                f = sum(l2, sum, f);
                lastl1.next = l2;
                lastl1 = l2;
                l2 = l2.next;
            } else {
                break;
            }
        }

        return head;
    }

    private boolean sum(ListNode node, int sum, boolean f) {
        if (f) {
            sum += 1;
            f = false;
        }
        if (sum >= 10) {
            node.val = sum % 10;
            f = true;
        } else {
            node.val = sum;
        }
        return f;
    }

    public static void main(String[] args) {
        ListNode l1  = new ListNode(2);
        ListNode l2  = new ListNode(4);
//        ListNode l3  = new ListNode(3);
        ListNode n1  = new ListNode(5);
        ListNode n2  = new ListNode(6);
        ListNode n3  = new ListNode(4);
        l1.next = l2;
//        l2.next = l3;
        n1.next = n2;
        n2.next = n3;

        list(l1);
        list(n1);
        ListNode result = new Linked03L002().addTwoNumbers(l1, n1);
        list(result);
    }

}

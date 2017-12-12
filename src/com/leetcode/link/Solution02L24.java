package com.leetcode.link;

public class Solution02L24 {

    public  ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode curNode = head.next;
        ListNode nextNode = null;
        head = head.next;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = pre;
            if(nextNode != null){
                curNode = nextNode.next;
                if(curNode != null){
                    pre.next = curNode;
                }else{
                    pre.next = nextNode;
                }
            }else{
                pre.next = null;
                curNode = null;
            }
            pre = nextNode;

        }
        this.head = head;
        return  head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private void print(ListNode node){
        ListNode h = node;
        while (h.next != null){
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println(h.val);
    }

    private ListNode head;
    public void add(int i){
        ListNode node = new ListNode(i);
        if(head == null){
            head = node;
        }else {
            ListNode h = head;
            while (h.next != null){
                h = h.next;
            }
            h.next = node;
        }
    }

    public static void main(String[] args){
        Solution02L24 solution02L24  = new Solution02L24();
        solution02L24.add(1);
        solution02L24.add(2);
        solution02L24.add(3);
        solution02L24.add(4);
        solution02L24.add(5);
        solution02L24.add(6);
        solution02L24.add(7);
        solution02L24.print(solution02L24.head);
        ListNode node = solution02L24.swapPairs(solution02L24.head);
        solution02L24.print(node);
    }
}

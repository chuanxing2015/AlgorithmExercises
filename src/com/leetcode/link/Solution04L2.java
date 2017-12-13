package com.leetcode.link;

public class Solution04L2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return reverse(l2);
        } else if(l2 == null){
            return reverse(l1);
        }

        ListNode newNode = null;
        ListNode head = null;
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        int carray = 0;
        while (ln1 != null && ln2!= null){  //循环结束表示有一个链表已经到最后
            int value = ln1.val + ln2.val + carray;
            if(value >= 10){
                value = value%10;
               carray = 1;
            }else{
                carray = 0;
            }
            newNode = new ListNode(value);
            if(head != null){
                newNode.next = head;
            }
            head = newNode;
            ln1 = ln1.next;
            ln2 = ln2.next;
        }

        //拼接链表最后没有计算的元素，注意同样需要判断是否需要进位
        ListNode ln3;
        if(ln1 == null && ln2 == null){
            ln3 = null;
        }else if(ln1 != null){
            ln3 = ln1;
        }else {
            ln3 = ln2;
        }

        if(ln3 == null){//表示两个链表的长度相同
            if(carray != 0){//表示还有进位
                newNode = new ListNode(1);
                newNode.next = head;
                head = newNode;
                carray = 0;
            }
        }else {//表示其中一个链表还有元素
            while (ln3 != null){
                int value = ln3.val + carray;
                if(value >= 10){
                    value = value%10;
                    carray = 1;
                }else{
                    carray = 0;
                }
                newNode = new ListNode(value);
                newNode.next = head;
                head = newNode;
                ln3 = ln3.next;
            }
        }
        //这里还需要判断是否有进位
        if(carray != 0){//表示还有进位
            newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }

        return reverse(head);
    }

    /**
     * 链表反转
     */
    public  static ListNode  reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode hNext = head.next;
        pre.next = null;//这里需要把头结点的next设置为null
        ListNode hNN = null;

        while (hNext != null){
            hNN = hNext.next;
            head = hNext;
            hNext.next = pre;
            pre = hNext;
            hNext = hNN;
        }
        return head;
    }

    static  class ListNode{
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    private static void print(ListNode node){
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
        Solution04L2 solution1  = new Solution04L2();
        solution1.add(1);

        print(solution1.head);

        Solution04L2 solution2  = new Solution04L2();
        solution2.add(9);

        print(solution2.head);

        ListNode node = addTwoNumbers(solution1.head,solution2.head);
        print(node);

    }
}

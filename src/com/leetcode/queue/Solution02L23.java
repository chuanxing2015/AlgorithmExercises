package com.leetcode.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution02L23 {

    //通过优先级对列来实现
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        // PriorityQueue 是堆，默认小顶堆
        PriorityQueue<ListNode> min = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 加入所有链表的第一个结点，非空
        for (ListNode node : lists)
            if (node != null)
                min.offer(node);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!min.isEmpty()) {
            ListNode temp = min.poll();
            cur.next = temp;
            cur = cur.next;
            // 边取边加入
            if (temp.next != null)
                min.offer(temp.next);
        }
        // 注意断链
        cur.next = null;
        return head.next;
    }

    public static ListNode mergeKLists1(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }
        return sort(lists,0,lists.length-1);
    }


    private static ListNode sort(ListNode[] lists , int left , int right){
        if(left < right){
            int center = (left + right) / 2;
            ListNode l1 = sort(lists, left, center);
            ListNode l2 = sort(lists, center + 1, right);
            return merge2List(l1,l2);
        }
        return lists[left];
    }




    private static ListNode merge2List(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head1 = null;
        ListNode head2 = l2;
        while (temp1!= null && temp2 != null){
            if(temp1.val <= temp2.val){
                head1 = temp1;
                temp1 = temp1.next;
            }else{
                head2 = temp2;
                temp2 = temp2.next;
                if(head1 != null){
                    head1.next = head2;
                    head1 = head2;//head需要往后移动一位，否着
                }else{
                   head1 = head2;
                    l1 = head1;
                }
                head2.next = temp1;
            }
        }

        if(temp1 == null){
            head1.next = temp2;
        }

        return l1;
    }


    static  class ListNode{
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    private static void print(ListNode node){
        if(node == null){
            System.out.println("this link is null");
            return;
        }
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
        Solution02L23 solution1 = new Solution02L23();
        solution1.add(1);
        solution1.add(3);
        solution1.add(5);
        solution1.add(7);
        Solution02L23 solution2 = new Solution02L23();
        solution2.add(2);
        solution2.add(4);
        solution2.add(4);
        solution2.add(8);
        Solution02L23 solution3 = new Solution02L23();
        solution3.add(6);
        solution3.add(6);
        solution3.add(9);
        solution3.add(10);
        Solution02L23 solution4 = new Solution02L23();
        solution4.add(1);
        solution4.add(3);
        solution4.add(5);
        solution4.add(7);
        Solution02L23 solution5 = new Solution02L23();
        solution5.add(2);
        solution5.add(4);
        solution5.add(4);
        solution5.add(8);
        Solution02L23 solution6 = new Solution02L23();
        solution6.add(6);
        solution6.add(6);
        solution6.add(9);
        solution6.add(10);

        ListNode[] listNodes = new ListNode[]{
                solution1.head,solution2.head,solution3.head,
                solution4.head,solution5.head,solution6.head};
        long start = System.currentTimeMillis();
        ListNode node = mergeKLists(listNodes);
        System.out.println(System.currentTimeMillis() - start);
        print(node);
    }
}

package com.leetcode.link;

public class Solution08L61 {

    public  ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }

        ListNode tempNode = head;
        ListNode endNode = null;
        int length = 1;
        while (tempNode.next != null){//获取链表的长度
            length++;
            tempNode = tempNode.next;
            endNode = tempNode;
        }

        tempNode = head;
        int rotateRight = k%length;
        if(rotateRight == 0){
            return head;
        }
        for(int i = 0; i< length - rotateRight ; i++){
            if(i == length - rotateRight -1){
                ListNode temp = tempNode;
                tempNode = tempNode.next;
                temp.next = null;
            }else{
                tempNode = tempNode.next;
            }
        }

        if(head != tempNode && endNode != null){
            endNode.next = head;
            head = tempNode;
        }
        return head;
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
        Solution08L61 solution1  = new Solution08L61();
        solution1.add(1);
        solution1.add(2);
        solution1.add(3);
        solution1.add(4);
        solution1.add(5);
        solution1.add(6);

        print(solution1.head);

        ListNode node = solution1.rotateRight(solution1.head,13);
        print(node);

    }
}

package com.leetcode.link;


public class Solution01L92 {

    /**
     * 链表部分反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public  ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>= n|| head == null){
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = null;
        if(m == 1){//m == 1表示重头不开始反转
            curNode = head;
        }else{
            int index = 1;
            ListNode h = head;
            while (h.next!= null){//查找到m处的节点
                index++;
                if(index == m){
                    preNode = h;
                    curNode = h.next;
                    break;
                }
                h = h.next;
            }
        }

        if(curNode != null){
            ListNode pre = curNode;
            ListNode nNext = curNode.next;
            ListNode nNN = null;
            for(int i = 0; i < n-m ; i++){
                nNN = nNext.next;
                nNext.next = pre;
                pre = nNext;
                nNext = nNN;
            }

            if(preNode == null){
                curNode.next = nNN;
                head = pre;
            }else{
                preNode.next = pre;
                curNode.next = nNN;
            }
        }
        this.head = head;
        return head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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

    private void print(ListNode node){
        ListNode h = node;
        while (h.next != null){
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println(h.val);
    }

    /**
     * 链表反转
     */
    public  void  reverse(){
        if(head == null || head.next == null){
            return ;
        }
        ListNode pre = head;
        ListNode hNext = head.next;
        pre.next = null;//这里需要把头结点的next设置为null
        ListNode hNN = null;

        while (hNext != null){
            hNN = hNext.next;
            this.head = hNext;
            hNext.next = pre;
            pre = hNext;
            hNext = hNN;
        }
    }

    public static void main(String[] args){
        Solution01L92 solution01L92 = new Solution01L92();
        solution01L92.add(1);
        solution01L92.add(2);
        solution01L92.add(3);
        solution01L92.add(4);
        solution01L92.add(5);
        solution01L92.add(6);
        solution01L92.print(solution01L92.head);
        ListNode node = solution01L92.reverseBetween(solution01L92.head,4,6);
       // solution01L92.reverse();
        solution01L92.print(node);
    }


}

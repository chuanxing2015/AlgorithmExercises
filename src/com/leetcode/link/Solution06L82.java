package com.leetcode.link;

public class Solution06L82 {

    //删除有序数组中的元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode myHead = null;
        ListNode tempHead = null;
        ListNode temp  = head;
        int count = 1;
        while (temp.next != null){
            if(temp.val == temp.next.val){
                count ++;
            }else{
                if(count > 1 ){//表示有重复的元素
                    count = 1;
                    ListNode tempNext = temp.next.next;//获取不相等时的下一个结点
                    if(tempNext != null ){
                        if(temp.next.val != tempNext.val){//出现不相同的结点也是重复的元素
                            if(myHead == null){
                                myHead = temp.next;
                            }
                            if(tempHead == null){
                                tempHead = temp.next;
                            }else{
                                tempHead.next = temp.next;
                                tempHead = temp.next;
                            }
                        }
                    }else {//表示后边已经没有结点了
                        if(myHead == null){
                            myHead = temp.next;
                        }
                        if(tempHead != null){
                            tempHead.next = temp.next;
                        }
                    }
                }else{
                    if(myHead == null){
                        myHead = temp;
                    }
                    tempHead = temp;
                }
            }
            temp = temp.next;
        }
        //处理最后还有重复的问题
        if(count>1 && tempHead != null){
            tempHead.next = null;
        }

        return myHead;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode temp = head;
        ListNode tempNode  = head;
        while (temp.next != null){
            if(temp.next.val == head.val){//判断头部有相同元素的情况，直到有不重复的元素，头结点移动到该位置
                if(temp.next.next != null){
                    if(temp.next.next.val != head.val){
                        tempNode = temp.next.next;
                        temp.next.next = null;//去掉对下一个元素的引用
                        temp = tempNode;
                        continue;
                    }
                }else {
                    tempNode = null;
                }
            }else {//当重复的元素发生在中部
                if(temp.val == temp.next.val){
                    if(temp.next.next!= null){
                        if(temp.next.next.val != temp.val){//如果下下一个节点不相同，修改链表索引
                            if(preNode != null){
                                ListNode temp1 = temp.next.next;
                                if(temp.next.next.next != null && temp.next.next.val != temp.next.next.next.val){
                                    preNode.next = temp.next.next;
                                    preNode = temp.next.next;
                                }else if(temp.next.next.next == null){
                                    preNode.next = temp.next.next;
                                }

                                temp.next.next= null;
                                temp = temp1;//将移动的节点移动到不相等的地方
                                continue;
                            }else {
                                tempNode = temp.next.next;//重新设置头结点
                                temp = tempNode;
                                continue;
                            }
                        }
                    }else {
                        if(preNode != null){
                            preNode.next = null;
                        }else{
                            tempNode = null;
                        }
                    }
                }else {
                    preNode = temp;
                }
            }
            temp = temp.next;
        }

        head = tempNode;
        return head;
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
        Solution06L82 solution1  = new Solution06L82();
        solution1.add(1);
        solution1.add(2);
        solution1.add(3);
        solution1.add(4);
        solution1.add(4);
        solution1.add(4);
        solution1.add(5);
        solution1.add(5);
        solution1.add(7);
        solution1.add(8);

        print(solution1.head);
        print(solution1.deleteDuplicates(solution1.head));
    }
}

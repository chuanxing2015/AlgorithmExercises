package com.leetcode.tree;

public class Solution14L450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        TreeNode tempNode = root;
        TreeNode preNode = null;
        while (tempNode!= null){//这个循环是为了查找key对应的节点
            if(tempNode.val == key){
                break;
            }else {
                preNode = tempNode;
            }
            if(tempNode.val > key){
                tempNode = tempNode.left;
            }else{
                tempNode = tempNode.right;
            }
        }

        TreeNode treeNode = null;
        if(preNode == null){//说明需要删除的是头结点
            if(tempNode.right == null){
                treeNode = tempNode.left;
                tempNode.left = null;
            }else {
                treeNode = del(tempNode);
            }
        }else {
            treeNode = root;
            if(tempNode != null){//tempNode==null 表示不存在这个节点
                if(tempNode.left == null && tempNode.right == null){//说明是叶子节点
                    if(preNode.left == tempNode){
                        preNode.left = null;
                    }else {
                        preNode.right = null;
                    }
                }else if(tempNode.left != null && tempNode.right == null){//只有一个左孩子
                    if(preNode.left == tempNode){
                        preNode.left = tempNode.left;
                    }else {
                        preNode.right = tempNode.left;
                    }
                    tempNode.left = null;
                }else  if(tempNode.left == null){//只有一个右孩子
                    if(preNode.left == tempNode){
                        preNode.left = tempNode.right;
                    }else {
                        preNode.right = tempNode.right;
                    }
                    tempNode.right = null;
                }else {//有两个孩子
                    TreeNode temp = del(tempNode);
                    if(preNode.left == tempNode){
                        preNode.left = temp;
                    }else {
                        preNode.right = temp;
                    }
                }

            }
        }
        return treeNode;
    }

    private TreeNode del(TreeNode tempNode){
        TreeNode temp = null;
        if(tempNode.right.left == null){
            temp = tempNode.right;
            tempNode.right.left = tempNode.left;
        }else {
            //需要讲tempNode最左边的节点作为跟节点
            TreeNode node = tempNode.right;
            TreeNode p = tempNode.right;
            while (node.left != null){
                p = node;
                node = node.left;
            }

            if(node.right == null){
                p.left = null;
            }else{
                p.left = node.right;
            }

            temp = node;
            node.right = tempNode.right;
            node.left = tempNode.left;
        }
        tempNode.left = null;
        tempNode.right = null;
        return temp;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

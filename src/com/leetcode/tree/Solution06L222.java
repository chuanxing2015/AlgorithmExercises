package com.leetcode.tree;

public class Solution06L222 {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getLeft(root);
        int right = getRight(root);
        if(left == right){
            return (2<<left)-1;
        }else {
            return countNodes(root.left) + countNodes(root.right) +1;
        }
    }


    private int getLeft(TreeNode node){
        int count = 0;
        TreeNode treeNode = node;
        while (treeNode.left!= null){
            count++;
            treeNode = treeNode.left;
        }
        return count;
    }

    private int getRight(TreeNode node){
        int count = 0;
        TreeNode treeNode = node;
        while (treeNode.right!= null){
            count++;
            treeNode = treeNode.right;
        }
        return count;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

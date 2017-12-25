package com.leetcode.tree;

public class Solution12L437 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        getOutPath(root,sum);
        return count;
    }


    private void getOutPath(TreeNode node,int sum){
        if(node == null){
            return;
        }
        //这个内层递归以当前节点为根节点的所有路劲
        getInnerPath(node,sum);
        getOutPath(node.left,sum);
        getOutPath(node.right,sum);
    }

    private int count = 0;
    private void getInnerPath(TreeNode node,int sum){
        if(node == null){
            return;
        }
        //这里只要出现相同就加1操作
        if(node.val == sum){
            count++;
        }
        getInnerPath(node.left,sum-node.val);
        getInnerPath(node.right,sum-node.val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

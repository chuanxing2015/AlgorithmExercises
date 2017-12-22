package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution04L226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return  null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            TreeNode tempNode = node.right;
            node.right = node.left;
            node.left = tempNode;

            if(node.left != null ){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

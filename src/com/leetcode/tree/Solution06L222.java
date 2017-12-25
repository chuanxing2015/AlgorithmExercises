package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution06L222 {

    public int countNodes(TreeNode root) {
        if(root == null){
           return 0;
        }
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            size++;
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.left != null){
                queue.offer(node.left);
            }
        }

        return size;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

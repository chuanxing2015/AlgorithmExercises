package com.leetcode.btree.odd;

import com.leetcode.util.TreeNode;

import java.util.*;

public class Btree03L111 {

    public int minDepth(TreeNode root) {
        return levelHelper(root, 0);
    }

    public int levelHelper(TreeNode root, int height) {
        if (root == null) return height;
        int minLeft = levelHelper(root.left, height + 1);
        int minRight = levelHelper(root.right, height + 1);
        return minLeft - minRight > 0 ? minRight : minLeft;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        int minDepth = new Btree03L111().minDepth(n1);
        System.out.println(minDepth);
    }

}
package com.leetcode.btree.odd;

import com.leetcode.util.TreeNode;

public class Btree05L101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return a(root.left, root.right);
    }

    public boolean a(TreeNode left, TreeNode right) {
        if (left != null && right != null && left.val == right.val) {
            boolean l = a(left.left, right.right);
            boolean r = a(right.left, left.right);
            return l && r;
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        TreeNode n4l = new TreeNode(1);
        TreeNode n4r = new TreeNode(2);
        TreeNode n5l = new TreeNode(2);
        TreeNode n5r = new TreeNode(1);
        TreeNode n6l = new TreeNode(1);
        TreeNode n6r = new TreeNode(2);
        TreeNode n7l = new TreeNode(2);
        TreeNode n7r = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n4.left = n4l;
        n4.right = n4r;
        n5.left = n5l;
        n5.right = n5r;
        n6.left = n6l;
        n6.right = n6r;
        n7.left = n7l;
        n7.right = n7r;
        boolean symmetric = new Btree05L101().isSymmetric(n1);
        System.out.println(symmetric);
    }

}

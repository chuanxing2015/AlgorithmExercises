package com.leetcode.btree.odd;

import com.leetcode.util.TreeNode;

import java.util.*;

public class Btree01L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();

        if (root == null) return lists;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }

            lists.add(list);
        }

        return lists;
    }

    //递归 DFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        levelHelper(res, root, 0);
//        return res;
//    }
//
//    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
//        if (root == null) return;
//        if (height >= res.size()) {
//            res.add(new LinkedList<Integer>());
//        }
//        res.get(height).add(root.val);
//        levelHelper(res, root.left, height+1);
//        levelHelper(res, root.right, height+1);
//    }


}

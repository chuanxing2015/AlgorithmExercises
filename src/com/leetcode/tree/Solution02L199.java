package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution02L199 {

    //做这道题的思路会使用到队列，但是还需要知道怎么去遍历二叉树的宽度
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        int lastNodeNUm = 1;
        while (!linkedList.isEmpty()){
            boolean flag = true;
            while (lastNodeNUm != 0){
                TreeNode node = linkedList.poll();
                if(flag){//只取每层最右边的一个节点
                    flag = false;
                    list.add(node.val);
                }
                if(node.right != null){
                    linkedList.offer(node.right);
                }
                if(node.left !=null){
                    linkedList.offer(node.left);
                }
                lastNodeNUm --;
            }
            lastNodeNUm = linkedList.size();
        }
        return list;
    }


    /**
     *  计算二叉树的高度
     */
    public int calculateTreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = calculateTreeDepth(root.left);
        int right = calculateTreeDepth(root.right);
        return left > right ? left+1:right+1;
    }

    /**
     * 计算二叉树的宽度
     */
    public int calculateTreeWidth(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int lastNodeNum = 1;//用来记录上一层节点的个数
        int width = 1;

        while (!queue.isEmpty()){
            while (lastNodeNum != 0){//取出当前层的节点.并把当前层的子节点放入到队列中
                TreeNode node = queue.poll();
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                lastNodeNum --;
            }
            //这里就可以通过队列的大小获取下层元素的节点个数
            lastNodeNum = queue.size();
            if(lastNodeNum > width){
                width = lastNodeNum;//如果有节点数大于当前的节点数，就更新
            }
        }
        return width;
    }

//计算布局的深度
//    public int cal(ViewGroup root){
//        if(root == null){
//            return 0;
//        }
//        int depth = 0;
//        for(int i = 0;i<root.getChildCount() ;i++){
//            View view = root.getChildAt(i);
//            int a = 0;
//            if(view instanceof ViewGroup){
//                a = cal((ViewGroup) view);
//            }else{
//                a = 1;
//            }
//            if(a > depth){
//                depth = a;
//            }
//        }
//        return depth + 1;
//    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

package com.chenlin.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 * @author chenglin
 * @date 2021/1/12
 **/
public class LevelOrderTree {
    /**
     * 使用使用队列
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.value);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * 临时集合保存
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //按层遍历即可
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = treeNodes.remove(0);
                list.add(remove.value);
                if (remove.left != null) {
                    treeNodes.add(remove.left);
                }
                if (remove.right != null) {
                    treeNodes.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

}

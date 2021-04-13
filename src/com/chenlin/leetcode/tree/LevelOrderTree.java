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
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                Node node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * 临时集合保存
     */
    public List<List<Integer>> levelOrder2(Node root) {
        //按层遍历即可
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node remove = nodes.remove(0);
                list.add(remove.value);
                if (remove.left != null) {
                    nodes.add(remove.left);
                }
                if (remove.right != null) {
                    nodes.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

}

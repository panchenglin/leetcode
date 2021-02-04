package com.chenlin.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bjpanhongwei
 * @date 2021/1/12
 **/
public class LevelOrderTree {
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

    public List<List<Integer>> levelOrder2(Node root) {
        //按层遍历即可
        //1.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        //2.
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

    class Node {
        Integer value;//本节点的值
        Node left;//左边的子节点
        Node right;//右边的子节点

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}

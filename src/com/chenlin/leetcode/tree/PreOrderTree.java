package com.chenlin.leetcode.tree;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
 * @author chenlin
 * @date 2021/4/20
 **/
public class PreOrderTree {

    /**
     * 迭代
     */
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> list = Lists.newArrayList();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 模拟栈处理 先把当前所有左节点入栈，拿到当前最左节点开始遍历右节点
     */
    public List<Integer> preOrderStack(TreeNode root){
        List<Integer> list = new ArrayList();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty()){
            while (node != null){
                list.add(node.value);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

}

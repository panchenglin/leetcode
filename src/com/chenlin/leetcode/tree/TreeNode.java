package com.chenlin.leetcode.tree;

/**
 * @author chengln
 * @date 2021/4/13
 **/
public class TreeNode {
    /**
     * 本节点的值
     */
    Integer value;
    /**
     * 左边的子节点
     */
    TreeNode left;
    /**
     * 右边的子节点
     */
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

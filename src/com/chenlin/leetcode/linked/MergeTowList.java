package com.chenlin.leetcode.linked;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 * @author chenglin
 * @date 2021/2/4
 **/
public class MergeTowList {

    /**
     * 递归
     */
    public ListNode mergeListRecursion(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeListRecursion(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeListRecursion(l1, l2.next);
            return l2;
        }
    }

    /**
     * 遍历
     */
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode prevHead = new ListNode();
        ListNode prev = prevHead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2:l1;
        return prevHead.next;
    }
}

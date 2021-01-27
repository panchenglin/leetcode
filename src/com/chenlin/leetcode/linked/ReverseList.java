package com.chenlin.leetcode.linked;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * @author chenglin
 * 2021/1/26
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode listNode = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

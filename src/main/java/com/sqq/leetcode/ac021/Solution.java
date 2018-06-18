package com.sqq.leetcode.ac021;

/**
 * @author qianqian.sun 2018/6/18
 * 描述：21. Merge Two Sorted Lists
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (null != l1 || null != l2) {
            if (null != l1 && null != l2) {
                if (l1.val < l2.val) {
                    node.val = l1.val;
                    l1 = l1.next;
                } else {
                    node.val = l2.val;
                    l2 = l2.next;
                }
            } else if (null != l1) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
            if (null != l1 || null != l2) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        node.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode l3 = new Solution().mergeTwoLists(l1, l2);
        System.out.println(l3);

    }
}

package com.sqq.leetcode.ac021;

/**
 * @author qianqian.sun 2018/6/18
 * 描述：
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        while (null != next) {
            sb.append("->").append(next.val);
            next = next.next;
        }
        return sb.toString();
    }
}

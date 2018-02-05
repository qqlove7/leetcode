package com.sqq.leetcode.ac002;

import org.junit.Test;

/*
You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

两个非负值链表，每项为单个数字，链表各项相加并返回新链表。
注意：
1. 数字相加大于10则进位
2. 两个链表可能为空或长度不同

思路：
1. 循环条件为链表不为空或进位不为0
2. 链表项相加再加进位值
*/
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0; // 进位 0、1
        while (l1 != null || l2 != null || tmp != 0) {
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(tmp % 10);
            p = p.next;
            tmp = tmp / 10;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ,");
            l3 = l3.next;
        }
    }
}


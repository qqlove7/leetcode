package com.sqq.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
    You are given two linked lists representing two non-negative numbers.
        The digits are stored in reverse order and each of their nodes
        contain a single digit. Add the two numbers and return it as a linked list.

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
*/
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mod = 0;
        boolean flag = true, flag2 = true;
        List<Integer> valList = new ArrayList<Integer>();
        while (flag || flag2) {
            int val = l1.val + l2.val + mod;
            valList.add(val % 10);
            mod = val / 10;
            if (l1.next == null) {
                flag = false;
                l1 = new ListNode(0);
            } else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                flag2 = false;
                l2 = new ListNode(0);
            } else {
                l2 = l2.next;
            }
        }
        if (mod > 0) {
            valList.add(mod);
        }
        int size = valList.size();
        ListNode l4 = new ListNode(valList.get(size - 1));
        ListNode l3 = l4;
        for (int i = size - 2; i >= 0; i--) {
            l3 = new ListNode(valList.get(i));
            l3.next = l4;
            l4 = l3;
        }
        return l3;
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

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
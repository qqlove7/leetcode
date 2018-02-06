package com.sqq.leetcode.ac009;

import org.junit.Test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 * 判断一个数字是否回文数字
 * 两个思路：
 * 将数字反转后对比
 * 前置与后置向中间夹逼比较
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String origin = String.valueOf(x);
        StringBuilder sb = new StringBuilder(origin);
        return sb.reverse().toString().equals(origin);
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(1214));
    }
}

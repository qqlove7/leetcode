package com.sqq.leetcode.ac007;

import org.junit.Test;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output:  321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 数字反转
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return x;
        long output = 0;
        while (true) {
            output = output * 10 + x % 10;
            x = x / 10;
            if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) {
                return 0;
            }
            if (x == 0) {
                return (int) output;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(reverse(1534236469));
    }
}

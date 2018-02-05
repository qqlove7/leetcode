package com.sqq.leetcode.ac005;

import org.junit.Test;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * <p>
 * 找出一个字符串的最长回文结构子串
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = 0;
        String longestPalindrome = null;
        for (int i = 0; i < s.length(); i++) {
            int temp = longestPalindrome(s, i);
            if (len < temp) {
                len = temp;
                if (len % 2 == 0) {
                    int pad = (len - 2) / 2;
                    longestPalindrome = s.substring((i - pad), (i + pad + 2));
                } else {
                    int pad = (len - 1) / 2;
                    longestPalindrome = s.substring((i - pad), (i + pad + 1));
                }
            }
        }
        return longestPalindrome;
    }

    /**
     * 判断字符串s中index位置及左右字符形成回文结构的长度
     * 回文结构有两种
     * 长度为奇数的：两边依据中间一个数字对称
     * 长度为偶数的：两边根据中间对称，中间两个数字相等
     */
    public int longestPalindrome(String s, int index) {
        int pad, oddLen, evenLen;
        oddLen = pad = 1;
        while (index - pad >= 0 && index + pad < s.length()
                && s.charAt(index - pad) == s.charAt(index + pad)) {
            oddLen += 2;
            pad++;
        }
        evenLen = pad = 1;
        if (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {
            evenLen = 2;
            while (index - pad >= 0 && index + 1 + pad < s.length()
                    && s.charAt(index - pad) == s.charAt(index + 1 + pad)) {
                evenLen += 2;
                pad++;
            }
        }
        return Math.max(oddLen, evenLen);
    }

    @Test
    public void test() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s, 1));
    }

}

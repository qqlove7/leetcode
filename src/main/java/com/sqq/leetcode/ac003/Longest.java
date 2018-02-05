package com.sqq.leetcode.ac003;
/*

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

一个字符串s，寻找最长不重复子串的长度。

解体思路：
将字符映射到数组的索引，索引对应的值是该字符在字符串s中最近出现的位置。
迭代字符串s，左边界值left，最长不重复子串的长度res
如果取字符已经出现在数组中，重置左边界为该字符在字符串s中最近出现的位置+1
res则是迭代中，迭代索引i-left+1的最大值

*/

import org.junit.Test;

public class Longest {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        int prev[] = new int[300];

        // init prev array
        for (int i = 0; i < 300; ++i)
            prev[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (prev[s.charAt(i)] >= left)
                left = prev[s.charAt(i)] + 1;
            prev[s.charAt(i)] = i;
            if (res < i - left + 1) {
                System.out.println(s.substring(left, i + 1));
                res = i - left + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "abceabcdcdd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

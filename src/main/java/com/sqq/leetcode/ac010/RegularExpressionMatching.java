package com.sqq.leetcode.ac010;

import org.junit.Test;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 表达式解析匹配 点号匹配单个任意字符，星号匹配零或多个重复字符
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        if (lens == 0 && lenp == 0)
            return true;

        // init
        boolean[][] dp = new boolean[2][lenp + 1];
        dp[0][0] = dp[1][0] = true;
        for (int j = 2; j <= lenp; ++j) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = dp[1][j] = true;
            }
        }

        // dp
        for (int i = 1; i <= lens; ++i) {
            dp[i & 1][0] = false;
            for (int j = 1; j <= lenp; ++j) {
                dp[i & 1][j] = ((p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') && dp[1 - (i & 1)][j - 1])
                        || p.charAt(j - 1) == '*' && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[1 - (i & 1)][j]
                        || (j >= 2 && p.charAt(j - 1) == '*' && dp[i & 1][j - 2]);
            }
        }

        return dp[lens & 1][lenp];
    }

    @Test
    public void test() {
        assert isMatch("aa", ".*");
        assert isMatch("aab", "c*a*b");
        assert isMatch("aaa", "a*a");
        assert isMatch("abcdede", "ab.*de");
        assert !isMatch("ab", ".*c");
    }
}

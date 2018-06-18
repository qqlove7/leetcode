package com.sqq.leetcode.ac014;

/**
 * @author qianqian.sun 2018/6/18
 * 描述：14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) return "";
        String pix = strs[0];
        for (String s : strs) {
            while (s.indexOf(pix) != 0) {
                pix = pix.substring(0, pix.length() - 1);
            }
        }
        return pix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs2 = new String[]{"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs2));

    }
}

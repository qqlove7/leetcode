package com.sqq.leetcode.ac006;

import org.junit.Test;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 将字符串进行Z字形排列，以此取每行的字符组成新字符串
 * 解题思路：
 * 找出每行周期规律，双循环获取。
 * 规律：有一个周期，每个周期之间还有一个数字，找到周期开始距离这个数字的间距。
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0) return "";
        int cycle = numRows * 2 - 2;
        if (0 == cycle) return s;
        int cycleCount = s.length() / cycle;
        if (s.length() % cycle > 0) cycleCount++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int gap = (cycle + 1 - (i % cycle) * 2 - 1);
            for (int j = 0; j < cycleCount; j++) {
                if ((i + cycle * j) < s.length()) {
                    sb.append(s.charAt(i + cycle * j));
                }
                if (gap != cycle && gap != 0 && (i + cycle * j + gap) < s.length()) {
                    sb.append(s.charAt(i + cycle * j + gap));
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}

package com.sqq.leetcode;
/*

Given a string, find the length of the longest substring without repeating characters.
        For example, the longest substring without repeating letters for "abcabcbb" is "abc",
        which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Longest {
    public int lengthOfLongestSubstring(String s) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int len = s.length();
        if (len==0) return 0;
        int n =0,max=0;
        for (int i = 0; i < len; i++) {
            int tmp = 'z'-s.charAt(i);
            n++;
            if (map.containsKey(tmp)){
                n = Math.min(n, i - map.get(tmp));
            }
            map.put(tmp,i);
            max = Math.max(max,n);
        }
        return max;
    }

    @Test
    public void test() {
        String s = "abceabcdcdd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

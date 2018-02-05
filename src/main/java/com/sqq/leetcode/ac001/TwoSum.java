package com.sqq.leetcode.ac001;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
        Given an array of integers, find two numbers such that they add up to a specific target number.
        The function twoSum should return indices of the two numbers such that they add up to the target,
        where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
        You may assume that each input would have exactly one solution.
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

        思路是循环一次，每次都判断当前数组索引位置的值在不在hashtable里，不在的话，加入进去，key为数值，value为它的索引值；在的话，取得他的key，
        记为n（此时n一定小于循环变量i），接下来再在hashtable中查找（target-当前数值）这个数，利用了hashtable中查找元素时间为常数的优势，如果找到了就结束，
        此处需要注意的是，如果数组中有重复的值出现，那么第二次出现时就不会加入到hashtable里了
*/
public class TwoSum {
    private static int[] numbers = {2, 2, 7, 11, 15};

    public static int[] twoSum(int[] nums, int target) {
        int[] s = new int[2];
        Map<Integer, Integer> sb = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = sb.get(target - nums[i]);
            if (n != null && n < i) {
                s[0] = n ;
                s[1] = i;
                return s;
            } else sb.putIfAbsent(nums[i], i);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(numbers, 9)));;
    }
}

package com.sqq.leetcode;

import org.junit.Test;

import java.util.Hashtable;

/*Given an array of integers, find two numbers such that they add up to a specific target number.

        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

        You may assume that each input would have exactly one solution.

        Input: numbers={2, 7, 11, 15}, target=9

        Output: index1=1, index2=2

        思路是循环一次，每次都判断当前数组索引位置的值在不在hashtable里，不在的话，加入进去，key为数值，value为它的索引值；在的话，取得他的key，
        记为n（此时n一定小于循环变量i），接下来再在hashtable中查找（target-当前数值）这个数，利用了hashtable中查找元素时间为常数的优势，如果找到了就结束，
        此处需要注意的是，如果数组中有重复的值出现，那么第二次出现时就不会加入到hashtable里了
        */
public class TwoSum {
    private static int[] numbers = {2,7,11,15};

    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

    @Test
    public void test() {
        printArry(twoSum(numbers, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] s = new int[2];
        Hashtable<Integer, Integer> sb = new Hashtable<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer n = sb.get(numbers[i]);
            if (null == n) {
                sb.put(numbers[i], i);
            }
            n = sb.get(target - numbers[i]);
            if (n != null && n < i) {
                s[0] = n+1;
                s[1] = i+1;
                return s;
            }
        }
        return  s ;
    }
}

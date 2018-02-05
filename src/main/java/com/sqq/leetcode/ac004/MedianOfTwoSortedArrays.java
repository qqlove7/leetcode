package com.sqq.leetcode.ac004;

import org.junit.Test;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * 寻找两个有序数组的中位数
 * 解题思路：
 * 采用归并排序的套路，但不创建新的数组，只是用来找到 (m+n)/2 位数字，注意奇偶性。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mid = new int[2];
        int[] value = new int[2];
        if ((m + n) % 2 == 0) {
            mid[0] = (m + n) / 2 - 1;
            mid[1] = (m + n) / 2;
        } else {
            mid[0] = mid[1] = (m + n) / 2;
        }
        int i, j, z;
        i = j = z = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    z = nums1[i];
                    i++;
                } else {
                    z = nums2[j];
                    j++;
                }
            } else if (i >= m && j < n) {
                z = nums2[j];
                j++;
            } else if (i < m && j >= n) {
                z = nums1[i];
                i++;
            }

            if (mid[0] == (i + j - 1)) {
                value[0] = z;
            }
            if (mid[1] == (i + j - 1)) {
                value[1] = z;
                return (double) (value[0] + value[1]) / 2;
            }
        }
        return 0.0;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

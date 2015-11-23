package com.sqq.search;

import com.test.sort.BaseUtil;

import java.util.Arrays;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/20
 * @Description:
 * @CodeReviewer:
 */
public class BinarySearch extends BaseUtil {
    static int[] a = {1, 2, 5, 6, 15, 46, 58, 99};

    public static void main(String[] args) {
        printArray(a);
        int key_index = binarySearch(a, 5);
        System.out.println(key_index);
        System.out.println(binarySearch2(a, 5));
        System.out.println(Arrays.binarySearch(a, 5));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] a, int key) {
        return rank(a, key, 0, a.length - 1);
    }

    public static int rank(int[] a, int key, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) {
            return -1;
        }
        if (key < a[mid]) {
            return rank(a, key, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(a, key, mid + 1, hi);
        } else {
            return mid;
        }
    }
}

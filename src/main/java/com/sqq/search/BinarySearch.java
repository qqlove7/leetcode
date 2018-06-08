package com.sqq.search;

import com.sqq.common.BaseUtil;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/20
 * 二分查找：在有序数组中找到一个元素的索引
 * 与区间中间数值比较，小则与左侧区间递归，大则在右侧区间递归
 */
public class BinarySearch extends BaseUtil {
    static int[] a = {1, 2, 5, 6, 15, 46, 58, 99};

    public static void main(String[] args) {
        printArray(a);
        int key_index = binarySearch(a, 46);
        System.out.println(key_index);
    }

    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        return rank(a, key, lo, hi);
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

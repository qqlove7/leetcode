package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description: 快速排序
 * @CodeReviewer:
 */
public class QuickSort extends BaseUtil {
    int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println();
        printArray(quick_sort(a, 0, a.length - 1));
    }

    public static int[] quick_sort(int[] a, int p, int r) {
        if (p < r) {
            int q = getQ(a, p, r);
            quick_sort(a, p, q - 1);
            quick_sort(a, q + 1, r);
        }
        return a;
    }

    /**
     * 快速排序：分治法一：取一基准数，将数组中比它大的放到右边，小于等于它的放到左边。然后对左边和右边的数组重复这一过程。
     *
     * @param a 待排序数组
     * @param p 数组开始下标
     * @param r 数组结束下标
     * @return
     */
    public static int getQ(int[] a, int p, int r) {
        int key = a[p];
        while (p < r) {
            while (p < r && a[r] > key) {
                r--;
            }
            if (p < r) {
                a[p] = a[r];
            }
            while (p < r && a[p] < key) {
                p++;
            }
            if (p < r) {
                a[r] = a[p];
            }
        }
        a[p] = key;
        return p;
    }
}

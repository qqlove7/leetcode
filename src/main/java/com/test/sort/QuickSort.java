package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description:
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

    public static int getQ(int[] a, int p, int r) {
        int i = p, j = r;
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] > key) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
            }
            while (i < j && a[i] < key) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
            }
        }
        a[i] = key;
        return i;
    }
}

package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description:
 * @CodeReviewer:
 */
public class InsertSort extends BaseUtil {
    int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println();
        printArray(insertSort(a, 0, a.length-1));
    }

    public static int[] insertSort(int[] a, int p, int r) {
        int j,key;
        for (int i = p + 1; i <= r; i++) {
            key = a[i];
            for (j = i - 1; j >= 0 && a[j] > key; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
        return a;
    }
}

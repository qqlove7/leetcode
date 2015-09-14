package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description:
 * @CodeReviewer:
 */
public class BubbleSort extends BaseUtil {
    int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println();
        printArray(bubbleSort(a,1,a.length));
    }

    public static int[] bubbleSort(int[] a, int p, int r) {
        for (int i = p; i < r; i++) {
            for (int j = p-1; j < r - i; j++) {
                if (a[j] > a[r - i]) {
                    int temp = a[j];
                    a[j] = a[r - i];
                    a[r - i] = temp;
                }
            }
        }
        return a;
    }
}

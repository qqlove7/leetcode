package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/23
 * @Description:
 * @CodeReviewer:
 */
public class ShellSort extends BaseUtil {
    static int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        shellSort(a, 0, a.length - 1);
        printArray(a);
    }

    public static void shellSort(int[] a, int p, int r) {
        for (int gap = (r + 1) / 2; gap > 0; gap--) {
            for (int i = gap; i <= r; i++) {
                // a[i-gap] a[i] a[i+gap] a[i+2*gap]
                for (int j = i - gap; j >= 0 && a[j] > a[i]; j -= gap) {
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }
            }
        }
    }
}

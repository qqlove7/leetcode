package com.sqq.sort;

import com.sqq.common.BaseUtil;
import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/16.
 * <p/>
 * 冒泡排序.时间复杂度O(n^2)
 * 效率低,n小时使用
 */
public class BubbleSort {

    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};

    /**
     * 冒泡排序：每一次将最大值放到最后
     *
     * @param a
     * @param lo
     * @param hi
     */
    public void sort(int[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = lo; j < hi - i; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void testSort() {
        printArray(a);
        sort(a, 0, a.length - 1);
        printArray(a);

    }

    public void printArray(int[] a) {
        BaseUtil.printArray(a);
    }

}
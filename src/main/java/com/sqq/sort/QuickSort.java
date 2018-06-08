package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/18.
 */
public class QuickSort {

    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};

    /**
     * 经典排序算法 - 快速排序Quick sort
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     */
    public void quickSort(int[] a, int low, int hi) {
        if (low < hi) {
            int q = partition(a, low, hi);
            quickSort(a, low, q - 1);
            quickSort(a, q + 1, hi);
        }
    }

    private int partition(int[] a, int low, int hi) {
        int i = low, j = hi + 1;
        int v = a[low];

        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (a[--j] > v) if (j == low) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return low;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void testSort() {
        printArry(a);
        quickSort(a, 0, a.length - 1);
        printArry(a);
    }


    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


}

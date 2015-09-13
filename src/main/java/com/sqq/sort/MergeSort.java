package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/16.
 * <p/>
 * 归并排序是建立在归并操作上的排序算法,采用分治法.
 */
public class MergeSort {

    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};
    public static int[] b = {1, 2, 5, 8, 9};
    public static int[] c = {3, 7, 10};

    @Test
    public void testSort() {
        System.out.println("  初始数组为:          " + toString(a));
        printArry(MergeSort(a));
    }

    public static String toString(int[] a) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i : a) {
            stringBuffer.append(i);
            stringBuffer.append(" , ");
        }
        return stringBuffer.toString();
    }

    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

    /**
     * 首先考虑将两个有序队列合并
     */
    public static int[] memberArray(int[] b, int[] c) {
        int i, j, k;
        int m = b.length, n = c.length;
        int[] d = new int[m + n];
        i = j = k = 0;
        while (i < m && j < n) {
            if (b[i] < c[j]) {
                d[k++] = b[i++];
            } else {
                d[k++] = c[j++];
            }
        }
        while (i < m) {
            d[k++] = b[i++];
        }
        while (j < n) {
            d[k++] = c[j++];
        }
        return d;
    }

    /**
     * 归并排序就是先将待排序队列分为A,B两组,再分别将组分解下去直到每个组中只有一个元素
     * 这是可以认为每个组都是有序的,开始合并相邻有序队列
     */
    public int[] MergeSort(int[] a) {
        int len = a.length;
        int[] temp = new int[len];
        mergeSort(a, 0, a.length - 1, temp);
        return a;
    }

    public void mergeSort(int[] a, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp);  //让左边有序
            mergeSort(a, mid + 1, last, temp); //让右边有序
            memberArray(a, first, mid, last, temp);
        }

    }

    public void memberArray(int[] a, int first, int mid, int last, int[] temp) {
        int i = first, j = mid + 1, k = 0;
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= last) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[first + i] = temp[i];
        }
    }


}

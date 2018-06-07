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

    public void mergeSort(int a[], int lo, int hi, int[] temp) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(a, lo, mid, temp);
            mergeSort(a, mid + 1, hi, temp);
            merge(a, lo, mid, hi, temp);
        }
    }

    /**
     * 归并有序的 a[lo]..a[mid] 和a[mid+1]..a[hi]
     */
    private void merge(int[] a, int lo, int mid, int hi, int[] temp) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i <= mid && j <= hi) {
                if (a[i] < a[j]) temp[k] = a[i++];
                else temp[k] = a[j++];
            } else if (i <= mid && j > hi) temp[k] = a[i++];
            else if (i > mid && j <= hi) temp[k] = a[j++];
        }
        System.arraycopy(temp, lo, a, lo, hi - lo + 1);
    }

    @Test
    public void testSort() {
        printArry(a);
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
        System.out.println();
        printArry(a);
    }

    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }


}

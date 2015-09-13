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
    public static int adjustArray(int[] a, int low, int high) {        //返回调整后的基数的位置
        int i = low, j = high;
        int x = a[low];   //第一个坑
        while (i < j) {
            //从右向左寻找比基准数小的数,填入左边个坑
            while (i < j && a[j] > x) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            //从左向右寻找比基准数大的元素,填入右边的坑
            while (a[i] < x && i < j) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        //退出循环是i=j 就是新基准数的坑位置
        a[i] = x;
        return i;
    }

    public static int[] quick_sort(int[] a, int low, int high) {
        if (low < high) {
            int i = adjustArray(a, low, high);
            quick_sort(a, low, i - 1);
            quick_sort(a, i + 1, high);
        }
        return a;
    }

    /**
     * 快速排序整合版
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int[] quickSort(int[] a, int low, int high) {
        if (low < high) {
            int i = low, j = high;
            int x = a[low];
            while (i < j) {
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = x;
            quickSort(a, low, i - 1);
            quickSort(a, i + 1, high);
        }
        return a;
    }


    @Test
    public void testSort() {
//      printArry(quick_sort(a, 0, a.length - 1));
        printArry(quickSort(a, 0, a.length - 1));

    }


    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

}

package com.sqq.sort;

import org.junit.Test;

/**
 * 直接选择排序
 * 将整个数组视为无序队列,每一次对无序队列的循环都将最小元素放到队头并入有序队列
 */
public class SelectSort {
    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};


    /**
     * 选择排序：每一次从后面的选出最小数，放到前面
     *
     * @param a  数组
     * @param lo 开始索引
     * @param hi 结束索引
     */
    public void sort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = hi - 1; j >= i; j--) {
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
        printArry(a);
        sort(a, 0, a.length - 1);
        printArry(a);

    }

    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

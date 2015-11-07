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
        printArray(insertSort(a, 0, a.length - 1));
    }

    /**
     * 插入排序: 从无序队列中依次拿出一个值，插入到有序队列中
     *
     * @param a 数组
     * @param p 数组开始下标 default 0.
     * @param r 数组结束下标 default a.length-1
     * @return
     */
    public static int[] insertSort(int[] a, int p, int r) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i]; //无序队列中拿出的值
            int j; // 值append到有序队列后，将有序队列从后向前遍历，j为向前遍历遇到的下标
            for (j = i - 1; j >= 0 && a[j + 1] < a[j]; j--) {
                int temp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = temp;
            }
            a[j + 1] = x;
        }
        return a;
    }
}

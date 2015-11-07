package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description: ð������
 * @CodeReviewer:
 */
public class BubbleSort extends BaseUtil {
    int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println();
        printArray(bubbleSort(a, 0, a.length-1));
    }

    /**
     * 冒泡排序: 每一次遍历把最大的值放到乱序队列的最后位置
     *
     * @param a 数组
     * @param p 数组开始下标 default 0.
     * @param r 数组结束下标 default a.length-1
     * @return
     */
    public static int[] bubbleSort(int[] a, int p, int r) {
        for (int i = r; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}

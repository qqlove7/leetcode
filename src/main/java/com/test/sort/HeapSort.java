package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description: 最小堆特征：跟节点最小。
 * 若父节点索引i,则子节点 2i+1 , 2i+2
 * 若子节点索引j,则父节点 (j-1)/2
 * 堆排序：先堆化数组，然后将根节点与无序队列尾节点交换，然后将这个尾节点之前数组视为无序队列，重复上述过程。
 * @CodeReviewer:
 */
public class HeapSort extends BaseUtil {
    static int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println("init min heap..");
        initHeap(a, a.length - 1);
        printArray(a);
        System.out.println("minHeap sort ..");
        minHeapSort(a, 0, a.length - 1);
        printArray(a);
    }

    /**
     * 堆调整 调整 a中以p为源节点的堆
     *
     * @param a 整体数组
     * @param p 待调整的堆 头节点索引
     * @param r 数组尾下标
     */
    public static void adjustHeap(int[] a, int p, int r) {
        int key = a[p];
        int child = p * 2 + 1;
        while (child <= r) {
            if (child + 1 <= r && a[child + 1] < a[child]) {
                child++;  //找出左右子节点中最小的
            }
            if (key <= a[child]) {
                break;
            }
            a[p] = a[child];
            p = child;
            child = p * 2 + 1;
        }
        a[p] = key;
    }

    /**
     * 初始化堆
     *
     * @param a
     * @param r
     */
    public static void initHeap(int[] a, int r) {
        for (int p = (r - 1) / 2; p >= 0; p--) {
            adjustHeap(a, p, r);
        }
    }

    /**
     * 使用最小堆实现排序
     *
     * @param a
     * @param p
     * @param r
     */
    public static void minHeapSort(int[] a, int p, int r) {
        initHeap(a, r);
        for (int i = r; i >= 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, p, i-1);
        }
    }
}

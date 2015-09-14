package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description:
 * @CodeReviewer:
 */
public class HeapSort extends BaseUtil {
    static int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

    @Test
    public void test() {
        printArray(a);
        System.out.println("init min heap..");
        initHeap(a, 0, a.length - 1);
        printArray(a);
        System.out.println("minHeap sort ..");
        minHeapSort(a, 0, a.length - 1);
        printArray(a);
    }

    public static void adjustHeap(int[] a, int p, int r) {
        int key = a[p];
        int child = 2 * p + 1;
        while (child <= r) {
            if (child + 1 <= r && a[child + 1] < a[child]) {
                child++;
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

    public static void initHeap(int[] a, int p, int r) {
        for (int q = (r-1)/2 ; q >= 0; q--) {
            adjustHeap(a, q, r);
        }
    }

    public static void minHeapSort(int[] a, int p, int r) {
        initHeap(a, p, r);
        for (int i = r; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, p, i-1);
        }
    }
}

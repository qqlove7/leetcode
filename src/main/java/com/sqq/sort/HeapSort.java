package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/4/1.
 * 堆排序,将数组堆化,再将第0个节点一次和第n-1,n-2..交换,然后堆化0..n-1,0..n-2的数组,得到有序队列
 * 最小堆得到的是递减序列,最大堆得到递增序列
 * 最小二叉堆特性: 父节点小于子节点,根节点最小
 * 若子节点索引为 i,则其父节点索引为(i-1)/2
 * 若父节点索引为 j,则其子节点为 2j+1,2j+2
 */
public class HeapSort {
    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 1, 8, 6};
    int[] s = {2, 1, 3};

    @Test
    public void testSink() {
        printArry(s);
        sink(s, 1, 2);
        printArry(s);
    }

    @Test
    public void testSort() {
        printArry(a);
        minHeapSort(a, a.length - 1);
        printArry(a);
    }

    private void minHeapSort(int[] a, int hi) {
        for (int i = (hi + 1) / 2; i >= 0; i--) {
            // 从数组中间向前构造堆，若子节点已为堆，将合并
            sink(a, i, hi);
        }
        printArry(a);
        System.out.println("堆构造完成，开始排序。。");
        for (int i = hi; i > 0; i--) {
            swap(a, i, 0);
            sink(a, 0, i - 1);
        }
    }

    /**
     * 将a[k]值在所在堆（a[k],a[2k],a[2k+1]）下沉
     * 小的值下沉
     *
     * @param a
     * @param k  父节点索引
     * @param hi
     */
    private void sink(int[] a, int k, int hi) {
        while ((2 * k + 1) <= hi) { // 子节点存在
            int j = 2 * k + 1;
            if (j < hi && a[j] > a[j + 1]) j++; // 比较子节点的左右节点,找到最小子节点
            if (a[k] < a[j]) break; // 若父节点小于子节点 ， 停止下沉
            swap(a, k, j);
            k = j;  // 父节点小于子节点，两者交换，继续下沉
        }
    }

    private void swap(int[] a, int k, int j) {
        int temp = a[k];
        a[k] = a[j];
        a[j] = temp;
    }

	public void printArry(int[] a) {
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println("\n----------------");
	}

}

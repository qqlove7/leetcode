package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/16.
 * <p/>
 * 冒泡排序.时间复杂度O(n^2)
 * 效率低,n小时使用
 */
public class BubbleSort {

	public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};

	/**
	 * 冒泡排序：每一次将最大值放到最后
	 *
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public void sort(int[] a, int lo, int hi) {
		for (int i = hi; i > lo; i--) {
			for (int j = lo; j < i; j++) {
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

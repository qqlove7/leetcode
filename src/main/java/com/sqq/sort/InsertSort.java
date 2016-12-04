package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/24.
 * 直接插入排序:将有序的数组后的无序的元素依次按规则插入到前面有序的数组中
 */
public class InsertSort {
	public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};

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

	/**
	 * 插入排序
	 * 每次从后面取一个数插入到前面去并排序
	 *
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private void sort(int[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo; j--) {
				if (a[j] < a[j - 1]) swap(a, j, j - 1);
			}
		}
	}

	private void printArry(int[] a) {
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

}

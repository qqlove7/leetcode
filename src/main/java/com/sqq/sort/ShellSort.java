package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/26.
 * 希尔排序,即分组插入排序,又称缩小增量排序
 * 基本思想:先将整个元素序列分割成若干个子序列(由相隔某个增量组成),分别进行插入排序.
 * 然后一次缩减增量再进行排序,直至增量足够小时对全体元素进行插入排序.
 */
public class ShellSort {
	static int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

	@Test
	public void testSort() {
		printArry(a);
		sort(a, 0, a.length - 1);
		printArry(a);
	}

	/**
	 * 按步长分组，组内插入排序
	 *
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private void sort(int[] a, int lo, int hi) {
		for (int step = (hi - lo + 1) / 2; step > 0; step--) {
			for (int i = step * 2; i <= hi; i += step) {
				for (int j = i; j > lo; j -= step) {
					if (a[j] < a[j - step]) swap(a, j, j - step);
				}
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void printArry(int[] a) {
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

}

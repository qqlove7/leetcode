package com.test.sort;

import org.junit.Test;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/13
 * @Description: 快速排序 取一基准数，将数组中比它大的放到右边，小于等于它的放到左边。然后对左边和右边的数组重复这一过程。
 * @CodeReviewer:
 */
public class QuickSort extends BaseUtil {
	int[] a = {2, 8, 7, 1, 3, 5, 6, 4};

	@Test
	public void test() {
		printArray(a);
		System.out.println();
		quickSort(a, 0, a.length - 1);
		printArray(a);
	}

	public void quickSort(int[] a, int lo, int hi) {

	}

	/**
	 * 将a[lo] 作为基准数 ， 小于的放左边，大于的放右边
	 * 返回基准数的位置
	 */
	int getQ(int[] a, int lo, int hi) {
		int v = a[lo];
		int temp;
		int i = lo;
		int j = hi;
		while (i < j) {
			while (a[i] < v) {
				i++;
			}
			while (a[j] > v) {
				j--;
			}
			if (i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return i;
	}

}

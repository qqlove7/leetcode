package com.sqq.sort;

import org.junit.Test;

/**
 * 直接选择排序
 * 将整个数组视为无序队列,每一次对无序队列的循环都将最小元素放到队头并入有序队列
 */
public class SelectSort {
    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};



    /**
     * 选择排序
     *
     * @param a
     * @return
     */
    public static int[] selectSort(int[] a) {
        int temp;
        int time = 1;
        int len = a.length;
        //第一层循环,循环次数为数组长度
        for (int i = 0; i < len; i++) {
            //每一次内循环都会拿a[j]..a[len-1]中数组和a[i]/即第一个数字比较,若比之小则交换
            //循环结束后将将最小的数字放到最前
            for (int j = i; j < len; j++) {
                if (a[i] > a[j]) {
                    /*temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;*/
                    a[i] ^= a[j];
                    a[j] ^= a[i];
                    a[i] ^= a[j];
                }
            }
            System.out.println("第" + (time++) + "次外循环,数组此时为:" + toString(a));
        }
        return a;
    }

    public static void swap(int i, int j) {
        i ^= j ;
        j ^= i ;
        i ^= j;
    }



    @Test
    public void testSort() {
        selectSort(a);
    }

    public static String toString(int[] a) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i : a) {
            stringBuffer.append(i);
            stringBuffer.append(" , ");
        }
        return stringBuffer.toString();
    }

    public void printArry(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}

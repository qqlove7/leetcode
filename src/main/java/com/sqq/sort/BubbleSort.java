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
     * 冒泡排序
     *
     * @param a
     * @return
     */
    public static int[] bubbleSort(int[] a) {
        int temp;
        int time = 1;
        int len = a.length;
        //第一层循环,循环次数为数组长度
        for (int i = 0; i < len; i++) {
            //每一次内循环相邻比较,大数往后交换,都会把a[0]..a[len-i-1]中最大的数字放到a[len-i-1]
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("第" + (time++) + "次外循环,数组此时为:" + toString(a));
        }
        return a;
    }

    /**
     * 冒泡排序优化
     * 设置flag表示是否已经发生交换
     * 若没发生交换说明 排序已完成
     */
    public static int[] bubbleSort2(int[] a) {
        int temp;
        int time = 1;
        int len = a.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < len - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println("第" + (time++) + "次外循环,数组为:" + toString(a));
        }
        return a;
    }

    /**
     * 冒泡排序优化
     * 记下最后发生交换的位置,此位置之后的元素有序
     * 下一次从开始到这个位置排序就好了
     */
    public static int[] bubbleSort3(int[] a) {
        int time = 1;
        int temp ;
        int len;
        int index = a.length - 1;
        while (index > 0) {
            len = index;
            index = 0;
            for (int i = 0; i < len ; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    index = i;
                }
            }
            System.out.println("第" + (time++) + "次外循环,数组为:" + toString(a));
        }
        return a;
    }


    @Test
    public void testSort() {
        System.out.println("  初始数组为:          " + toString(a));
        bubbleSort3(a);
//        bubbleSort3(a);
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

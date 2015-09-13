package com.sqq.sort;

import org.junit.Test;

/**
 * Created by sunqianqian on 2015/3/24.
 * 直接插入排序:将有序的数组后的无序的元素依次按规则插入到前面有序的数组中
 */
public class InsertSort {
    public static int[] a = {3, 7, 5, 2, 10, 9, 4, 6};

    @Test
    public void testSort() {
        System.out.println("  初始数组为:          " + toString(a));
        printArry(insertSort3(a));
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

    /**
     * 插入排序 将有序队列后的元素依次插入到有序队列中
     * @param a
     * @return
     */
    public int[] insertSort(int[] a) {
        int temp, valueTemp;
        //遍历全部数组
        for (int i = 1; i < a.length; i++) {
            //遍历有序队列部分
            for (int j = 0; j < i; j++) {
                //发现有序队列中有一对元素中间刚好放下无序队列的第一个元素
                if (a[i] < a[j]) {
                    //保存将要被插入的元素值
                    valueTemp = a[i];
                    temp = i;
                    //将比插入元素大的有序队列后移一位,腾出位置
                    for (; temp > j; temp--) {
                        a[temp] = a[temp - 1];
                    }
                    //将其插入到腾出位置,形成新的有序队列
                    a[j] = valueTemp;
                }
            }
            System.out.println("外循环结束时:" + toString(a));
        }
        return a;
    }

    /**
     * 直接插入排序优化  将后一个元素与前一个元素(即有序队列尾元素)比较,若比之大则立即包含有序队列中去
     * 否则将其插入到前面的有序队列中.方法为一边比较一遍将数组后移,找到有序队列中比它小的数,插到这个元素的前面.
     *
     * @param a
     * @return
     */
    public int[] insertSort2(int[] a) {
        int temp, j;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                temp = a[i];
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
            System.out.println("外循环结束时:" + toString(a));
        }
        return a;
    }

    /**
     * 直接插入排序 用想前交换代替数组后移,省去保存和插入值的步骤
     */
    public int[] insertSort3(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                temp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = temp;
            }
            System.out.println("外循环结束时:" + toString(a));
        }
        return a;
    }


}

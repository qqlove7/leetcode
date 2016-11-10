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
        System.out.println("  初始数组为:          " + toString(a));
        shellSort(a, 0, a.length - 1);
        printArry(a);
    }

    public void shellSort(int[] a, int lo, int hi) {
        int h = 1;
        // 计算步长序列的最大值
        while (h < (hi + 1) / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            insertSort(a, lo, hi, h);
            h = h / 3; // 缩小步长
        }
    }

    /**
     * 带步长的插入排序
     * 待排序数组为 a[lo] ,a[lo+h],a[lo+2h]..
     *
     * @param a
     * @param lo
     * @param hi
     * @param h
     */
    private void insertSort(int[] a, int lo, int hi, int h) {
        for (int i = lo + h; i <= hi; i += h) {
            insert(a, lo, i, h);
        }
    }

    /**
     * 将a[hi] 插入到a[lo],a[lo+h],a[lo+2h]..a[hi]中
     *
     * @param a
     * @param lo
     * @param hi
     * @param h
     */
    private void insert(int[] a, int lo, int hi, int h) {
        for (int i = hi; i > lo && a[i] < a[i - 1]; i -= h) {
                swap(a, i, i - 1);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

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

    public int[] shellSort(int[] a) {
        int i, j, gap;
        //第一层循环次数为步长递减次数 循环变量为步长
        for (gap = a.length / 2; gap > 0; gap /= 2) {
            //第二层循环次数为分组组数 也即步长 循环变量为组数索引
            for (i = 0; i < gap; i++) {
                //第三次循环次数为分组长度 循环变量为分组内元素索引
                //遍历分组元素,进行插入排序
                for (j = gap + i; j < a.length; j += gap) {
                    //组内元素为a[i],a[gap+i]..
                    if (a[j - gap] > a[j]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
                }
            }
        }
        return a;
    }

    /**
     * 由遍历单个分组 优化为 同时遍历多个数组
     *
     * @param a
     * @return
     */
    public int[] shellSort2(int[] a) {
        int i, gap;
        //循环变量为步长 次数为步长递减次数
        for (gap = a.length / 2; gap > 0; gap /= 2) {
            //从索引为gap的位置开始
            for (i = gap; i < a.length; i++) {
                //分组内进行插入排序:
                //发现不和谐元素,将其插入到分组的之前的有序队列中
                if (a[i - gap] > a[i]) {
                    //保存值
                    int temp = a[i];
                    int  j = i - gap;
                    //就有序队列中比插入值大的元素后移
                    while ( j >= 0 && a[j] > temp ) {
                        a[j + gap] = a[j];
                        j -= gap;
                    }
                    //插入值
                    a[j + gap] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 插入排序中用组内元素交换代替有序队列后移
     */
    public int[] shellSort3(int[] a) {
        int i, j, gap;
        for (gap = a.length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < a.length; i++) {
                for (j = i - gap; j >= 0 && a[j] > a[i]; j -= gap) {
                    int temp = a[j + gap];
                    a[j + gap] = a[j];
                    a[j] = temp;
                }
            }

        }
        return a;
    }
}

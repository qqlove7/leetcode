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

    @Test
    public void testSort() {
        System.out.println(" 堆排序 初始数组为:          " + toString(a));
        makeMinHeap(a,a.length);
//        minHeapSort(a, a.length);
        printArry(a);

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
     * 堆的插入:保证父节点比子节点小.
     */
    //新加入节点i即数组最后一个元素索引a.length-1 父节点为(i-1)/2
    public static void MinHeapFixup(int[] a, int i) {
        int j, temp;
        temp = a[i];
        j = (i - 1) / 2;
        //新插入节点可以视为比较小的值,他的父节点及其祖父节点们应该比他大
        while (j >= 0) {
            //若父节点值小于等于新插入节点值,停止向上比较
            if (a[j] <= temp) {
                break;
            }
            //否则将较大的子节点向下移动,替换它的子节点
            a[i] = a[j];
            i = j;
            j = (i - 1) / 2; //继续向上比较他的父节点
        }
        //当遇到父节点比新节点值小,停止比较,将新节点值赋给其子节点
        a[i] = temp;
    }

    /**
     * 堆插入优化
     */
    public static void minHeapFixup(int[] a, int i) {
        //循环变量
        for (int j = (i - 1) / 2; j >= 0 && a[j] > a[i]; i = j, j = (i - 1) / 2) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * 向最小堆中插入数
     */
    public static void MinHeapAddNode(int[] a, int i, int node) {
        a[i] = node;
        minHeapFixup(a, i);
    }

    /**
     * 堆的删除 : 将最后一个元素值和根节点交换,从上到下调整
     * 调整是在子节点中找最小值,如果父节点比这个最小值还小说明不需要调整了
     * 否则父节点和最小值交换,再考虑以后的节点.
     *
     * @param a 待排序数组
     * @param i 将要被删除的节点 其实是从该节点向其子孙节点比较,让小的数据上升.保证该节点的值是其下面树的最小值.
     * @param n 数组长度
     */
    public static void minHeapFixdown(int[] a, int i, int n) {
        int j, temp;
        temp = a[i];    //key insert a[i+1..n]
        j = 2 * i + 1;  //left child of key
        while (j < n) {
            //在子节点中找出最小值
            if (j + 1 < n && a[j + 1] < a[j]) {     //若下标没越界且左孩子大于右孩子
                j++;            //a[j] 从左节点变为右节点
            }
            //若父节点小于等于子节点中最小值 停止向下比较
            if (a[j] >= temp) {
                break;
            }
            // 否则将父节点值 赋值 给 该子节点
            a[i] = a[j];
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }

    /**
     * 在最小堆删除数
     * 将根节点与数组最后一个节点交换值,再排除最后一个节点对剩余节点重复操作
     */
    public static void MinHeapDeleteNode(int[] a, int i) {
        int temp = a[0];
        a[0] = a[i - 1];
        a[i - 1] = temp;
        minHeapFixdown(a, 0, i - 1);
    }

    /**
     * 堆化数组
     */
    public static void makeMinHeap(int[] a, int i) {
        for (int j = i / 2 - 1; j >= 0; j--) {
            minHeapFixdown(a, j, i);
        }
    }

    /**
     * 堆排序
     */
    public static void minHeapSort(int[] a, int n) {
        //先堆化数组
        makeMinHeap(a, n);
        //将根节点和尾节点交换,堆删除修复,然后排除尾节点,对余下数组重复操作
        for (int i = n - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            minHeapFixdown(a, 0, i);
        }
    }

}

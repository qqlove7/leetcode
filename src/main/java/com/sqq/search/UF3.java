package com.sqq.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 动态连通性 加权quick-union
 * 用数组的值表示连接的下一个触点
 * 根触点的值指向自己
 * 维护节点权重，归并时将小树链接到大树上
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/8
 */
public class UF3 {
	private int[] id; // 分量id
	private int[] sz; // 各节点对应分量大小
	private int count; // 分量数量

	public UF3(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}

	/**
	 * 获取分量数量
	 */
	public int count() {
		return count;
	}

	/**
	 * 获取跟触点所在分量标识
	 */
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	/**
	 * 判断两个触点是否连接
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * 连接两个触点
	 */
	public void union(int p, int q) {
		int pRootID = find(p);
		int qRootID = find(q);

		if (pRootID == qRootID) {
			return;
		}
		if (sz[pRootID] < sz[qRootID]) {// p的根节点权重小于q根节点权重
			id[pRootID] = id[qRootID];
			sz[qRootID] += sz[pRootID];
		} else {    // p 树大于等于 q树
			id[qRootID] = id[pRootID];
			sz[pRootID] += sz[qRootID];
		}
		count--;
	}

	public static void main(String[] args) {
		UF3 uf = new UF3(10);
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] pair = line.split("\\s+");
			if (uf.connected(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]))) {
				System.out.println(line + " 已连通");
			} else {
				System.out.println(line + " 开始连接");
				uf.union(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
			}
			System.out.println("array: " + Arrays.toString(uf.id));
		}
	}
}

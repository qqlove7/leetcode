package com.sqq.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 动态连通性 quick-find
 * 用数组的值表示是否连通
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/8
 */
public class UF {
	private int[] id; // 分量id
	private int count; // 分量数量

	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/**
	 * 获取分量数量
	 */
	public int count() {
		return count;
	}

	/**
	 * 获取触点所在分量标识
	 */
	public int find(int p) {
		return id[p];
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
		int pID = find(p);
		int qID = find(q);

		if (pID == qID) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;
	}

	public static void main(String[] args) {
		UF uf = new UF(10);
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

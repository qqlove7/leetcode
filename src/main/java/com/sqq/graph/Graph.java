package com.sqq.graph;

import java.util.HashSet;

/**
 * desc
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/17
 */
public class Graph {

	private final int V;
	private int E;
	private HashSet[] adj;

	/**
	 * 创建一个含有V各顶点但不含有边的图
	 *
	 * @param V
	 */
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new HashSet[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new HashSet<Integer>();
		}
	}

	/**
	 * 顶点数
	 */
	int V() {
		return V;
	}

	/**
	 * 边条数
	 */
	int E() {
		return E;
	}

	/**
	 * 向图中添加一条边 v-w
	 *
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w) {
		((HashSet<Integer>) adj[v]).add(w);
		((HashSet<Integer>) adj[w]).add(v);
		E++;
	}

	/**
	 * 和v相邻的所有顶点
	 *
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
	}

}

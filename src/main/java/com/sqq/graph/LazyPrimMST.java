package com.sqq.graph;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 最小生成树的算法的延时实现
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/29
 */
public class LazyPrimMST {
	private boolean[] marked; // 最小生成树的顶点
	private HashSet<Edge> mst;  // 最小生成树的边
	private PriorityQueue<Edge> pq; // 横切边（包括失效的边）

	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new PriorityQueue<Edge>();
		marked = new boolean[G.V()];
		mst = new HashSet<Edge>();
		visit(G, 0);
		while (!pq.isEmpty()) {
			Edge e = pq.peek(); // 从pq中得到权重最小的边
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w]) continue; // 跳过失效的边
			mst.add(e);
			if (!marked[v]) visit(G, v);// 将边添加到树中
			if (!marked[w]) visit(G, w);
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		// 标记顶点v并将所有连接v和未被标记顶点的边加入pq
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)]) pq.add(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		double weight = 0L;
		for (Edge edge : mst) {
			weight += edge.weight();
		}
		return weight;
	}

}

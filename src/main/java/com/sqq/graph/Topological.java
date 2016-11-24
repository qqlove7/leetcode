package com.sqq.graph;

/**
 * 拓扑排序
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/24
 */
public class Topological {
	private Iterable<Integer> order; // 顶点的拓扑排序

	public Topological(Digraph G) {
		DirectedCycle cycleFinder = new DirectedCycle(G);
		if (!cycleFinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	/***
	 * 是否有向无环图DAG
	 */
	public boolean isDAG() {
		return order != null;
	}
}

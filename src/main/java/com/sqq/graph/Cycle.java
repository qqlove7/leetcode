package com.sqq.graph;

/**
 * 检测环：   给定的环是无环图吗
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/21
 */
public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G) {
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) dfs(G, s, s);
		}
	}

	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) dfs(G, w, v);
			else if (w != u) hasCycle = true;
		}
	}

	public boolean isHasCycle() {
		return hasCycle;
	}
}

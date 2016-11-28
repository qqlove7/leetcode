package com.sqq.graph;

/**
 * 顶点对的可达性
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/25
 */
public class TransitiveClosure {
	private DirectedDFS[] all;

	TransitiveClosure(Digraph G) {
		all = new DirectedDFS[G.V()];
		for (int v = 0; v < G.V(); v++) {
			all[v] = new DirectedDFS(G, v);
		}
	}

	boolean reachable(int v, int w) {
		return all[v].marked(w);
	}
}

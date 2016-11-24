package com.sqq.graph;

import java.util.HashSet;

/**
 * 有向图的可达性
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/24
 */
public class DirectedDFS {
	private boolean[] marked;

	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for (int s : sources) {
			if (!marked[s]) dfs(G, s);
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) dfs(G, w);
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	// 判断是否可达
	public static void main(String[] args) {
		Digraph G = new Digraph(new Integer(args[0]));
		HashSet sources = new HashSet();
		for (int i = 1; i < args.length; i++) {
			sources.add(Integer.parseInt(args[i]));
		}
		DirectedDFS rechable = new DirectedDFS(G, sources);

		for (int v = 0; v < G.V(); v++) {
			if (rechable.marked(v)) System.out.println(v);
		}
	}

}

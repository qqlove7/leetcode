package com.sqq.graph;

import java.util.HashSet;

/**
 * 有向图
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/24
 */
public class Digraph {
	private final int V;
	private int E;
	private HashSet[] adj;

	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new HashSet[V];
		for (int v = 0; v < V; v++) {
			adj[V] = new HashSet();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v)) {
				R.addEdge(w, v);
			}
		}

        return R;
	}
}

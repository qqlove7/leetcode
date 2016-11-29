package com.sqq.graph;

import java.util.HashSet;

/**
 * 加权有向图的数据类型
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/29
 */
public class EdgeWeightedDigraph {
	private final int V; // 顶点总数
	private int E; // 边的总数
	private HashSet[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new HashSet[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new HashSet<DirectedEdge>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(DirectedEdge edge) {
		adj[edge.from()].add(edge);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		HashSet<DirectedEdge> bag = new HashSet<DirectedEdge>();
		for (int v = 0; v < V; v++) {
			for (Object e : adj[v]) {
				bag.add((DirectedEdge) e);
			}
		}
		return bag;
	}
}

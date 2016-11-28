package com.sqq.graph;

import java.util.HashSet;

/**
 * 加权无向图的数据类型
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/28
 */
public class EdgeWeightedGraph {
	private final int V; // 顶点总数
	private int E; // 边总数
	private HashSet[] adj; // 邻接表

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new HashSet[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new HashSet<Integer>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge edge) {
		int v = edge.either();
		int w = edge.other(v);
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		HashSet<Edge> b = new HashSet<Edge>();
		for (int v = 0; v < V; v++) {
			for (Object e : adj[v]) {
				Edge edge = (Edge) e;
				if (edge.other(v) > v) b.add(edge);
			}
		}
		return b;
	}
}

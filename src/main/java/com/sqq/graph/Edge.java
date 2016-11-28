package com.sqq.graph;

/**
 * 带权重的边的数据类型
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/26
 */
public class Edge implements Comparable<Edge> {
	private final int v; // 顶点之一
	private final int w; // 顶点之二
	private final double weight; // 边的权重

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	// 当两个顶点都是未知时
	public int either() {
		return v;
	}

	// 获取另一个顶点
	public int other(int vertex) {
		if (vertex == v) return w;
		else if (vertex == w) return v;
		else throw new RuntimeException("inconsistent edge");
	}

	public int compareTo(Edge o) {
		if (this.weight() < o.weight()) return -1;
		else if (this.weight() > o.weight()) return 1;
		else return 0;
	}

	@Override
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}

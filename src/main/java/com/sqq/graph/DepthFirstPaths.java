package com.sqq.graph;

import java.util.Stack;

/**
 * desc
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/21
 */
public class DepthFirstPaths {
	// 这个顶点上调用过dfs()了吗
	private boolean[] marked;
	// 从起点到一个顶点的已知路径上的最后一个顶点,结果是以s为根节点的树，edgeTo[w]=v 表示v-w是第一次访问w时经历的边
	private int[] edgeTo;
	// 起点
	private final int s;

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		// 将顶点v标记为以访问
		marked[v] = true;
		// 递归访问邻接顶点并标记
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				// 若邻接顶点没有被标记，在路径数组上记录下来
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	/**
	 * 起点到v之间是否有路径
	 *
	 * @param v
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * 起点到v之间的路径
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}

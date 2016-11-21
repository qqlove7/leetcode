package com.sqq.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * desc
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/21
 */
public class BreadthFirstPaths {
	// 到达该顶点的最短路径已知吗
	private boolean[] marked;
	// 到达该顶点的已知路径上的最后一个顶点
	private int[] edgeTo;
	// 起点
	private final int s;

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true; // 标记起点
		queue.add(s); // 将它加入队列
		while (!queue.isEmpty()) {
			int v = queue.peek();   // 从队列中删去下一顶点
			for (int w : G.adj(v)) {
				if (!marked[w]) { // 对于每个未被标记的相邻顶点
					edgeTo[w] = v; // 保存最短路径的最后一条边
					marked[w] = true; // 标记她，因为最短路径已知
					queue.add(w);   // 并将它添加到队列中
				}
			}
		}
	}

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

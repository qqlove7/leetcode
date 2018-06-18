package com.sqq.graph;

/**
 * 深度优先遍历
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/19
 */
public class DepthFirstSearch {
    // 布尔数组，索引为顶点，值为该顶点是否与起点联通
    private boolean[] marked;
    // 与起点s联通的顶点数
    private int count;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

    /**
     * 深度优先遍历
     *
     * @param G 图
     * @param v 顶点
     */
    private void dfs(Graph G, int v) {
        // 标记该顶点被遍历到
        marked[v] = true;
        count++;
        // 找出邻接顶点中未被遍历过的顶点递归进行
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    // 该顶点是否与起点s联通
    public boolean marked(int w) {
        return marked[w];
    }

    // 与起点s联通的顶点数
    public int count() {
        return count;
    }

}

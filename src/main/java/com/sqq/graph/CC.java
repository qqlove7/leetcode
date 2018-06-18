package com.sqq.graph;

/**
 * 找出一幅图的所有联通分量
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/21
 */
public class CC {
    // 该顶点是否调用过dfs
    private boolean[] marked;
    // 顶点所在的联通分量标识
    private int[] id;
    // 联通分量数
    private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            // 对每个未被标识的顶点，进行深度优先遍历
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) dfs(G, w);
		}
	}

    // v w 是否联通
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    // v所在联通分量标志符
    public int id(int v) {
        return id[v];
    }

	public int count() {
		return count;
	}
}

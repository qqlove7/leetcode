package com.sqq.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 无向图
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/17
 */
public class Graph {

    // 顶点数
    private final int V;
    // 边数
    private int E;
    // 邻接表 索引为顶点，值为相邻的顶点
    private Set[] adj;

    /**
     * 创建一个含有V各顶点但不含有边的图
     *
     * @param V
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<Integer>();
        }
    }

    /**
     * 顶点数
     */
    int V() {
        return V;
    }

    /**
     * 边条数
     */
    int E() {
        return E;
    }

    /**
     * 向图中添加一条边 v-w
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w) {
        ((HashSet<Integer>) adj[v]).add(w);
        ((HashSet<Integer>) adj[w]).add(v);
        E++;
    }


    /**
     * 和v相邻的所有顶点
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v) {
        return (HashSet<Integer>) adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("顶点数：").append(V)
                .append("边数：").append(E);
        for (int i = 0; i < V; i++) {
            sb.append("\n顶点").append(i).append("相邻顶点为：");
            for (Integer v : (HashSet<Integer>) adj[i]) {
                sb.append(v).append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        System.out.println(graph);
    }

}

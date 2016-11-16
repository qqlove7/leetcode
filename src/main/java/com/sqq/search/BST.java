package com.sqq.search;

/**
 * 二叉查找树
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/14
 */
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N; // 以该节点为根的子树中的节点总数

		public Node(Key key, Value val, int n) {
			this.key = key;
			this.val = val;
			N = n;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	public Value get(Key key) {
		return get(key, root);
	}

	private Value get(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x.val;
		else if (cmp < 0) return get(key, x.left);
		else return get(key, x.right);
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(x.left, key, value);
		else if (cmp > 0) x.right = put(x.right, key, value);
		else x.val = value;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Value min() {
		return min(root);
	}

	private Value min(Node x) {
		if (x.left == null) return x.val;
		else return min(x.left);
	}

	Key floor(Key key) {
		Node x = floor(key, root);
		if (x == null) return null;
		return x.key;
	}

	private Node floor(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		else if (cmp < 0) return floor(key, x.left);
		Node t = floor(key, x.right);
		if (t != null) return t;
		else return x;
	}

	/**
	 * 返回排名为k的节点
	 *
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node x, int k) {
		if (x == null) return null;
		int t = size(x.left);
		if (t > k) return select(x.left, k);
		else if (t < k) return select(x.right, k - t - 1);
		else return x;
	}

	/**
	 * 返回以x为根节点的子树中小于x.key的键的数量
	 *
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return rank(key, x.left);
		else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
		else return size(x.left);
	}
}

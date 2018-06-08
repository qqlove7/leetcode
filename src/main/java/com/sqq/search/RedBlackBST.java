package com.sqq.search;

/**
 * 标准动态平衡二叉查找树
 * 1. 红链接均为左链接
 * 2. 没有任何一个节点同时和两条红链接相连
 * 3. 完美黑色平衡，任意空链接到根节点的路径上的黑链接数量相同
 * @Author: qianqian.sun
 * @Date: 2016/11/15
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	public static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;
		boolean color;

		public Node(Key key, Value value, int n, boolean color) {
			this.key = key;
			this.value = value;
			N = n;
			this.color = color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;
	}

	/**
	 * 左旋转
	 *
	 * @param h 指向一个结点，它的右链接为红色
	 * @return 返回旋转后的节点，她的左链接为红色
	 */
	Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + 1 + size(h.right);
		return x;
	}

	Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

    // 节点放置或新增
    public void put(Key key, Value value) {
        root = put(root, key, value);
        // 根节点为黑色
        root.color = BLACK;
    }

	private Node put(Node h, Key key, Value value) {
        // 节点不存在则新建，与父节点链接为红色
		if (h == null) return new Node(key, value, 1, RED);

		int cmp = key.compareTo(h.key);
        // 新节点key小于该节点，向左节点递归新增操作
		if (cmp < 0) h.left = put(h.left, key, value);
            // 若新节点key大于该节点，向右节点递归新增操作
		else if (cmp > 0) h.right = put(h.right, key, value);
            // 若新节点key等于该节点 则更新value
		else h.value = value;

        // 下面进行红黑链接的修正

        // 若该节点右链接为红色 且 左链接不为红色，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        // 若该节点左链接为红色且左节点的左链接也为红色，进行右旋转
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        // 若左右链接都为红色，进行颜色反转
		if (isRed(h.left) && isRed(h.right)) flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
}

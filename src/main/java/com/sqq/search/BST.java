package com.sqq.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 特点：每个节点最多有两个子节点，左子节点小于父节点，又子节点大于父节点
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/14
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        // 索引
        private Key key;
        // 节点的值
        private Value val;
        // 左右子节点
        private Node left, right;
        // 以该节点为根的子树中的节点总数
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }

        @Override
        public String toString() {
            return String.format("(key: %s , value : %s)", key, val);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    // 获取key对应的value
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        // 若查找key相同则返回
        if (cmp == 0) return x.val;
            // 若查找key小于该节点，则向左节点递归查找
        else if (cmp < 0) return get(key, x.left);
            // 若查找key大于该节点，则向右节点递归查找
        else return get(key, x.right);
    }

    // 在索引为key的位置设置值为value，没有则新增
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        // 若还没有节点，创建节点并返回
        if (x == null) return new Node(key, value, 1);
        // 将插入的key与该节点比较
        int cmp = key.compareTo(x.key);
        // 插入的节点较小，与其左子节点继续比较
        if (cmp < 0) x.left = put(x.left, key, value);
            // 插入节点较大，与其右子节点继续比较
        else if (cmp > 0) x.right = put(x.right, key, value);
            // 新插入的Key已经存在，直接设置value
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

    public void invert() {
        invert(root);
    }

    private void invert(Node x) {
        if (null == x) return;
        invert(x.left);
        invert(x.right);
        swap(x);
    }

    private void swap(Node x) {
        Node temp = x.left;
        x.left = x.right;
        x.right = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        List<Node> list = new ArrayList<>();
        list.add(root);
        List<Node> list2 = new ArrayList<>();
        while (!list.isEmpty()) {
            for (Node x : list) {
                sb.append(x.toString());
                if (null != x.left) list2.add(x.left);
                if (null != x.right) list2.add(x.right);
            }
            sb.append("\n--- ----\n");
            list.clear();
            list.addAll(list2);
            list2.clear();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(4, "b");
        bst.put(2, "a");
        bst.put(6, "c");
        bst.put(7, "g");
        bst.put(5, "h");
        bst.put(1, "h");
        bst.put(3, "h");
        System.out.println(bst);
        bst.invert();
        System.out.println("反转二叉树");
        System.out.println(bst);
    }
}

package interview.map;

/**
 * @author zhangran
 * @since 2018-12-23
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }

    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void set(K k, V v) {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }
}

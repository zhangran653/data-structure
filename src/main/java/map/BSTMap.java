package map;

/**
 * @author zhangran
 * @since 2018-06-23
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }


    @Override
    public void add(K k, V v) {

        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            Node n = new Node(k, v);
            size++;
            return n;
        }
        if (k.compareTo(node.key) > 0) {
            node.right = add(node.right, k, v);
        } else if (k.compareTo(node.key) < 0) {
            node.left = add(node.left, k, v);
        } else {
            node.value = v;
        }
        return node;
    }


    private Node minium(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        return minium(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException("key " + k + " doesn't exist");
        }
        node.value = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.right = null;
            this.left = null;
        }

    }


}

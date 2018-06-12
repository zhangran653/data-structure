package bst;

/**
 * @author zhangran
 * @since 2018-06-12
 **/
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;


    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(e, root);
    }

    /**
     * 向以node为根的树中插入元素e，返回插入后新的根
     *
     * @param e
     * @param node
     * @return
     */
    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) < 0) {
            node.left = add(e, node.left);
        } else if (node.e.compareTo(e) > 0) {
            node.right = add(e, node.right);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(e, node.left);
        } else {
            return contains(e, node.right);
        }

    }

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

}

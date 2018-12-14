package interview.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangran
 * @since 2018-12-12
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

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

    public Node add(E e) {
        root = add(root, e);
        return root;
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public Node addNonRecursion(E e) {
        Node node = root;
        while (node != null) {
            if (node.e.equals(e)) {
                break;
            }
            if (e.compareTo(node.e) > 0) {
                if (node.right == null) {
                    node.right = new Node(e);
                    size++;
                    break;
                } else {
                    node = node.right;
                }
            } else if (e.compareTo(node.e) < 0) {
                if (node.left == null) {
                    node.left = new Node(e);
                    size++;
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (e == null || node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 1
     * /  \
     * 2    3
     * / \   / \
     * 4   5 5   6
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return null;
        }
        sb.append(root.e);
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();
        level.add(root.left);
        level.add(root.right);

        while (!(level.stream().filter(c -> c == null).count() == level.size())) {
            for (int i = 0; i < level.size(); i++) {
                Node n = level.get(i);
            }
        }

        return sb.toString();

    }


}

package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        if (e.compareTo(node.e) < 0) {
            node.left = add(e, node.left);
        } else if (e.compareTo(node.e) > 0) {
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
        if (e.compareTo(node.e) < 0) {
            return contains(e, node.left);
        } else {
            return contains(e, node.right);
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

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }


    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("bst is empty");
        }
        Node min = minimum(root);
        return min.e;
    }

    private Node minimum(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("bst is empty");
        }
        Node max = maximum(root);
        return max.e;
    }

    private Node maximum(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的最小值节点
     * 返回删除后的新的根
     *
     * @param node
     * @return
     */
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

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根节点的最大值节点
     * 返回删除后的新的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
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

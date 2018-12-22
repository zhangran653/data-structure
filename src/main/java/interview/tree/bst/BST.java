package interview.tree.bst;

import java.util.*;

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

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
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


    public E min() {
        if (size == 0) {
            throw new IllegalArgumentException("BST empty");
        }
        return min(root).e;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("BST empty");
        }
        return max(root).e;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    public E removeMin() {
        if (size == 0) {
            throw new IllegalArgumentException("BST empty");
        }
        E ret = min();
        root = removeMin(root);
        return ret;
    }

    /**
     * 返回删除最小值节点后的二叉树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;

    }

    public E removeMax() {

        E ret = max();
        root = removeMax(root);
        return ret;
    }

    /**
     * 返回删除最大值节点后的二叉树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;

    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node suc = min(node.right);
            suc.right = removeMin(node.right);
            suc.left = node.left;
            node.right = null;
            node.left = null;
            return suc;
        }

    }

    public Node floor(E e) {
        if (size == 0 || e.compareTo(min()) < 0) {
            return null;
        }
        return floor(root, e);

    }

    private Node floor(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        }
        if (node.e.compareTo(e) > 0) {
            return floor(node.left, e);
        }
        Node temp = floor(node.right, e);
        if (temp != null) {
            return temp;
        }
        return node;

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

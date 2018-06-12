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

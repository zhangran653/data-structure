package list;

/**
 * @author zhangran
 * @since 2018-06-11
 **/
public class LinkedList<E> {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index error");
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = head.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

    }
}

package map;

/**
 * @author zhangran
 * @since 2018-06-23
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
        } else {
            node.value = v;
        }
    }

    @Override
    public V remove(K k) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(k)) {
                break;
            }
            pre = pre.next;
        }
        if (pre != null) {
            Node delNode = pre.next;
            pre.next = pre.next.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
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
        public Node next;

        public Node(K k, V v, Node next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key) {
            this(key, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }


    }
}

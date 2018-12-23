package interview.map;

/**
 * @author zhangran
 * @since 2018-12-23
 **/
public class LiskedListMap<K, V> implements Map<K, V> {


    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }

    }


    @Override
    public void add(K k, V v) {

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
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }
}

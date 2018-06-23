package map;

/**
 * @author zhangran
 * @since 2018-06-23
 **/
public interface Map<K, V> {
    void add(K k, V v);

    V remove(K k);

    V get(K k);

    boolean contains(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();

}

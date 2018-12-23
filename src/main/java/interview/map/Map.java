package interview.map;

/**
 * @author zhangran
 * @since 2018-12-23
 **/
public interface Map<K, V> {
    void add(K k, V v);

    V remove(K k);

    V get(K k);

    void set(K k, V v);

    boolean isEmpty();

    int getSize();

    boolean contains(K k);


}

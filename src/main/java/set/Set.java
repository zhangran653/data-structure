package set;

/**
 * @author zhangran
 * @since 2018-06-22
 **/
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}

package stack;

/**
 * @author zhangran
 * @since 2018-06-07
 **/
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    E pop();

    E peek();

    void push(E e);

}

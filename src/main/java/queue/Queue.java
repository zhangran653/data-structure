package queue;

/**
 * @author zhangran
 * @since 2018-06-07
 **/
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    int getSize();

    boolean isEmpty();

    E getFront();
}

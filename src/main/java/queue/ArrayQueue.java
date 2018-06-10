package queue;

import array.Array;

/**
 * @author zhangran
 * @since 2018-06-10
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayQueue() {
        array = new Array<E>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }
}

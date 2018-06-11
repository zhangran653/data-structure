package stack;

import list.LinkedList;

/**
 * @author zhangran
 * @since 2018-06-11
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<E>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }
}

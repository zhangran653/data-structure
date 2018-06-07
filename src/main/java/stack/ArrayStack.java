package stack;

import array.Array;

/**
 * @author zhangran
 * @since 2018-06-07
 **/
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
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
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.get(i));
            if (i != array.getSize() - 1) {
                s.append(", ");
            }
        }
        s.append("] top");
        return s.toString();
    }
}

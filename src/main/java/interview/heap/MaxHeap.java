package interview.heap;

import array.Array;

/**
 * @author zhangran
 * @since 2018-12-23
 **/
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] e) {
        data = new Array<>(e);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }

    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("size is 0");
        }
        return data.get(0);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have a parent");
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extractMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("heap empty");
        }
        E e = data.get(0);
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }

    public E replace(E e) {
        if (isEmpty()) {
            throw new IllegalArgumentException("heap empty");
        }
        E ret = data.get(0);
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}

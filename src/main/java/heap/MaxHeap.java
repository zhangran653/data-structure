package heap;

import array.Array;

/**
 * @author zhangran
 * @since 2018-06-27
 **/
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);

    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("size is 0");
        }
        return data.get(0);
    }


    public E extractMax() {
        E e = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int i = leftChild(k);
            if (i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) > 0) {
                i = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(i)) >= 0) {
                break;
            }
            data.swap(k, i);
            k = i;
        }
    }

    /**
     * 取出最大元素，并替换成新元素
     */
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }


}

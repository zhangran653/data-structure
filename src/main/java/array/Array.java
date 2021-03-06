package array;

/**
 * @author zhangran
 * @since 2018-06-03
 **/
public class Array<E> {

    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    /**
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(E[] e) {
        data = (E[]) new Object[e.length];
        for (int i = 0; i < e.length; i++) {
            data[i] = e[i];
        }
        size = data.length;
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        data[index] = e;
    }

    public void add(int index, E e) {
        if (size >= data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[1];
        }
        data = newData;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        if (size <= data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void removeElement(int e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("index error");
        }
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Array size : %d, capacity: %d\n", size, data.length));
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {


        Array<Integer> a = new Array(3);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);


        System.out.println(a);


        System.out.println("========");

        a.add(3, 5);

        System.out.println(a);

        a.remove(2);

        System.out.println(a);

        a.remove(1);

        System.out.println(a);


    }
}

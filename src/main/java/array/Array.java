package array;

/**
 * @author zhangran
 * @since 2018-06-03
 **/
public class Array {

    private int[] data;
    private int size;

    public Array() {
        this(10);
    }

    /**
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        this.size = 0;
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

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        return data[index];
    }

    public int set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        return data[index] = e;
    }

    public void add(int index, int e) {
        if (size >= data.length) {
            throw new IllegalArgumentException("Add last failed");
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

    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bound");
        }
        int ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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


        Array a = new Array(10);
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

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
        if (size >= data.length) {
            throw new IllegalArgumentException("Add last failed");
        }
        data[size] = e;
        size++;
    }

    public void insert(int index, int e) {
        if (size >= data.length) {
            throw new IllegalArgumentException("Add last failed");
        }
        if (index > data.length - 1) {
            throw new IllegalArgumentException("index out of bound");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
    }


    public static void main(String[] args) {


        Array a = new Array(10);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);


        for (int score : a.data) {
            System.out.println(score);
        }

        System.out.println("========");

        a.insert(3, 5);
        for (int score : a.data) {
            System.out.println(score);
        }

    }
}

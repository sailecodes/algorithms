package lists.arraylist;

import lists.MyList;
import java.util.Arrays;

/**
 * Implementation of the Java ArrayList data structure
 *
 * Note: Does not allow for null values
 * */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private E[] arr;
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;
    private int removeInd = -1;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.arr = (E[])(new Object[this.capacity]);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        this.arr = (E[])(new Object[capacity]);
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(E[] arr) {
        this.arr = (E[])(new Object[arr.length]);
        this.size = arr.length;
        this.capacity = (this.capacity <= arr.length) ?
                this.capacity * ((arr.length / this.capacity) + 1) :arr.length;

        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        return this.arr[index];
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        if (this.size < this.capacity) { return; }

        this.capacity *= 2;
        E[] temp = (E[])(new Object[this.capacity]);

        System.arraycopy(this.arr, 0, temp, 0, this.size);

        this.arr = temp;
    }

    /**
     * NOTE: The actual function returns a boolean type, but this custom AL allows duplicates.
     * */
    @Override
    public void add(E element) {
        increaseCapacity();

        if (element == null) { throw new NullPointerException(); }

        this.arr[this.size] = element;
        this.size++;
    }

    @Override
    public void add(int index, E element) {
        increaseCapacity();

        if (index < 0 || index > this.size) { throw new IndexOutOfBoundsException(); }
        else if (element == null) { throw new NullPointerException(); }
        else if (index == this.size) {
            this.arr[this.size] = element;
            this.size++;

            return;
        }

        for (int i = this.size - 1; i >= index; i--) { this.arr[i + 1] = this.arr[i]; }

        this.arr[index] = element;
        this.size++;
    }

    @Override
    public E remove(int index) {
        increaseCapacity();

        if (isEmpty()) { return null; }
        else if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        E ret = this.arr[index];

        for (int i = index; i < size; i++) { this.arr[i] = this.arr[i + 1]; }

        this.size--;

        return ret;
    }

    @Override
    public boolean remove(E element) {
        increaseCapacity();

        if (isEmpty()) { return false; }
        else if (element == null) { throw new NullPointerException(); }

        if (contains(element)) {
            for (int i = this.removeInd; i < size; i++) { this.arr[i] = this.arr[i + 1]; }
            this.size--;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(E element) {
        if (isEmpty()) { return false; }
        else if (element == null) { throw new NullPointerException(); }

        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.arr[i])) {
                this.removeInd = i;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.arr = (E[])(new Object[this.capacity]);
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        E[] temp = (E[])(new Object[this.size]);

        System.arraycopy(this.arr, 0, temp, 0, this.size);

        return Arrays.toString(temp);
    }
}

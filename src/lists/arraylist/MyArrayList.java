package lists.arraylist;

import lists.MyList;
import java.util.ArrayList;

public class MyArrayList<E> implements MyList<E> {
    private E[] arr;
    private int size;
    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.arr = (E[])(new Object[this.capacity]);
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        this.arr = (E[])(new Object[capacity]);
        this.size = 0;
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(E[] arr) {
        this.arr = (E[])(new Object[arr.length]);

        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        return this.arr[index];
    }

    /**
     * Doubles the capacity of the list
     * */
    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        if (this.size < capacity) { return; }

        this.capacity *= 2;
        E[] temp = (E[])(new Object[this.capacity]);

        System.arraycopy(this.arr, 0, temp, 0, this.size);

        this.arr = temp;
    }

    @Override
    public boolean add(E element) {
        increaseCapacity();

        if (element == null) { throw new NullPointerException(); }

        this.arr[this.size] = element;
        this.size++;

        return true;
    }

    @Override
    public void add(int index, E element) {
        increaseCapacity();

        if (index < 0 || index > this.size) { throw new IndexOutOfBoundsException(); }
        else if (element == null) { throw new NullPointerException(); }

        if (index == size) { this.arr[this.size] = element; }

        for (int i = this.size - 1; i >= index; i--) { this.arr[i + 1] = this.arr[i]; }

        this.arr[index] = element;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public boolean contains(E element) {
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

    @Override
    public String toString() {
        return super.toString();
    }
}

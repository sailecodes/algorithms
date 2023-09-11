package lists.singlylinkedlist;

import lists.MyList;

/**
 * Implementation of a singly linked list
 *
 * Note: head is abstracted by a sentinel node
 * */
public class MySinglyLinkedList<E> implements MyList<E> {
    class MyNode {
        private E element;
        private MyNode next;

        public MyNode(E element) { this.element = element; }
    }

    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private final MyNode head = new MyNode(null);
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;

    public MySinglyLinkedList() {}

    public MySinglyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public MySinglyLinkedList(E[] arr) {
        MyNode tempNode = this.head;

        for (E element : arr) {
            tempNode.next = new MyNode(element);
            tempNode = tempNode.next;
        }

        this.size = arr.length;
        this.capacity = (arr.length < this.capacity) ? this.capacity :
                this.capacity * ((arr.length / this.capacity) + 1);
    }

    /**
     * Note: Given index is valid, the method should always return a non-null value
     * */
    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        MyNode temp = this.head.next;

        for (int i = 0; i < this.size; i++) {
            if (i == index) { return temp.element; }
            temp = temp.next;
        }

        return null;
    }

    private void increaseCapacity() {
        if (this.size < this.capacity) { return; }

        this.capacity *= 2;
        MyNode temp = this.head;

        for (int i = this.size; i < this.capacity; i++) {
            temp.next = new MyNode(null);
            temp = temp.next;
        }
    }

    /**
     * Prepends the element into the linked list. See MyList.java for original implementation
     * details
     *
     * @param element See MyList.java
     * */
    @Override
    public void add(E element) {
        add(0, element);
    }

    @Override
    public void add(int index, E element) {
        increaseCapacity();

        if (index < 0 || index > this.size) { throw new IndexOutOfBoundsException(); }
        else if (element == null) { throw new NullPointerException(); }

        MyNode temp = this.head;
        MyNode temp2;

        for (int i = 0; i < index; i++) { temp = temp.next; }

        temp2 = temp.next;
        temp.next = new MyNode(element);
        temp.next.next = temp2;
        this.size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        MyNode temp = this.head;

        for (int i = 0; i < index; i++) { temp = temp.next; }

        E ret = temp.next.element;
        temp.next = temp.next.next;
        this.size--;

        return ret;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) { throw new NullPointerException(); }

        MyNode temp = this.head;

        for (int i = 0; i < this.size; i++) {
            if (element.equals(temp.next.element)) {
                temp.next = temp.next.next;
                this.size--;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) { throw new NullPointerException(); }
        else if (isEmpty()) { return false; }

        MyNode temp = this.head.next;

        for (int i = 0; i < this.size; i++) {
            if (element.equals(temp.element)) { return true; }
            temp = temp.next;
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

    @Override
    public void clear() {
        this.head.next = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("[");
        MyNode temp = this.head.next;

        for (int i = 0; i < this.size; i++) {
            ret.append(temp.element + ", ");
            temp = temp.next;
        }

        return ret.substring(0, ret.length() - 2).concat("]");
    }

    /**                            */
    /** For JUnit testing purposes */
    /**                            */

    public int getCapacity() {
        return this.capacity;
    }
}

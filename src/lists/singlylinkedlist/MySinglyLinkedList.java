package lists.singlylinkedlist;

import lists.MyList;

/**
 * Implementation of the Singly Linked List data structure
 *
 * Note: Allows for null values
 * */
public class MySinglyLinkedList<E> implements MyList<E> {
    /**
     * Inner class representing the Node data structure of a Linked List
     * */
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

    public MySinglyLinkedList() {
        MyNode tempNode = this.head;

        for (int i = 0; i < this.capacity; i++) {
            tempNode.next = new MyNode(null);
            tempNode = tempNode.next;
        }
    }

    public MySinglyLinkedList(int capacity) {
        MyNode tempNode = this.head;

        for (int i = 0; i < capacity; i++) {
            tempNode.next = new MyNode(null);
            tempNode = tempNode.next;
        }

        this.capacity = capacity;
    }

    public MySinglyLinkedList(E[] arr) {
        MyNode tempNode = this.head;

        for (E element : arr) {
            tempNode.next = new MyNode(element);
            tempNode = tempNode.next;
        }

        this.size = arr.length;
        this.capacity = (this.capacity <= arr.length) ?
                this.capacity * ((arr.length / this.capacity) + 1) : arr.length;
    }

    /**
     * Note: Given index is valid, the method should always return a non-null value.
     * Runtime: O(n)
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

    /**
     * Runtime: O(n)
     * */
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
        increaseCapacity();
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

    @Override
    public void clear() {
        this.head.next = null;
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
}

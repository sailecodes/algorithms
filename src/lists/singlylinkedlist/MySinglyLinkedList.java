package lists.singlylinkedlist;

import lists.MyList;

/**
 * Implementation of the singly linked list data structure
 *
 * Note: Allows for null values
 * */
public class MySinglyLinkedList<E> implements MyList<E> {
    /**
     * Inner class representing the node data structure of the linked list
     * */
    class MyNode {
        private E element;
        private MyNode next;

        public MyNode(E element) { this.element = element; }
    }

    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private MyNode head = new MyNode(null);
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;

    public MySinglyLinkedList() {
        MyNode tempNode = this.head.next;

        for (int i = 0; i < this.capacity; i++) {
            tempNode.next = new MyNode(null);
            tempNode = tempNode.next;
        }
    }

    public MySinglyLinkedList(int capacity) {
        MyNode tempNode = this.head.next;

        for (int i = 0; i < capacity; i++) {
            tempNode.next = new MyNode(null);
            tempNode = tempNode.next;
        }

        this.capacity = capacity;
    }

    public MySinglyLinkedList(E[] arr) {
        MyNode tempNode = this.head.next;

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
     * */
    @Override
    public E get(int index) {
        MyNode temp = head.next;

        for (int i = 0; i < this.size; i++) {
            if (i == index) { return temp.element; }
            temp = temp.next;
        }

        return null;
    }

    @Override
    public void add(E element) {

    }

    @Override
    public void add(int index, E element) {

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
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }
}

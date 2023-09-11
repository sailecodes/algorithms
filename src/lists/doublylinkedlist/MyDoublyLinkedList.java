package lists.doublylinkedlist;

import lists.MyList;

/**
 * Description: An implementation of a doubly linked list that uses sentinel nodes to abstract the
 *              head and tail.
 * */
public class MyDoublyLinkedList<E> implements MyList<E> {
    /**
     * Inner class representing a node in the list
     * */
    class MyNode {
        /** Instance variables */
        private E element;
        private MyNode next;
        private MyNode previous;

        public MyNode(E element) {
            this.element = element;
        }
    }

    /** Static variables */
    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /** Instance variables */
    private final MyNode head = new MyNode(null);
    private final MyNode tail = new MyNode(null);
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;

    public MyDoublyLinkedList() {
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public MyDoublyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public MyDoublyLinkedList(E[] arr) {
        MyNode lead;
        MyNode follow = this.head;

        for (E element : arr) {
            lead = new MyNode(element);
            follow.next = lead;
            lead.previous = follow;
            follow = lead;
        }

        follow.next = this.tail;
        this.tail.previous = follow;

        this.size = arr.length;
        this.capacity = (arr.length < this.capacity) ? this.capacity :
                this.capacity * ((arr.length / this.capacity) + 1);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }
        else if (index == 0) { return this.head.next.element; }
        else if (index == (this.size - 1)) { return this.tail.previous.element; }

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
        MyNode lead;
        MyNode follow = this.tail.previous;

        for (int i = this.size; i < this.capacity; i++) {
            lead = new MyNode(null);
            follow.next = lead;
            lead.previous = follow;
            follow = lead;
        }
    }

    /**
     * Prepends the element into the list. See MyList.java for original implementation details
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

        MyNode newNode = new MyNode(element);

        if (index == this.size) {
            newNode.previous = this.tail.previous;
            newNode.next = this.tail;
            this.tail.previous.next = newNode;
            this.tail.previous = newNode;
        } else {
            MyNode temp = this.head;

            for (int i = 0; i < index; i++) { temp = temp.next; }

            newNode.next = temp.next;
            newNode.previous = temp;
            temp.next.previous = newNode;
            temp.next = newNode;
        }

        this.size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }

        MyNode temp;
        E ret;

        if (index == (this.size - 1)) {
            temp = this.tail.previous.previous;
            ret = temp.next.element;
            temp.next = this.tail;
            this.tail.previous = temp;
        } else {
            temp = this.head;

            for (int i = 0;  i < index; i++) { temp = temp.next; }

            ret = temp.next.element;
            temp.next = temp.next.next;
            temp.next.previous = temp;
        }

        this.size--;

        return ret;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) { throw new NullPointerException(); }

        MyNode temp = this.head;

        for (int i = 0; i < this.size; i++) {
            if (temp.next.element.equals(element)) {
                temp.next = temp.next.next;
                temp.next.previous = temp;
                this.size--;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) { throw new NullPointerException(); }

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
        this.head.next = this.tail;
        this.tail.previous = this.head;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.size == 0) { return "[]"; }

        StringBuilder ret = new StringBuilder("[");
        MyNode temp = this.head.next;

        for (int i = 0; i < this.size; i++) {
            ret.append(temp.element + ", ");
            temp = temp.next;
        }

        return ret.substring(0, ret.length() - 2).concat("]");
    }

    /** JUnit testing methods */

    public String printForwards() {
        return toString();
    }

    public String printBackwards() {
        StringBuilder ret = new StringBuilder("[");
        MyNode temp = this.tail.previous;

        for (int i = this.size - 1; i >= 0; i--) {
            ret.append(temp.element + ", ");
            temp = temp.previous;
        }

        return ret.substring(0, ret.length() - 2).concat("]");
    }
}

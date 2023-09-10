package lists.doublylinkedlist;

import lists.MyList;

public class MyDoublyLinkedList<E> implements MyList<E> {
    class MyNode {
        private E element;
        private MyNode next;
        private MyNode previous;

        public MyNode(E element) {
            this.element = element;
        }
    }

    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private MyNode head = new MyNode(null);
    private MyNode tail = new MyNode(null);
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;

    public MyDoublyLinkedList() {
        MyNode lead;
        MyNode follow = this.head;

        for (int i = 0; i < this.capacity; i++) {
            lead = new MyNode(null);
            follow.next = lead;
            lead.previous = follow;
            follow = follow.next;
        }

        follow.next = this.tail;
        this.tail.previous = follow;
    }

    public MyDoublyLinkedList(E[] arr) {
        MyNode lead;
        MyNode follow = this.head;

        for (E element : arr) {
            lead = new MyNode(element);
            follow.next = lead;
            lead.previous = follow;
            follow = follow.next;
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
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = new MyNode(null);
        this.tail = new MyNode(null);
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

    public void printDetails() {
        MyNode temp = this.head.next;

        for (int i = 0; i < this.size; i++) {
            System.out.println("Element: (" + temp.element + "), Previous: (" +
                    temp.previous.element + "), Next: (" + temp.next.element + ")");
            temp = temp.next;
        }
    }
}

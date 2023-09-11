package lists.queue;

import lists.MyList;
import lists.doublylinkedlist.MyDoublyLinkedList;

import java.util.NoSuchElementException;

/**
 * Description: An implementation of a Java Queue that uses a custom implementation of a
 *              doubly linked list as the underlying data structure.
 */
public class MyQueue<E> {
    /** Instance variables */
    private MyList<E> mdll = new MyDoublyLinkedList<>();

    public MyQueue() {}

    /**
     * Adds the element to the tail of the queue
     *
     * @param element The element to add
     * @return true if the element does not exceed the capacity restriction, false otherwise
     * */
    public boolean enqueue(E element) {
        this.mdll.add(0, element);
        return true;
    }

    /**
     * Removes the element at the head of the queue
     *
     * @return The element removed from the queue
     * @throws NoSuchElementException The queue is empty
     * */
    public E dequeue() {
        if (this.mdll.isEmpty()) { throw new NoSuchElementException(); }
        return this.mdll.remove(this.mdll.size() - 1);
    }

    /**
     * Gets the element at the head of the queue
     *
     * @return The element at the head of the queue
     * @throws NoSuchElementException The queue is empty
     * */
    public E element() {
        if (this.mdll.isEmpty()) { throw new NoSuchElementException(); }
        return this.mdll.get(this.mdll.size() - 1);
    }

    /**
     * Gets the element at the head of the queue
     *
     * @return The element at the head of the queue
     * */
    public E peek() {
        if (this.mdll.isEmpty()) { return null; }
        return this.mdll.get(this.mdll.size() - 1);
    }

    /**
     * Removes the element at the head of the queue
     *
     * @return The element removed from the queue
     * */
    public E poll() {
        if (this.mdll.isEmpty()) { return null; }
        return this.mdll.remove(this.mdll.size() - 1);
    }

    @Override
    public String toString() {
        return this.mdll.toString();
    }
}

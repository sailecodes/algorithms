package lists.stack;

import lists.MyList;
import lists.doublylinkedlist.MyDoublyLinkedList;

import java.util.EmptyStackException;

/**
 * Description: An implementation of the Java Stack that uses a custom implementation of a
 *              doubly linked list as the underlying data structure.
 * */
public class MyStack<E> {
    /** Instance variables */
    private final MyList<E> mdll = new MyDoublyLinkedList<>();

    public MyStack() {}

    /**
     * Adds the element to the top of the stack
     *
     * @param element The element to add
     * @return The element added
     * */
    public E push(E element) {
        this.mdll.add(0, element);
        return element;
    }

    /**
     * Removes the element from the top of the stack
     *
     * @return The element at the top of the stack
     * @throws EmptyStackException Stack is empty
     * */
    public E pop() {
        if (empty()) { throw new EmptyStackException(); }
        return this.mdll.remove(0);
    }

    /**
     * Gets the element at the top of the stack
     *
     * @return The element at the top of the stack
     * @throws EmptyStackException Stack is empty
     * */
    public E peek() {
        if (empty()) { throw new EmptyStackException(); }
        return this.mdll.get(0);
    }

    /**
     * Gets the number of elements in the stack
     *
     * @return The number of elements in the stack
     * */
    public int size() {
        return this.mdll.size();
    }

    /**
     * Checks if the stack is empty
     *
     * @return true if the stack is empty, false otherwise
     * */
    public boolean empty() {
        return this.mdll.isEmpty();
    }

    @Override
    public String toString() {
        return this.mdll.toString();
    }
}

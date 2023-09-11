package lists.stack;

import lists.MyList;
import lists.doublylinkedlist.MyDoublyLinkedList;

public class MyStack<E> extends MyDoublyLinkedList<E> {
    private final MyList<E> mdll = new MyDoublyLinkedList<>();

    public MyStack() {}

    public E push(E element) {
        this.mdll.add(0, element);
        return element;
    }

    public E pop() {
        return this.mdll.remove(0);
    }

    public E peek() {
        return this.mdll.get(0);
    }

    public int size() {
        return this.mdll.size();
    }

    public boolean empty() {
        return this.mdll.isEmpty();
    }

    public void clear() {
        this.mdll.clear();
    }

    @Override
    public String toString() {
        return this.mdll.toString();
    }

    /**                            */
    /** For JUnit testing purposes */
    /**                            */

    @SuppressWarnings("unchecked")
    @Override
    public void printDetails() {
        ((MyDoublyLinkedList<Integer>)this.mdll).printDetails();
    }
}

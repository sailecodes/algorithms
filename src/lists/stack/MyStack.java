package lists.stack;

import lists.MyList;
import lists.doublylinkedlist.MyDoublyLinkedList;

public class MyStack<E> extends MyDoublyLinkedList<E> {
    private final MyList<E> mal = new MyDoublyLinkedList<>();

    public MyStack() {}

    public E push(E element) {
        this.mal.add(this.mal.size(), element);
        return element;
    }

    public E pop() {
        return this.mal.remove(this.mal.size() - 1);
    }

    public E peek() {
        return this.mal.get(this.mal.size() - 1);
    }

    public int size() {
        return this.mal.size();
    }

    public boolean empty() {
        return this.mal.isEmpty();
    }

    public void clear() {
        this.mal.clear();
    }

    @Override
    public String toString() {
        return this.mal.toString();
    }
}

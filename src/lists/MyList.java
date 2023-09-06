package lists;

public interface MyList <E> {
    /**
     * Gets the element at the specified index
     * */
    E get(int index);
    boolean add(E element);
    void add(int index, E element);
    E remove(int index);
    boolean remove(E element);
    boolean contains(E element);
    boolean isEmpty();
    int size();
    void clear();
}

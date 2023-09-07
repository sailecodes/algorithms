package lists;

public interface MyList <E> {
    /**
     * Gets the element at the specified index
     *
     * @param index The index at which to get the element
     * @return The element at the specified index
     * */
    E get(int index);

    /**
     * Appends an element
     *
     * @param element The element to append
     * @return true if appending is successful, false otherwise
     * */
    boolean add(E element);

    /**
     * Inserts an element at the specified index
     *
     * @param index The index at which to insert the element
     * @param element The element to insert
     * */
    void add(int index, E element);

    /**
     * Removes the element at the specified index
     *
     * @param index The index at which to remove an element
     * @return The element removed
     */
    E remove(int index);

    /**
     * Removes the first occurrence of the specified element
     *
     * @param element The element to remove
     * @return true if the element is removed, false otherwise
     * */
    boolean remove(E element);

    /**
     * Searches the list for the specified element
     *
     * @param element The element to search for
     * @return true if the element exists in the list, false otherwise
     * */
    boolean contains(E element);

    /**
     * Determines whether the list is empty
     *
     * @return true if the list empty, false otherwise
     * */
    boolean isEmpty();

    /**
     * Returns the size of the list
     *
     * @return The size of the list
     * */
    int size();

    /**
     * Clears the list of all elements
     * */
    void clear();
}

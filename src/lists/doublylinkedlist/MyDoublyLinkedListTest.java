package lists.doublylinkedlist;

import lists.MyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {
    MyList<Integer> mdll;

    @BeforeEach
    void init() {
        this.mdll = new MyDoublyLinkedList<>();
    }

    @AfterEach
    void clean() {
        this.mdll.clear();
    }

    @Test
    @DisplayName("Tests MyDoublyLinkedListTest(E[] arr)")
    void defaultConstructor() {
        this.mdll = new MyDoublyLinkedList<>(new Integer[] {1,2,3,4,5});

        assertEquals("[1, 2, 3, 4, 5]", ((MyDoublyLinkedList<Integer>)this.mdll).printForwards());
        assertEquals("[5, 4, 3, 2, 1]", ((MyDoublyLinkedList<Integer>)this.mdll).printBackwards());
    }

    @Test
    @DisplayName("Tests get() with valid and invalid args")
    void get() {
        this.mdll = new MyDoublyLinkedList<>(new Integer[] {1,2,3,4,5});

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.get(5)),
                () -> assertEquals(1, this.mdll.get(0)),
                () -> assertEquals(5, this.mdll.get(4)),
                () -> assertEquals(4, this.mdll.get(3))
        );
    }

    @Test
    @DisplayName("Tests add() with valid and invalid args")
    void add() {
        this.mdll.add(4);
        this.mdll.add(3);
        this.mdll.add(0, 1);
        this.mdll.add(1, 2);
        this.mdll.add(4, 5);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.add(-1, 5)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.add(6, 5)),
                () -> assertThrows(NullPointerException.class, () -> this.mdll.add(null)),
                () -> assertThrows(NullPointerException.class, () -> this.mdll.add(2, null)),
                () -> assertEquals("[1, 2, 3, 4, 5]", this.mdll.toString())
        );
    }

    @Test
    @DisplayName("Tests remove(int index) with valid and invalid args")
    void remove() {
        this.mdll = new MyDoublyLinkedList<>(new Integer[] {1,2,3,4,5});

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.remove(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mdll.remove(5)),
                () -> assertEquals(1, this.mdll.remove(0)),
                () -> assertEquals("[2, 3, 4, 5]", this.mdll.toString()),
                () -> assertEquals(5, this.mdll.remove(3)),
                () -> assertEquals("[2, 3, 4]", this.mdll.toString()),
                () -> assertEquals(3, this.mdll.remove(1)),
                () -> assertEquals("[2, 4]", this.mdll.toString())
        );
    }
}
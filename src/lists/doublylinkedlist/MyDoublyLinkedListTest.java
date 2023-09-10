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
}
package lists.singlylinkedlist;

import lists.MyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySinglyLinkedListTest {
    private MyList<Integer> mal;

    @BeforeEach
    void init() {
        this.mal = new MySinglyLinkedList<>();
    }

    @AfterEach
    void clean() {
        this.mal.clear();
    }

    @Test
    @DisplayName("Tests get() with valid and invalid args (Note: assumes add() functions properly")
    void get() {
        for (int i = 0; i < 3; i++) { mal.add(i); }

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.get(3)),
                () -> assertEquals(2, this.mal.get(0)),
                () -> assertEquals(0, this.mal.get(2))
        );
    }

    @Test
    @DisplayName("Tests add() with valid and invalid args")
    void add() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(-1, 5)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(1, 5)),
                () -> assertThrows(NullPointerException.class, () -> mal.add(0, null))
        );

        mal.add(3);
        mal.add(2);
        mal.add(2, 4);
        mal.add(0, 1);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(5, 5)),
                () -> assertEquals("[1, 2, 3, 4]", mal.toString())
        );
    }

    @Test
    @DisplayName("Tests remove(int index) for valid and invalid args")
    void remove_1() {
        for (int i = 0; i < 6; i++) { mal.add(i); }

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.remove(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.remove(6)),
                () -> assertEquals(5, mal.remove(0)),
                () -> assertEquals("[4, 3, 2, 1, 0]", mal.toString()),
                () -> assertEquals(0, mal.remove(4)),
                () -> assertEquals("[4, 3, 2, 1]", mal.toString()),
                () -> assertEquals(2, mal.remove(2)),
                () -> assertEquals("[4, 3, 1]", mal.toString())
        );
    }

    @Test
    @DisplayName("Tests contains() for valid and invalid args")
    void contains() {
        assertFalse(mal.contains(1));

        for (int i = 0; i < 3; i++) { mal.add(i); }

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> mal.contains(null)),
                () -> assertFalse(mal.contains(5)),
                () -> assertTrue(mal.contains(0)),
                () -> assertTrue(mal.contains(1)),
                () -> assertTrue(mal.contains(2))
        );
    }

    @Test
    @DisplayName("Tests isEmpty()")
    void isEmpty() {
        assertTrue(mal.isEmpty());
    }

    @Test
    @DisplayName("Tests size()")
    void size() {
        assertEquals(0, mal.size());

        for (int i = 0; i < 15; i++) { mal.add(i); }

        assertEquals(15, mal.size());
    }

    @Test
    @DisplayName("Tests clear()")
    void clear() {
        for (int i = 0; i < 15; i++) { mal.add(i); }

        mal.clear();

        assertTrue(mal.isEmpty());
    }

    @Test
    @DisplayName("Tests increaseCapacity()")
    void increaseCapacity() {
        assertEquals(((MySinglyLinkedList<Integer>)mal).getCapacity(), 10);

        for (int i = 0; i < 12; i++) { mal.add(i); }

        assertEquals(((MySinglyLinkedList<Integer>)mal).getCapacity(), 20);
    }
}
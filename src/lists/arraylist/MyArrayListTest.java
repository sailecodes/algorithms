package lists.arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<Integer> mal;

    @BeforeEach
    void init() {
        mal = new MyArrayList<>();
    }

    @AfterEach
    void reinit() {
        mal.clear();
        mal = new MyArrayList<>();
    }

    @AfterEach

    @Test
    @DisplayName("Tests get() with an empty MyArrayList")
    void get_1() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(0))
        );
    }

    @Test
    @DisplayName("Tests get() with a nonempty MyArrayList")
    void get_2() {
        mal.add(50);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(1)),
                () -> assertDoesNotThrow(() -> mal.get(0))
        );
    }

    @Test
    @DisplayName("Tests add(), size(), and isEmpty()")
    void add_size_isEmpty() {
        assertAll(
                () -> assertEquals(mal.size(), 0),
                () -> assertTrue(mal.isEmpty())
        );

        mal.add(50);

        assertAll(
                () -> assertEquals(mal.size(), 1),
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(mal.get(0), 50)
        );

        mal.add(1, 100);
        mal.add(200);
        mal.add(0, 25);

        assertAll(
                () -> assertEquals(mal.size(), 3),
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(mal.get(0), 25),
                () -> assertEquals(mal.get(1), 100),
                () -> assertEquals(mal.get(2), 200)
        );
    }

    @Test
    @DisplayName("Tests add(int index, E element)")
    void add_2() {
        mal.add(0, 50);

        assertAll(
                () -> assertEquals(mal.get(0), 50)
        );
    }
}
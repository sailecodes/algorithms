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
    void clean() {
        mal.clear();
        mal = new MyArrayList<>();
    }

    @Test
    @DisplayName("Tests get() with an empty MyArrayList for invalid args")
    void get_1() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(-1), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(0), "2")
        );
    }

    @Test
    @DisplayName("Tests get() with a nonempty MyArrayList for valid and invalid args")
    void get_2() {
        mal.add(50);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(-1), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(1), "2"),
                () -> assertDoesNotThrow(() -> mal.get(0), "3")
        );
    }

    @Test
    @DisplayName("Tests add() for valid args")
    void add_1() {
        mal.add(50);

        assertAll(
                () -> assertEquals(mal.get(0), 50, "1"),
                () -> assertEquals(mal.toString(), "[50]", "2")
        );

        mal.add(1, 100);
        mal.add(200);
        mal.add(0, 25);

        assertAll(
                () -> assertEquals(mal.get(0), 25, "3"),
                () -> assertEquals(mal.get(1), 50, "4"),
                () -> assertEquals(mal.get(2), 100, "5"),
                () -> assertEquals(mal.toString(), "[25, 50, 100, 200]", "6")
        );

        mal.add(2, 75);
        mal.add(60);
        mal.add(mal.size(), 500);

        assertEquals(mal.toString(), "[25, 50, 75, 100, 200, 60, 500]", "7");
    }

    @Test
    @DisplayName("Tests add() for invalid args")
    void add_2() {
        mal.add(0, 50);
        mal.add(100);
        mal.add(1, 75);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> mal.add(null), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(-1, 200), "2"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(4, 200), "3"),
                () -> assertThrows(NullPointerException.class, () -> mal.add(3, null), "4"),
                () -> assertEquals(mal.toString(), "[50, 75, 100]", "5")
        );
    }

    @Test
    @DisplayName("Tests remove() for valid args")
    void remove_1() {
        mal.add(50);
        mal.add(100);
        mal.add(200);
        mal.add(400);
        mal.add(800);
        mal.add(1600);
        mal.add(3200);
        mal.add(6400);

        assertAll(
                () -> assertEquals(mal.remove(0), 50, "1"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600, 3200, 6400]", "2"),
                () -> assertTrue(mal.remove(Integer.valueOf(6400)), "3"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600, 3200]", "4"),
                () -> assertEquals(mal.remove(5), 3200, "5"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600]", "6"),
                () -> assertTrue(mal.remove(Integer.valueOf(100)), "7"),
                () -> assertEquals(mal.toString(), "[200, 400, 800, 1600]", "8"),
                () -> assertEquals(mal.remove(1), 400, "9"),
                () -> assertEquals(mal.toString(), "[200, 800, 1600]", "10"),
                () -> assertTrue(mal.remove(Integer.valueOf(800)), "11"),
                () -> assertEquals(mal.toString(), "[200, 1600]", "12")
        );
    }

    @Test
    @DisplayName("Tests contains() for valid and invalid args")
    void contains() {
        assertFalse(mal.contains(50));

        mal.add(50);
        mal.add(100);
        mal.add(200);

        assertAll(
                () -> assertTrue(mal.contains(50), "1"),
                () -> assertTrue(mal.contains(200), "2"),
                () -> assertFalse(mal.contains(10), "3"),
                () -> assertThrows(NullPointerException.class, () -> mal.contains(null), "4")
        );
    }

    @Test
    @DisplayName("Tests isEmpty()")
    void isEmpty() {
        assertTrue(mal.isEmpty(), "1");

        mal.add(50);

        assertFalse(mal.isEmpty(), "2");
    }

    @Test
    @DisplayName("Tests size()")
    void size() {
        assertEquals(mal.size(), 0, "1");

        mal.add(50);
        mal.add(100);
        mal.add(200);

        assertEquals(mal.size(), 3, "2");
    }

    @Test
    @DisplayName("Tests clear()")
    void clear() {
        mal.add(50);
        mal.add(100);
        mal.add(200);
        mal.clear();

        assertTrue(mal.isEmpty(), "1");
    }
}
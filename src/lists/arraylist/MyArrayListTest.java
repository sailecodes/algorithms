package lists.arraylist;

import lists.MyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyList<Integer> mal;

    @BeforeEach
    void init() {
        this.mal = new MyArrayList<>();
    }

    @AfterEach
    void clean() {
        this.mal.clear();
        this.mal = new MyArrayList<>();
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
                () -> assertDoesNotThrow(() -> mal.get(0), "1"),
                () -> assertEquals(mal.get(0), 50, "2")
        );

        mal.add(100);
        mal.add(200);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.get(3), "3"),
                () -> assertEquals(mal.get(1), 100, "4"),
                () -> assertEquals(mal.get(2), 200, "5")
        );
    }

    @Test
    @DisplayName("Tests add() for valid and invalid args")
    void add() {
        mal.add(50);
        mal.add(1, 100);
        mal.add(200);
        mal.add(0, 25);

        assertEquals(mal.toString(), "[25, 50, 100, 200]", "1");

        mal.add(2, 75);
        mal.add(60);
        mal.add(mal.size(), 500);

        assertEquals(mal.toString(), "[25, 50, 75, 100, 200, 60, 500]", "2");
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> mal.add(null), "3"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(-1, 200), "4"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.add(8, 200), "5"),
                () -> assertThrows(NullPointerException.class, () -> mal.add(3, null), "6")
        );
    }

    // TODO: Change to for-loop
    @Test
    @DisplayName("Tests remove(int index) for valid and invalid args")
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
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.remove(-1), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> mal.remove(8), "2"),
                () -> assertEquals(mal.remove(0), 50, "3"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600, 3200, 6400]", "4"),
                () -> assertTrue(mal.remove(Integer.valueOf(6400)), "5"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600, 3200]", "6"),
                () -> assertEquals(mal.remove(5), 3200, "7"),
                () -> assertEquals(mal.toString(), "[100, 200, 400, 800, 1600]", "8"),
                () -> assertTrue(mal.remove(Integer.valueOf(100)), "9"),
                () -> assertEquals(mal.toString(), "[200, 400, 800, 1600]", "10"),
                () -> assertEquals(mal.remove(1), 400, "11"),
                () -> assertEquals(mal.toString(), "[200, 800, 1600]", "12"),
                () -> assertTrue(mal.remove(Integer.valueOf(800)), "13"),
                () -> assertEquals(mal.toString(), "[200, 1600]", "14")
        );
    }

    @Test
    @DisplayName("Tests remove(E element) for valid and invalid args")
    void remove_2() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> mal.remove(null), "1"),
                () -> assertFalse(mal.remove(Integer.valueOf(50)), "2")
        );

        for (int i = 0; i < 5; i++) { mal.add(i); }

        assertAll(
                () -> assertTrue(mal.remove(Integer.valueOf(0)), "3"),
                () -> assertEquals(mal.toString(), "[1, 2, 3, 4]", "4"),
                () -> assertTrue(mal.remove(Integer.valueOf(4)), "5"),
                () -> assertEquals(mal.toString(), "[1, 2, 3]", "6"),
                () -> assertTrue(mal.remove(Integer.valueOf(2)), "7"),
                () -> assertEquals(mal.toString(), "[1, 3]", "8")
        );
    }

    @Test
    @DisplayName("Tests contains() for valid and invalid args")
    void contains() {
        assertAll(
                () -> assertFalse(mal.contains(50), "1"),
                () -> assertThrows(NullPointerException.class, () -> mal.contains(null), "2")
        );

        for (int i = 0; i < 3; i++) { mal.add(i); }

        assertAll(
                () -> assertTrue(mal.contains(2), "3"),
                () -> assertTrue(mal.contains(1), "4"),
                () -> assertFalse(mal.contains(3), "5")
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

        for (int i = 0; i < 3; i++) { mal.add(i); }

        assertEquals(mal.size(), 3, "2");
    }

    @Test
    @DisplayName("Tests clear()")
    void clear() {
        for (int i = 0; i < 3; i++) { mal.add(i); }

        mal.clear();

        assertTrue(mal.isEmpty(), "1");
    }

    @Test
    @DisplayName("Tests that the capacity increases twofold when size == capacity")
    void increaseCapacity() {
        assertEquals(((MyArrayList<Integer>)(mal)).getCapacity(), 10);

        for (int i = 0; i < 11; i++) { mal.add(i); }

        assertEquals(((MyArrayList<Integer>)(mal)).getCapacity(), 20);
    }
}
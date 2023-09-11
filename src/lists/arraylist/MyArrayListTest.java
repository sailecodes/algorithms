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
        this.mal = new MyArrayList<>();
    }

    @Test
    @DisplayName("Tests get() with an empty MyArrayList for invalid args")
    void get_1() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.get(-1), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.get(0), "2")
        );
    }

    @Test
    @DisplayName("Tests get() with a nonempty MyArrayList for valid and invalid args")
    void get_2() {
        this.mal.add(50);

        assertAll(
                () -> assertDoesNotThrow(() -> this.mal.get(0), "1"),
                () -> assertEquals(this.mal.get(0), 50, "2")
        );

        this.mal.add(100);
        this.mal.add(200);

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.get(3), "3"),
                () -> assertEquals(this.mal.get(1), 100, "4"),
                () -> assertEquals(this.mal.get(2), 200, "5")
        );
    }

    @Test
    @DisplayName("Tests add() for valid and invalid args")
    void add() {
        this.mal.add(50);
        this.mal.add(1, 100);
        this.mal.add(200);
        this.mal.add(0, 25);

        assertEquals(this.mal.toString(), "[25, 50, 100, 200]", "1");

        this.mal.add(2, 75);
        this.mal.add(60);
        this.mal.add(this.mal.size(), 500);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> this.mal.add(null), "3"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.add(-1, 200), "4"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.add(8, 200), "5"),
                () -> assertThrows(NullPointerException.class, () -> this.mal.add(3, null), "6"),
                () -> assertEquals(this.mal.toString(), "[25, 50, 75, 100, 200, 60, 500]", "2")
        );
    }

    // TODO: Change to for-loop
    @Test
    @DisplayName("Tests remove(int index) for valid and invalid args")
    void remove_1() {
        for (int i = 50; i <= 6400 ; i *= 2) { this.mal.add(i); }

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.remove(-1), "1"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.mal.remove(8), "2"),
                () -> assertEquals(this.mal.remove(0), 50, "3"),
                () -> assertEquals(this.mal.toString(), "[100, 200, 400, 800, 1600, 3200, 6400]", "4"),
                () -> assertTrue(this.mal.remove(Integer.valueOf(6400)), "5"),
                () -> assertEquals(this.mal.toString(), "[100, 200, 400, 800, 1600, 3200]", "6"),
                () -> assertEquals(this.mal.remove(5), 3200, "7"),
                () -> assertEquals(this.mal.toString(), "[100, 200, 400, 800, 1600]", "8"),
                () -> assertTrue(this.mal.remove(Integer.valueOf(100)), "9"),
                () -> assertEquals(this.mal.toString(), "[200, 400, 800, 1600]", "10"),
                () -> assertEquals(this.mal.remove(1), 400, "11"),
                () -> assertEquals(this.mal.toString(), "[200, 800, 1600]", "12"),
                () -> assertTrue(this.mal.remove(Integer.valueOf(800)), "13"),
                () -> assertEquals(this.mal.toString(), "[200, 1600]", "14")
        );
    }

    @Test
    @DisplayName("Tests remove(E element) for valid and invalid args")
    void remove_2() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> this.mal.remove(null), "1"),
                () -> assertFalse(this.mal.remove(Integer.valueOf(50)), "2")
        );

        for (int i = 0; i < 5; i++) { this.mal.add(i); }

        assertAll(
                () -> assertTrue(this.mal.remove(Integer.valueOf(0)), "3"),
                () -> assertEquals(this.mal.toString(), "[1, 2, 3, 4]", "4"),
                () -> assertTrue(this.mal.remove(Integer.valueOf(4)), "5"),
                () -> assertEquals(this.mal.toString(), "[1, 2, 3]", "6"),
                () -> assertTrue(this.mal.remove(Integer.valueOf(2)), "7"),
                () -> assertEquals(this.mal.toString(), "[1, 3]", "8")
        );
    }

    @Test
    @DisplayName("Tests contains() for valid and invalid args")
    void contains() {
        assertAll(
                () -> assertFalse(this.mal.contains(50), "1"),
                () -> assertThrows(NullPointerException.class, () -> this.mal.contains(null), "2")
        );

        for (int i = 0; i < 3; i++) { this.mal.add(i); }

        assertAll(
                () -> assertTrue(this.mal.contains(2), "3"),
                () -> assertTrue(this.mal.contains(1), "4"),
                () -> assertFalse(this.mal.contains(3), "5")
        );
    }

    @Test
    @DisplayName("Tests isEmpty()")
    void isEmpty() {
        assertTrue(this.mal.isEmpty(), "1");

        this.mal.add(50);

        assertFalse(this.mal.isEmpty(), "2");
    }

    @Test
    @DisplayName("Tests size()")
    void size() {
        assertEquals(this.mal.size(), 0, "1");

        for (int i = 0; i < 3; i++) { this.mal.add(i); }

        assertEquals(this.mal.size(), 3, "2");
    }

    @Test
    @DisplayName("Tests clear()")
    void clear() {
        for (int i = 0; i < 3; i++) { this.mal.add(i); }

        this.mal.clear();

        assertTrue(this.mal.isEmpty(), "1");
    }

    @Test
    @DisplayName("Tests that the capacity increases twofold when size == capacity")
    void increaseCapacity() {
        assertEquals(((MyArrayList<Integer>)(this.mal)).getCapacity(), 10);

        for (int i = 0; i < 11; i++) { this.mal.add(i); }

        assertEquals(((MyArrayList<Integer>)(this.mal)).getCapacity(), 20);
    }
}
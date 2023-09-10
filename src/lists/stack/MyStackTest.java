package lists.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<Integer> ms;

    @BeforeEach
    void init() {
        this.ms = new MyStack<>();
    }

    @AfterEach
    void clean() {
        this.ms.clear();
    }

    @Test
    @DisplayName("Tests push() for valid and invalid args")
    void push() {
        for (int i = 0; i < 5; i++) { this.ms.push(i); }

        assertThrows(NullPointerException.class, () -> this.ms.push(null));
        assertEquals("[0, 1, 2, 3, 4]", this.ms.toString());
    }

    @Test
    @DisplayName("Tests pop() for valid and invalid args")
    void pop() {
        for (int i = 0; i < 3; i++) { this.ms.push(i); }

        assertAll(
                () -> assertEquals(2, this.ms.pop()),
                () -> assertEquals("[0, 1]", this.ms.toString()),
                () -> assertEquals(1, this.ms.pop()),
                () -> assertEquals("[0]", this.ms.toString()),
                () -> assertEquals(0, this.ms.pop()),
                () -> assertEquals("[]", this.ms.toString())
        );
    }

    @Test
    @DisplayName("Tests peek() for valid and invalid args")
    void peek() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.ms.peek());

        for (int i = 0; i < 2; i++) { this.ms.push(i); }

        assertEquals(1, this.ms.peek());
    }

    @Test
    @DisplayName("Tests empty()")
    void empty() {
        assertTrue(this.ms.empty());

        this.ms.push(1);

        assertFalse(this.ms.empty());
    }

    @Test
    @DisplayName("Tests clear()")
    void clear() {
        for (int i = 0; i < 3; i++) { this.ms.push(i); }

        assertEquals(3, this.ms.size());

        this.ms.clear();

        assertEquals(0, this.ms.size());
    }
}
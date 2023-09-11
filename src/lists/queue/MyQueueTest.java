package lists.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    MyQueue<Integer> mq;

    @BeforeEach
    void init() {
        mq = new MyQueue<>();
    }

    @AfterEach
    void clean() {
        mq = new MyQueue<>();
    }

    @Test
    @DisplayName("Tests enqueue() for valid and invalid args")
    void enqueue() {
        for (int i = 0; i < 5; i++) { this.mq.enqueue(i); }

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> this.mq.enqueue(null)),
                () -> assertEquals("[4, 3, 2, 1, 0]", this.mq.toString())
        );
    }

    @Test
    @DisplayName("Tests dequeu() for valid and invalid args")
    void dequeue() {
        assertThrows(NoSuchElementException.class, () -> this.mq.dequeue());

        for (int i = 0; i < 3; i++) { this.mq.enqueue(i); }

        assertAll(
                () -> assertEquals(0, this.mq.dequeue()),
                () -> assertEquals("[2, 1]", this.mq.toString()),
                () -> assertEquals(1, this.mq.dequeue()),
                () -> assertEquals("[2]", this.mq.toString()),
                () -> assertEquals(2, this.mq.dequeue()),
                () -> assertEquals("[]", this.mq.toString())
        );
    }

    @Test
    @DisplayName("Tests element() for valid and invalid args")
    void element() {
        assertThrows(NoSuchElementException.class, () -> this.mq.dequeue());

        for (int i = 0; i < 3; i++) { this.mq.enqueue(i); }

        assertAll(
                () -> assertEquals(0, this.mq.element()),
                () -> assertEquals("[2, 1, 0]", this.mq.toString())
        );

        this.mq.dequeue();

        assertEquals(1, this.mq.element());
    }

    @Test
    @DisplayName("Tests peek() for valid and invalid args")
    void peek() {
        assertNull(this.mq.peek());

        for (int i = 0; i < 3; i++) { this.mq.enqueue(i); }

        assertAll(
                () -> assertEquals(0, this.mq.peek()),
                () -> assertEquals("[2, 1, 0]", this.mq.toString())
        );

        this.mq.dequeue();

        assertEquals(1, this.mq.peek());
    }

    @Test
    @DisplayName("Tests poll() for valid and invalid args")
    void poll() {
        assertNull(this.mq.poll());

        for (int i = 0; i < 3; i++) { this.mq.enqueue(i); }

        assertAll(
                () -> assertEquals(0, this.mq.poll()),
                () -> assertEquals("[2, 1]", this.mq.toString()),
                () -> assertEquals(1, this.mq.poll()),
                () -> assertEquals("[2]", this.mq.toString()),
                () -> assertEquals(2, this.mq.poll()),
                () -> assertEquals("[]", this.mq.toString())
        );
    }
}
package stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StackGokTest {
    private StackGok stackGok;

    @BeforeEach
    void setUp() {
        stackGok = new StackGok(15);
    }

    @Test
    void push() {
        stackGok.push(13);
        assertEquals(13, stackGok.peek());
    }

    @Test
    void pop() {
        stackGok.push(13);
        assertEquals(13, stackGok.pop());
        assertTrue(stackGok.isEmpty());
    }

    @Test
    void peek() {
        stackGok.push(121);
        assertEquals(121, stackGok.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(stackGok.isEmpty());
    }

    @Test
    void isFull() {
        IntStream.rangeClosed(0, 13).forEach(value -> stackGok.push(value));
        assertFalse(stackGok.isFull());
        stackGok.push(314);
        assertTrue(stackGok.isFull());
    }
}
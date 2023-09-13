package stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacks.exceptions.StackEmptyException;

import static org.junit.jupiter.api.Assertions.*;

class StackLinkedTest {
    private final StackLinked<String> stackLinked = new StackLinked<>();
    private final StackLinked<String> stackLinkedOne = new StackLinked<>();

    @BeforeEach
    void setUp() {
        stackLinked.push("!");
        stackLinked.push("stack");
        stackLinked.push("a");
        stackLinked.push("is");
        stackLinked.push("This");
        stackLinkedOne.push("test");

    }

    @Test
    void pushOnlyOne() {
        assertEquals("test", stackLinkedOne.peek());
    }

    @Test
    void push() {
        stackLinked.display();
        stackLinked.push("Bravo!");

        assertDoesNotThrow(stackLinked::display);
    }

    @Test
    void pop() {
        stackLinked.display();
        assertEquals("This", stackLinked.pop());
        stackLinked.display();
    }

    @Test
    void popOnlyOne() {
        assertEquals("test", stackLinkedOne.pop());
    }

    @Test
    void pop_shouldThrowStackEmptyExceptionWhenStackIsEmpty() {
        final var newStack = new StackLinked<String>();
        assertThrows(StackEmptyException.class, newStack::pop);
    }

    @Test
    void peek() {
        stackLinked.display();
        assertEquals("This", stackLinked.peek());
        stackLinked.display();
    }

    @Test
    void isEmpty() {
        assertFalse(stackLinked.isEmpty());
        assertTrue(new StackLinked<String>().isEmpty());
    }

}
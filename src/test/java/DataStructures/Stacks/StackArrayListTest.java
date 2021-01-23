package DataStructures.Stacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayListTest {

    private StackArrayList<Integer> stack;

    @BeforeEach
    void setUp() {
        this.stack = new StackArrayList<>();
    }

    @AfterEach
    void tearDown() {
        this.stack = null;
    }

    @Test
    void push() {
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void pop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void peek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void size() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }
}
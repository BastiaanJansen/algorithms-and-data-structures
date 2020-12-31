package DataStructures.Queues;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    QueueLinkedList<Integer> queue;

    @BeforeEach
    void setUp() {
        this.queue = new QueueLinkedList<>();
    }

    @AfterEach
    void tearDown() {
        this.queue = null;
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.front());
    }

    @Test
    void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    void front() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.front());
    }

    @Test
    void isEmpty() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }
}
package DataStructures.Queues;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    PriorityQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        this.queue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @AfterEach
    void tearDown() {
        this.queue = null;
    }

    @Test
    void enqueue() {
        queue.enqueue(5);
        assertEquals(1, queue.size());
        assertEquals(5, queue.front());
        queue.enqueue(1);
        assertEquals(2, queue.size());
        assertEquals(5, queue.front());
        queue.enqueue(6);
        assertEquals(3, queue.size());
        assertEquals(6, queue.front());
    }

    @Test
    void dequeue() {
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(2);
        assertEquals(3, queue.size());
        assertEquals(8, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void front() {
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(2);
        assertEquals(8, queue.front());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.enqueue(5);
        assertEquals(1, queue.size());
        queue.enqueue(8);
        assertEquals(2, queue.size());
    }
}
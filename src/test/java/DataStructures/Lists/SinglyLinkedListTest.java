package DataStructures.Lists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        this.list = new SinglyLinkedList<>();
    }

    @AfterEach
    void tearDown() {
        this.list = null;
    }

    @Test
    void addFirst() {
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        list.addFirst(2);
        assertEquals(2, list.getFirst());
    }

    @Test
    void addLast() {
        list.addLast(1);
        assertEquals(1, list.getLast());
        list.addLast(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void add() {
        list.add(0, 1);
        assertEquals(1, list.getFirst());
        list.add(0, 2);
        assertEquals(2, list.getFirst());
        list.add(1, 3);
        assertEquals(2, list.getFirst());
        assertEquals(1, list.getLast());
    }

    @Test
    void addAll() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        list.addAll(arrayList);
        assertEquals(2, list.size());
        assertEquals(1, list.getFirst());
        assertEquals(2, list.getLast());
    }

    @Test
    void removeFirst() {
        assertThrows(NoSuchElementException.class, () -> {
           list.removeFirst();
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.removeFirst());
        assertEquals(1, list.size());
    }

    @Test
    void removeLast() {
        assertThrows(NoSuchElementException.class, () -> {
           list.removeLast();
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(1, list.removeLast());
        assertEquals(1, list.size());
    }

    @Test
    void remove() {
        assertThrows(NoSuchElementException.class, () -> {
           list.remove(2);
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.remove(0));
        assertEquals(1, list.size());
    }

    @Test
    void get() {
        assertThrows(NoSuchElementException.class, () -> {
           list.get(2);
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void find() {
        assertThrows(NoSuchElementException.class, () -> {
            list.find(2);
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(0, list.find(2));
        assertEquals(1, list.find(1));
    }

    @Test
    void clear() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void contains() {
        list.addFirst(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    void getFirst() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.getFirst());
    }

    @Test
    void getLast() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getLast();
        });
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(1, list.getLast());
        list.addLast(3);
        assertEquals(3, list.getLast());
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.addFirst(1);
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }
}
package DataStructures.Lists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DynamicArray<>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    void toArray() {
        list.add(1);
        list.add(2);
        assertArrayEquals(new Integer[]{1, 2}, list.toArray());
    }

    @Test
    void add() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void remove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.size());
        assertTrue(list.contains(1));
        list.remove(1);
        assertEquals(3, list.size());
        assertFalse(list.contains(2));
        list.remove(Integer.valueOf(3));
        assertEquals(2, list.size());
        assertFalse(list.contains(3));
    }

    @Test
    void clear() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void addAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        list.add(1);
        assertEquals(1, list.size());
        list.addAll(collection);
        assertEquals(3, list.size());
    }

    @Test
    void indexOf() {
        list.add(1);
        list.add(2);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
    }
}
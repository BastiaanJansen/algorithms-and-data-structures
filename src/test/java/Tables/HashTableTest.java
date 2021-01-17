package Tables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    HashTable<Integer, Integer> table;

    @BeforeEach
    void setUp() {
        table = new HashTable<>(5);
    }

    @AfterEach
    void tearDown() {
        table = null;
    }

    @Test
    void put() {
        assertEquals(0, table.size());
        table.put(1, 100);
        assertEquals(1, table.size());
        table.put(1, 100);
        assertEquals(1, table.size());
        table.put(2, 200);
        assertEquals(2, table.size());
        table.put(3, 300);
        table.put(4, 400);
        table.put(5, 500);
        table.put(6, 600);
        assertEquals(6, table.size());

    }

    @Test
    void putAllMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        assertEquals(0, table.size());
        table.putAll(map);
        assertEquals(2, table.size());
    }

    @Test
    void putAllTable() {
        Table<Integer, Integer> hashTable = new HashTable<>(2);
        hashTable.put(1, 100);
        hashTable.put(2, 200);
        assertEquals(0, table.size());
        table.putAll(hashTable);
        assertEquals(2, table.size());
    }

    @Test
    void get() {
        table.put(1, 100);
        table.put(2, 200);
        assertEquals(100, table.get(1));
        assertEquals(200, table.get(2));
    }

    @Test
    void containsKey() {
        table.put(1, 100);
        assertTrue(table.containsKey(1));
        assertFalse(table.containsKey(2));
    }

    @Test
    void containsValue() {
        table.put(1, 100);
        assertTrue(table.containsValue(100));
        assertFalse(table.containsValue(200));
    }

    @Test
    void remove() {
        table.put(1, 100);
        assertEquals(1, table.size());
        assertTrue(table.containsKey(1));
        table.remove(1);
        assertEquals(0, table.size());
        assertFalse(table.containsKey(1));
    }

    @Test
    void clear() {
        table.put(1, 100);
        assertEquals(1, table.size());
        table.clear();
        assertEquals(0, table.size());
    }

    @Test
    void keySet() {
        table.put(1, 100);
        table.put(2, 200);
        table.put(3, 300);
        table.put(4, 400);
        table.put(4, 400);
        table.put(4, 400);
        table.put(5, 500);
        table.put(5, 400);
        table.put(6, 600);
        table.put(7, 700);
        Set<Integer> actualSet = new HashSet<>();
        actualSet.add(1);
        actualSet.add(2);
        actualSet.add(3);
        actualSet.add(4);
        actualSet.add(5);
        actualSet.add(6);
        actualSet.add(7);
        assertEquals(actualSet, table.keySet());
    }

    @Test
    void size() {
        assertEquals(0, table.size());
        table.put(1, 100);
        assertEquals(1, table.size());
    }

    @Test
    void isEmpty() {
        assertTrue(table.isEmpty());
        table.put(1, 100);
        assertFalse(table.isEmpty());
    }
}
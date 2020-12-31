package Searches;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch algorithm;
    Integer[] array;

    @BeforeEach
    void beforeEach() {
        this.algorithm = new BinarySearch();
        this.array = new Integer[]{ 1, 4, 5, 5, 2, 8, 8 };
    }

    @Test
    void find() {
        assertEquals(1, algorithm.find(array, 4));
        assertEquals(-1, algorithm.find(array, 100));
    }
}
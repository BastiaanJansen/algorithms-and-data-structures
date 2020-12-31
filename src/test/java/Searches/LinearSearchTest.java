package Searches;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    LinearSearch algorithm;
    Integer[] array;

    @BeforeEach
    void beforeEach() {
        this.algorithm = new LinearSearch();
        this.array = new Integer[]{ 1, 4, 5, 5, 2, 8, 8 };
    }

    @Test
    void find() {
        assertEquals(1, algorithm.find(array, 4));
        assertEquals(2, algorithm.find(array, 5));
        assertEquals(-1, algorithm.find(array, 100));
    }
}
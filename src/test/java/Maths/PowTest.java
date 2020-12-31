package Maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {

    @Test
    void pow() {
        assertEquals(16, Pow.pow(2, 4));
    }

    @Test
    void powZero() {
        assertEquals(0, Pow.pow(0, 2));
    }
}
package Maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorial() {
        assertEquals(6, Factorial.factorial(3));
    }

    @Test
    void factorialZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void factoricalNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-2);
        });
    }
}
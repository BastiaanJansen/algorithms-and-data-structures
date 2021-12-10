package Maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void fibonnaciZero() {
        assertEquals(0,  Fibonacci.fibonacci(0));
    }

    @Test
    void factorialOne() {
        assertEquals(1,  Fibonacci.fibonacci(1));
    }

    @Test
    void factorialTwo() {
        assertEquals(1,  Fibonacci.fibonacci(2));
    }

    @Test
    void factorialThree() {
        assertEquals(2,  Fibonacci.fibonacci(3));
    }

    @Test
    void factorialFive() {
        assertEquals(5, Fibonacci.fibonacci(5));
    }

    @Test
    void factorialTen() {
        assertEquals(55, Fibonacci.fibonacci(10));
    }
}
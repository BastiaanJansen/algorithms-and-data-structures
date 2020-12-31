package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalTest {

    @Test
    void isAlphabetical() {
        assertTrue(Alphabetical.isAlphabetical("abcd"));
    }

    @Test
    void isNotAlphabetical() {
        assertFalse(Alphabetical.isAlphabetical("abdc"));
    }
}
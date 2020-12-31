package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagram() {
        assertTrue(Anagram.isAnagram("Santa", "Satan"));
        assertFalse(Anagram.isAnagram("Santa", "Claus"));
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void isAnagram2() {
        assertTrue(Anagram.isAnagram("Santa", "Satan"));
        assertFalse(Anagram.isAnagram("Santa", "Claus"));
        assertTrue(Anagram.isAnagram("", ""));
    }
}
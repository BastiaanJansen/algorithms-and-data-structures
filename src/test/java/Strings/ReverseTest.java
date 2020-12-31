package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {

    @Test
    void reverse() {
        assertEquals("dcba", Reverse.reverse("abcd"));
        assertNotEquals("jsdk", Reverse.reverse("abc"));
    }
}
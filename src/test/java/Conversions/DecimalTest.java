package Conversions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalTest {

    @Test
    void toBinary() {
        assertEquals("1010", Decimal.toBinary(10));
    }
}
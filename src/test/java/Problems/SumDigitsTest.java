package Problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumDigitsTest {

    @Test
    void sumDigits() {
        assertEquals(9, SumDigits.sumDigits(126));
        assertEquals(13, SumDigits.sumDigits(49));
        assertEquals(3, SumDigits.sumDigits(12));
    }
}
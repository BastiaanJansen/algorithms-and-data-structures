package Conversions;

public class Decimal {
    /**
     * Convert an integer to binary
     *
     * @param decimal integer you want to convert to binary
     * @return string with binary representation of decimal
     */
    public static String toBinary(int decimal) {
        StringBuilder binary = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 2;
            decimal = decimal >>> 1;
            binary.insert(0, remainder);
        }

        return binary.toString();
    }
}

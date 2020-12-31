package Strings;

/**
 * Alphabetical order is a system whereby character strings are placed in order based on the position of
 * the characters in the conventional ordering of an alphabet. It is one of the methods of collation.
 * In mathematics, a lexicographical order is the generalization of the alphabetical order to other data types,
 * such as sequences of digits or numbers.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Alphabetical_order">Alphabetical Order Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Alphabetical {
    public static boolean isAlphabetical(String value) {
        for (int i = 0; i < value.length() - 1; i++) {
            char character = value.charAt(i);
            if (!Character.isLetter(character) || character > value.charAt(i + 1))
                return false;
        }

        return true;
    }
}

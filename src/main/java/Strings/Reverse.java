package Strings;

/**
 * Reverse a string when not using string.reverse()
 *
 * @author Bastiaan Jansen
 */
public class Reverse {
    public static String reverse(String value) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--)
            reversedString.append(value.charAt(i));

        return reversedString.toString();
    }
}

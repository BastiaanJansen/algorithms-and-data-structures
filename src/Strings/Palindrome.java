package Strings;

/**
 * A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward,
 * such as madam, racecar.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Palindrome {
    public boolean isPalindrome(String value) {
        value = value.toLowerCase();
        if (value.length() <= 1)
            return true;

        if (value.charAt(0) != value.charAt(value.length() - 1))
            return false;

        return isPalindrome(value.substring(1, value.length() - 2));
    }
}

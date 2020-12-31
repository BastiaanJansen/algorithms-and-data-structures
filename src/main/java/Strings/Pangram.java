package Strings;

/**
 * A pangram or holoalphabetic sentence is a sentence using every letter of a given alphabet at least once.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Pangram">Pangram Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Pangram {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static boolean isPangram(String value) {
        value = value.toLowerCase();
        value = value.replace(" ", "");

        StringBuilder used = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            String characterString = String.valueOf(character);

            if (!alphabet.contains(characterString))
                return false;

            if (!used.toString().contains(characterString))
                used.append(character);
        }

        return alphabet.length() == used.length();
    }

    /**
     * A perfect pangram is an anagram with the alphabet
     *
     * @param value you want to check
     * @return whether the value is a perfect pangram
     */
    public static boolean isPerfectPangram(String value) {
        return Anagram.isAnagram(value.replace(" ", ""), alphabet);
    }
}

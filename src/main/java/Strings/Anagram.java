package Strings;

import java.util.Arrays;

/**
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once. For example, the word anagram can be rearranged
 * into nag a ram, also the word binary into brainy and the word adobe into abode, also the word Santa into Satan.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Anagram">Anagram Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Anagram {
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        for (int i = 0; i < word1.length(); i++) {
            String charSequence = String.valueOf(word1.charAt(i)).toLowerCase();
            if (!word2.toLowerCase().contains(charSequence))
                return false;
        }

        return true;
    }

    public static boolean isAnagram2(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        char[] word1Characters = word1.toCharArray();
        char[] word2Characters = word2.toCharArray();

        Arrays.sort(word1Characters);
        Arrays.sort(word2Characters);

        return Arrays.equals(word1Characters, word2Characters);
    }
}

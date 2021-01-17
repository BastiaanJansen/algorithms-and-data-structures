package Strings;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Bastiaan Jansen
 */
public class IsUnique {

    public static boolean isUnique(String value) {
        for (int i = 0; i < value.length(); i++) {
            for (int j = 0; j < value.length(); j++) {
                if (i == j)
                    continue;
                if (value.charAt(i) == value.charAt(j))
                    return false;
            }
        }

        return true;
    }

    public static boolean isUnique2(String value) {
        char[] letters = value.toCharArray();
        Arrays.sort(letters);

        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == letters[i + 1])
                return false;
        }

        return true;
    }

    public static boolean isUnique3(String value) {
        HashSet<Character> set = new HashSet<>();

        for (char letter: value.toCharArray()) {
            if (set.contains(letter))
                return false;

            set.add(letter);
        }

        return true;
    }
}

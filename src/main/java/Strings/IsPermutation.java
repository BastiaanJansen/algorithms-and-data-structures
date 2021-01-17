package Strings;

import java.util.Arrays;

/**
 * In mathematics, a permutation of a set is, loosely speaking, an arrangement of its members into a sequence or linear
 * order, or if the set is already ordered, a rearrangement of its elements. The word "permutation" also refers to
 * the act or process of changing the linear order of an ordered set.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Permutation">Permutations Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class IsPermutation {

    public static boolean isPermutation(String value1, String value2) {
        if (value1.length() != value2.length()) return false;

        char[] charArray1 = value1.toCharArray();
        char[] charArray2 = value2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

}

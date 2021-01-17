package Problems;

/**
 * Given a non-negative int n, return the sum of its digits recursively.
 * sumDigits(126) → 9
 * sumDigits(49) → 13
 * sumDigits(12) → 3
 *
 * @author Bastiaan Jansen
 */
public class SumDigits {

    public static int sumDigits(int n) {
        if (n < 0)
            throw new IllegalArgumentException();

        if (n == 0)
            return n;

        return n % 10 + sumDigits(n / 10);
    }

}

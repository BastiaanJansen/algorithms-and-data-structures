package Maths;

/**
 * In mathematics, the factorial of a positive integer n, denoted by n!,
 * is the product of all positive integers less than or equal to n
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Factorial {
    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Number cannot be negative");

        if (n == 0)
            return 1;

        if (n == 1)
            return n;
        return n * factorial(n - 1);
    }
}

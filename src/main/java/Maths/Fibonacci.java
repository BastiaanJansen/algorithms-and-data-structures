package Maths;

/**
 * In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci WIkipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Fibonacci {
    public static long fibonacci(int number) {
        if (number == 0)
            return 0;

        if (number <= 2)
            return 1;

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}

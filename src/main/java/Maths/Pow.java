package Maths;

/**
 * Exponentiation is a mathematical operation, written as bn, involving two numbers,
 * the base b and the exponent or power n, and pronounced as "b raised to the power of n".
 * When n is a positive integer, exponentiation corresponds to repeated multiplication of the base:
 * that is, bn is the product of multiplying n bases.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Exponentiation#Power_functions">Power Functions Wikipedia</a>
 *
 * @author Bastiaan Jansen
 */
public class Pow {
    public static double pow(int base, int exponent) {
        if (exponent == 1)
            return base;
        return base * pow(base, exponent - 1);
    }
}

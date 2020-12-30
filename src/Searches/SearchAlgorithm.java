package Searches;

/**
 * @author Bastiaan Jansen
 */
public interface SearchAlgorithm {
    <T extends Comparable<T>> int find(T[] array, T key);
}

package Searches;

import java.util.List;

/**
 * Generic interface for a search algorithm
 *
 * @author Bastiaan Jansen
 */
public interface SearchAlgorithm {
    /**
     * Find a key in an array
     *
     * @param array of items of type T
     * @param key element to be found
     * @param <T> type of key and elements in array
     * @return index of key in array
     */
    <T extends Comparable<T>> int find(T[] array, T key);

    /**
     * Find a key in a list
     *
     * @param list of items of type T
     * @param key element to be found
     * @param <T> type of key and elements in array
     * @return index of key in array
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> int find(List<T> list, T key) {
        T[] array = (T[]) list.toArray();
        return find(array, key);
    }
}

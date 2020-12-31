package Sorts;

import java.util.Arrays;
import java.util.List;

/**
 * Generic interface for sort algorithms
 *
 * @author Bastiaan Jansen
 */
public interface SortAlgorithm {
    /**
     * Sort an array
     *
     * @param array to be sorted
     * @param <T> type of elements in array
     * @return sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] array);

    /**
     * Sort a list
     *
     * @param list to be sorted
     * @param <T> type of elements in list
     * @return sorted list
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> list) {
        T[] array = (T[]) list.toArray();
        return Arrays.asList(sort(array));
    }
}

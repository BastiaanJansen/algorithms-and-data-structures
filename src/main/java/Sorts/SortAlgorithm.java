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

    /**
     * Swap two elements in an array
     *
     * @param array with items
     * @param index1 index of swap item 1
     * @param index2 index of swap item 2
     * @param <T> type of elements of array
     */
    default <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T item1 = array[index1];
        T item2 = array[index2];
        array[index1] = item2;
        array[index2] = item1;
    }
}

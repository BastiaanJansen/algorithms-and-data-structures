package Sorts;

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
     */
    <T extends Comparable<T>> void sort(T[] array);

    /**
     * Swap two elements in an array
     *
     * @param array with items
     * @param index1 index of swap item 1
     * @param index2 index of swap item 2
     * @param <T> type of elements of array
     */
    default <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

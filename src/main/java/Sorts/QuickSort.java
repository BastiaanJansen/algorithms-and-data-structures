package Sorts;

/**
 * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm.
 * Developed by British computer scientist Tony Hoare in 1959[1] and published in 1961, it is still a
 * commonly used algorithm for sorting. When implemented well, it can be about two or three times faster
 * than its main competitors, merge sort and heapsort.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">QuickSort Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SortAlgorithm
 */
public class QuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
         sort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        if (low >= high) return;

        int partitionIndex = partition(array, low, high);

        sort(array, low, partitionIndex - 1);
        sort(array, partitionIndex + 1, array.length - 1);
    }

    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];

        int i = low;

        for (int j = low; j <= high; j++) {
            if (array[j].compareTo(pivot) < 0)
                swap(array, i++, j);
        }

        swap(array, i, high);
        return i;
    }
}

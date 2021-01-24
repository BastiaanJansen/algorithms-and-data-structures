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

    public static void main(String[] args) {
        SortAlgorithm sorter = new QuickSort();
        Integer[] array = { 4, 2, 3, 6, 2, 1 };
        Integer[] sorted = sorter.sort(array);
        System.out.println(sorted[0]);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return sort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> T[] sort(T[] array, int low, int high) {
        if (low >= high)
            return array;

        int p = partition(array, low, high);

        sort(array, low, p - 1);
        sort(array, p + 1, array.length - 1);

        return array;
    }

    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low;
        for (int j = low; j <= high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    private <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T item1 = array[index1];
        T item2 = array[index2];
        array[index1] = item2;
        array[index2] = item1;
    }
}

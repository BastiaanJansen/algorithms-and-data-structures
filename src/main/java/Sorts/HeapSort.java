package Sorts;

/**
 * In computer science, heapsort is a comparison-based sorting algorithm.
 * Heapsort can be thought of as an improved selection sort: like selection sort,
 * heapsort divides its input into a sorted and an unsorted region,
 * and it iteratively shrinks the unsorted region by extracting the largest element from
 * it and inserting it into the sorted region. Unlike selection sort,
 * heapsort does not waste time with a linear-time scan of the unsorted region;
 * rather, heap sort maintains the unsorted region in a heap data structure to more quickly
 * find the largest element in each step.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Heapsort">Heap Sort Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SortAlgorithm
 */
public class HeapSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        int heapSize = array.length;

        for (int i = heapSize / 2; i >= 0; i--)
            heapify(array, heapSize, i);

        for (int i = heapSize - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, --heapSize, 0);
        }
    }

    private <T extends Comparable<T>> void heapify(T[] array, int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;

        if (left < size && array[left].compareTo(array[largest]) > 0)
            largest = left;

        if (right < size && array[right].compareTo(array[largest]) > 0)
            largest = right;

        if (index != largest) {
            swap(array, index, largest);
            heapify(array, size, largest);
        }
    }

}

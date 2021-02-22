package Sorts;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the
 * list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is
 * repeated until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller
 * or larger elements "bubble" to the top of the list.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SortAlgorithm
 */
public class BubbleSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j + 1);
            }
        }

        return array;
    }
}

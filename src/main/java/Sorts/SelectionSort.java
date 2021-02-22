package Sorts;

/**
 * The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to right
 * at the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by
 * finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping)
 * it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element
 * to the right.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SortAlgorithm
 */
public class SelectionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) minIndex = j;
            }

            swap(array, minIndex, i);
        }

        return array;
    }
}

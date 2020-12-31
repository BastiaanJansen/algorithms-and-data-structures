package Searches;

/**
 * In computer science, binary search, also known as half-interval search, logarithmic search,
 * or binary chop, is a search algorithm that finds the position of a target value within a sorted array.
 * Binary search compares the target value to the middle element of the array.
 * If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half,
 * again taking the middle element to compare to the target value,
 * and repeating this until the target value is found.
 * If the search ends with the remaining half being empty, the target is not in the array.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">Binary Search Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SearchAlgorithm
 */
public class BinarySearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (int) Math.floor((min + max) >>> 1);
            int comparisonResult = key.compareTo(array[mid]);

            if (comparisonResult < 0)
                max = mid - 1;
            else if (comparisonResult > 0)
                min = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}

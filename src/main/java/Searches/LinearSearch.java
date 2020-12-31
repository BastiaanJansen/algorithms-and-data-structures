package Searches;

/**
 * In computer science, a linear search or sequential search is a method for finding an element within a list.
 * It sequentially checks each element of the list until a match is found or the whole list has been searched
 *
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Linear Search Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SearchAlgorithm
 */
public class LinearSearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key))
                return i;
        }

        return -1;
    }
}

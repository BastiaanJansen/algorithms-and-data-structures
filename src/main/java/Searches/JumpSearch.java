package Searches;

/**
 * In computer science, a jump search or block search refers to a search algorithm for ordered lists.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Jump_search">Jump Search Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see SearchAlgorithm
 */
public class JumpSearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int squareRoot = (int) Math.floor(Math.sqrt(array.length));
        int m = squareRoot;
        int index = 0;

        while (array[Math.min(m, array.length) - 1].compareTo(key) < 0) {
            index = m;
            m += squareRoot;

            if (index >= array.length) return -1;
        }

        while (array[index].compareTo(key) < 0) {
            index++;
            if (index == Math.min(m, array.length)) return -1;
        }

        if (array[index].compareTo(key) == 0)
            return index;
        else
            return -1;
    }
}

package DataStructures.Queues;

import java.util.*;

/**
 * In computer science, a priority queue is an abstract data type similar to a regular queue or stack data
 * structure in which each element additionally has a "priority" associated with it.
 * In a priority queue, an element with high priority is served before an element with low priority.
 * In some implementations, if two elements have the same priority, they are served according to the order
 * in which they were enqueued, while in other implementations, ordering of elements with the same priority is undefined.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Priority_queue">Priority Queue Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see Comparable
 * @see Queue
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private final ArrayList<T> list;
    private final Comparator<? super T> comparator;

    public PriorityQueue(int size, Comparator<? super T> comparator) {
        this.list = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T element) {
        list.add(element);

        if (list.size() > 0)
            list.sort(comparator);
    }

    @Override
    public T dequeue() {
        if (list.size() <= 0)
            throw new NoSuchElementException();

        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        return element;
    }

    @Override
    public T front() {
        if (list.size() == 0)
            throw new NoSuchElementException();

        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}

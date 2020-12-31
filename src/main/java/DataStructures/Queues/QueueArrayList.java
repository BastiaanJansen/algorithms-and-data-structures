package DataStructures.Queues;

import java.util.ArrayList;

/**
 * Queue implementation using an array list.
 *
 * @author Bastiaan Jansen
 * @see Queue
 * @see ArrayList
 * @param <T>
 */
public class QueueArrayList<T> implements Queue<T> {

    private final ArrayList<T> list;

    public QueueArrayList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() {
        return list.remove(0);
    }

    @Override
    public T front() {
        return list.get(0);
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

package DataStructures.Queues;

import java.util.ArrayList;

/**
 * Queue implementation using an array list.
 *
 * @author Bastiaan Jansen
 * @see Queue
 * @param <T>
 */
public class QueueArrayList<T> implements Queue<T> {

    private ArrayList<T> list;

    public QueueArrayList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T front() {
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

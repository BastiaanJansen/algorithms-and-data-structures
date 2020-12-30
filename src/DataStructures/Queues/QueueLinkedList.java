package DataStructures.Queues;

import java.util.LinkedList;

/**
 * Queue implementation using a linked list.
 *
 * @author Bastiaan Jansen
 * @see Queue
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private LinkedList<T> list;

    public QueueLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void enqueue(T value) {
        list.addLast(value);
    }

    @Override
    public T dequeue() {
        return list.removeFirst();
    }

    @Override
    public T front() {
        return list.getFirst();
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

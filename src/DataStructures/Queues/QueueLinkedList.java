package DataStructures.Queues;

import DataStructures.Lists.SinglyLinkedList;

public class QueueLinkedList<T> implements Queue<T> {

    private SinglyLinkedList<T> list;

    public QueueLinkedList() {
        this.list = new SinglyLinkedList<>();
    }

    @Override
    public void enqueue(T value) {
        list.addLast(value);
    }

    @Override
    public T dequeue() {
        return list.deleteFirst();
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

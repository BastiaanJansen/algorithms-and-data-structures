package DataStructures.Queues;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T front();
    boolean isEmpty();
    int size();
}

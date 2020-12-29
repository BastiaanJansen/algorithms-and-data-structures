package DataStructures.Lists;

import java.util.Collection;

public interface LinkedList<T> extends List<T> {
    void addFirst(T element);
    void addLast(T element);
    T getFirst();
    T getLast();
    T removeFirst();
    T removeLast();
    T remove(int index);

    interface Node<T> {
        Node getLast();
        boolean contains(T element);
        int size(int n);
        int find(T element);
        boolean hasNext();
    }
}

package DataStructures.Stacks;

import java.util.LinkedList;

/**
 * Stack implementation using a linked list.
 *
 * @author Bastiaan Jansen
 * @see Stack
 * @param <T>
 */
public class StackLinkedList<T> implements Stack<T> {

    LinkedList<T> list;

    public StackLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(T value) {
        list.addFirst(value);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
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

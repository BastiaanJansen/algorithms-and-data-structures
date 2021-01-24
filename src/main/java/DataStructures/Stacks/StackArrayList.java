package DataStructures.Stacks;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stack implementation using an array list.
 *
 * @author Bastiaan Jansen
 * @see Stack
 * @see ArrayList
 * @param <T>
 */
public class StackArrayList<T> implements Stack<T> {

    private final ArrayList<T> list;

    public StackArrayList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.get(size() - 1);
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

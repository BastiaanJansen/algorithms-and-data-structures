package DataStructures.Stacks;

/**
 * Stack implementation using an array.
 *
 * @author Bastiaan Jansen
 * @see Stack
 * @param <T>
 */
public class StackArray<T> implements Stack<T> {

    private final Object[] list;
    private int index;

    public StackArray(int size) {
        this.list = new Object[size];
        this.index = 0;
    }

    @Override
    public void push(T value) {
        list[index] = value;
        index++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        Object item = list[index - 1];
        index--;
        return (T) item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        return (T) list[index - 1];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }
}

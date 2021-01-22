package DataStructures.Lists;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * In computer science, a dynamic array, growable array, resizable array, dynamic table, mutable array,
 * or array list is a random access, variable-size list data structure that allows elements to be added
 * or removed. It is supplied with standard libraries in many modern mainstream programming languages.
 * Dynamic arrays overcome a limit of static arrays, which have a fixed capacity that needs to be
 * specified at allocation.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Dynamic_array">Dynamic Array Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see List
 * @param <T>
 */
public class DynamicArray<T> implements List<T> {

    private T[] array;
    private int capacity;
    private int length;

    private final int originalCapacity;

    public DynamicArray() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.originalCapacity = capacity;
        this.length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < length; i++)
            if (array[i].equals(element))
                return true;

        return false;
    }


    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] newArray = (T[]) new Object[length];
        if (length >= 0) System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    public void add(T element) {
        if (length + 1 > capacity)
            resize();

        array[length++] = element;
    }

    public void remove(Object element) {
        int index = indexOf(element);
        if (length - (index + 1) >= 0) System.arraycopy(array, index + 1, array, index + 1 - 1, length - (index + 1));
        array[length--] = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (T[]) new Object[originalCapacity];
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException();
        return array[index];
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException();

        if (length + 1 > capacity)
            resize();

        for (int i = index; i < length; i++)
            array[i + 1] = array[i];

        array[index] = element;
        length++;
    }

    @Override
    public void addAll(Collection<? extends T> elements) {
        for (T element: elements)
            add(element);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > length)
            throw new NoSuchElementException();

        T element = array[index];
        if (length - (index + 1) >= 0) System.arraycopy(array, index + 1, array, index + 1 - 1, length - (index + 1));
        array[length--] = null;
        return element;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < length; i++)
            if (array[i].equals(element))
                return i;
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        if (length >= 0) System.arraycopy(array, 0, newArray, 0, length);
        array = newArray;
    }
}

package DataStructures.Lists;

import java.util.Collection;

/**
 * @author Bastiaan Jansen
 * @param <T>
 */
public interface List<T> {
    void add(int index, T element);
    void addAll(Collection<? extends T> elements);
    T get(int index);
    int indexOf(T element);
    void clear();
    boolean contains(T element);
    int size();
    boolean isEmpty();
    T remove(int index);
}

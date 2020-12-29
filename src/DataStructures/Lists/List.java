package DataStructures.Lists;

import java.util.Collection;

public interface List <T>{
    void add(int index, T element);
    void addAll(Collection<? extends T> elements);
    T get(int index);
    int find(T element);
    void clear();
    boolean contains(T element);
    int size();
    boolean isEmpty();
}

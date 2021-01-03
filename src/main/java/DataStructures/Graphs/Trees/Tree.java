package DataStructures.Graphs.Trees;

public interface Tree<T> {
    int getDepth();
    T getRoot();
    boolean contains(T value);
    boolean isEmpty();
    void remove(T value);


    default int getHeight() {
        return getDepth() + 1;
    }
}

package DataStructures.Stacks;

import DataStructures.Lists.SinglyLinkedList;

public class StackLinkedList<T> implements Stack<T> {

    SinglyLinkedList<T> list;

    public StackLinkedList() {
        this.list = new SinglyLinkedList();
    }

    @Override
    public void push(T value) {
        list.addFirst(value);
    }

    @Override
    public T pop() {
        return list.deleteFirst();
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

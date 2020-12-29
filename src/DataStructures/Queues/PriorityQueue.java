package DataStructures.Queues;

import java.util.*;

public class PriorityQueue<T extends Comparable> implements Queue<T> {

    private ArrayList<T> list;
    private Comparator<? super T> comparator;

    public PriorityQueue(int size, Comparator<? super T> comparator) {
        this.list = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T element) {
        list.add(element);

        if (list.size() > 0)
            list.sort(comparator);
    }

    @Override
    public T dequeue() {
        if (list.size() <= 0)
            throw new NoSuchElementException();

        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        return element;
    }

    @Override
    public T front() {
        if (list.size() == 0)
            throw new NoSuchElementException();

        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(100);
        queue.enqueue(-1);

        System.out.println(queue.dequeue());
        System.out.println(queue.front());
    }
}

package DataStructures.Lists;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * In computer science, a linked list is a linear collection of data elements whose order is not given by their
 * physical placement in memory. Instead, each element points to the next. It is a data structure consisting
 * of a collection of nodes which together represent a sequence. In its most basic form, each node contains:
 * data, and a reference (in other words, a link) to the next node in the sequence.
 * This structure allows for efficient insertion or removal of elements from any position in the sequence during iteration.
 * More complex variants add additional links, allowing more efficient insertion or removal of nodes at arbitrary positions.
 * A drawback of linked lists is that access time is linear (and difficult to pipeline). Faster access,
 * such as random access, is not feasible. Arrays have better cache locality compared to linked lists.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @param <T>
 */
public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node head;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T value) {
        addFirst(value);
    }

    public SinglyLinkedList(Collection<? extends T> elements) {
        addAll(elements);
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value);

        if (this.head != null)
            newNode.next = this.head;

        this.head = newNode;
    }

    @Override
    public void addLast(T value) {
        Node node = new Node(value);
        Node lastNode = getLastNode();

        if (lastNode == null)
            addFirst(value);
        else
            lastNode.next = node;
    }

    @Override
    public void add(int index, T value) {
        if (index != 0) {
            Node currentNode = getNode(index - 1);
            Node newNode = new Node(value);

            if (currentNode == null)
                throw new NoSuchElementException();

            newNode.next = currentNode.next;
            currentNode.next = newNode;
            return;
        }

        head = new Node(value, head);
    }

    @Override
    public void addAll(Collection<? extends T> values) {
        for (T value: values) addLast(value);
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size() - 1);
    }

    @Override
    public T remove(int index) {
        Node node = getNode(index);

        if (node == null)
            throw new NoSuchElementException();

        if (index == 0) {
            if (this.head.hasNext())
                this.head = this.head.next;
            else
                this.head = null;
            return node.value;
        }

        Node previousNode = getNode(index - 1);
        previousNode.next = node.next;
        return node.value;
    }

    @Override
    public T get(int index) {
        Node node = getNode(index);
        if (node == null)
            throw new NoSuchElementException();

        return node.value;
    }

    @Override
    public int find(T value) {
        if (head == null) throw new NoSuchElementException();
        return head.find(value);
    }

    private Node getNode(int index) {
        Node currentNode = head;

        if (currentNode == null)
            throw new NoSuchElementException();

        for (int i = 0; i <= index; i++) {
            if (i == index) return currentNode;

            if (currentNode.hasNext()) {
                currentNode = currentNode.next;
                continue;
            }

            break;
        }

        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T element) {
        return head.contains(element);
    }

    @Override
    public T getFirst() {
        Node firstNode = getFirstNode();
        if (head == null)
            throw new NoSuchElementException();

        return firstNode.value;
    }

    private Node getFirstNode() {
        return head == null ? null : head;
    }

    public T getLast() {
        Node lastNode = getLastNode();

        if (lastNode == null)
            throw new NoSuchElementException();

        return lastNode.value;
    }

    private Node getLastNode() {
        if (head == null)
            return null;
        return head.getLast();
    }

    @Override
    public int size() {
        if (head == null) return 0;
        return head.size(1);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private class Node implements LinkedList.Node<T> {
        Node next;
        T value;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this(value, null);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Node getLast() {
            if (!hasNext()) return this;
            return next.getLast();
        }

        @Override
        public boolean contains(T element) {
            if (this.value.equals(element)) return true;

            if (hasNext()) {
                return next.contains(element);
            }

            return false;
        }

        @Override
        public int size(int n) {
            if (hasNext())
                return next.size(n + 1);

            return n;
        }

        @Override
        public int find(T value) {
            return find(value, 0);
        }

        private int find(T value, int index) {
            if (this.value.equals(value)) return index;
            if (hasNext()) return next.find(value, index + 1);
            return -1;
        }
    }
}

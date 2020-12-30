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
    private Node node;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T value) {
        this.node = new Node(value);
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (this.node != null) newNode.setNext(this.node);
        this.node = newNode;
    }

    @Override
    public void addLast(T value) {
        Node node = new Node(value);
        Node lastNode = getLastNode();
        if (lastNode == null)
            addFirst(value);
        else
            lastNode.setNext(node);
    }

    @Override
    public void add(int index, T value) {
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.setNext(node);
            node = newNode;
            return;
        }

        Node currentNode = getNode(index - 1);
        Node newNode = new Node(value);
        if (currentNode != null) {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
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

        if (index == 0) {
            this.node = this.node.hasNext() ? this.node.getNext() : null;
            return node.getValue();
        }

        Node previousNode = getNode(index - 1);
        previousNode.setNext(node.getNext());
        return node.getValue();
    }

    @Override
    public T get(int index) {
        Node node = getNode(index);
        if (node == null)
            throw new NoSuchElementException();

        return node.getValue();
    }

    @Override
    public int find(T value) {
        if (node == null) return -1;
        return node.find(value);
    }

    private Node getNode(int index) {
        Node currentNode = node;
        for (int i = 0; i <= index; i++) {
            if (i == index) return currentNode;

            if (currentNode.hasNext()) {
                currentNode = currentNode.getNext();
                continue;
            }

            break;
        }

        return null;
    }

    @Override
    public void clear() {
        node = null;
    }

    @Override
    public boolean contains(T element) {
        return node.contains(element);
    }

    @Override
    public T getFirst() {
        Node firstNode = getFirstNode();
        if (node == null)
            throw new NoSuchElementException();

        return firstNode.getValue();
    }

    private Node getFirstNode() {
        return node == null ? null : node;
    }

    public T getLast() {
        Node lastNode = getLastNode();
        if (node == null)
            throw new NoSuchElementException();

        return lastNode.getValue();
    }

    private Node getLastNode() {
        if (node == null)
            return null;
        else
            return node.getLast();
    }

    @Override
    public int size() {
        if (node == null) return 0;
        return node.size(1);
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }

    private class Node implements LinkedList.Node<T> {
        private Node next;
        private T value;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this(value, null);
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
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

            if (!hasNext()) {
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

package DataStructures.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * In computer science, a doubly linked list is a linked data structure that consists of a set of
 * sequentially linked records called nodes. Each node contains three fields:
 * two link fields (references to the previous and to the next node in the sequence of nodes) and one data field.
 * The beginning and ending nodes' previous and next links, respectively, point to some kind of terminator,
 * typically a sentinel node or null, to facilitate traversal of the list. If there is only one sentinel node,
 * then the list is circularly linked via the sentinel node. It can be conceptualized as two singly linked lists
 * formed from the same data items, but in opposite sequential orders.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Doubly_linked_list">Doubly Linked List Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see LinkedList
 * @param <T>
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node node;

    public DoublyLinkedList() {}

    public DoublyLinkedList(T element) {
        this.node = new Node(element, null, null);
    }

    @Override
    public void addFirst(T element) {
        Node newNode = new Node(element, null, null);
        if (node != null) newNode.setNext(node.getNext());
        node = newNode;
    }

    @Override
    public void addLast(T element) {
        Node node = new Node(element);
        Node lastNode = getLastNode();
        lastNode.setNext(node);
        node.setPrevious(lastNode);
    }

    private Node getLastNode() {
        if (node == null)
            return null;
        else
            return node.getLast();
    }

    @Override
    public T getFirst() {
        if (node == null)
            throw new NoSuchElementException();

        return node.getValue();
    }

    @Override
    public T getLast() {
        if (node == null)
            throw new NoSuchElementException();

        return node.getLast().getValue();
    }

    @Override
    public T removeFirst() {
        if (node == null)
            throw new NoSuchElementException();

        return remove(0);
    }

    @Override
    public T removeLast() {
        if (node == null)
            throw new NoSuchElementException();

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

        Node nextNode = getNode(index + 1);
        nextNode.setPrevious(node.getNext());

        return node.getValue();
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
    public void add(int index, T element) {
        if (index == 0) {
            Node newNode = new Node(element);
            newNode.setNext(node);
            node = newNode;
            return;
        }

        Node currentNode = getNode(index - 1);
        Node newNode = new Node(element);
        if (currentNode != null) {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
        }
    }

    private Node getFirstNode() {
        return node == null ? null : node;
    }

    @Override
    public void addAll(Collection<? extends T> elements) {
        for (T element: elements) addLast(element);
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        if (node == null)
            throw new NoSuchElementException();

        return node.find(element);
    }

    @Override
    public void clear() {
        node = null;
    }

    @Override
    public boolean contains(T element) {
        if (node == null)
            throw new NoSuchElementException();

        return node.contains(element);
    }

    @Override
    public int size() {
        if (node == null)
            return 0;
        else
            return node.size(1);
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }

    private class Node implements LinkedList.Node<T> {
        private Node next;
        private Node previous;
        private T element;

        Node(T element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        Node(T element) {
            this(element, null, null);
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }

        public void setPrevious(Node node) { this.previous = node; }

        public Node getPrevious() { return previous; }

        public void setValue(T element) {
            this.element = element;
        }

        public T getValue() {
            return element;
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
            if (this.element.equals(element)) return true;

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
        public int find(T element) {
            return find(element, 0);
        }

        private int find(T element, int index) {
            if (this.element.equals(element)) return index;
            if (hasNext()) return next.find(element, index + 1);
            return -1;
        }
    }

}

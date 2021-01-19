package DataStructures.Graphs.Trees;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
    }

    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(T value) {
        add(value);
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else
            add(newNode, root);
    }

    private void add(Node newNode, Node node) {
        int result = newNode.value.compareTo(node.value);
        if (result < 0) {
            if (node.left == null)
                node.left = newNode;
            else
                add(newNode, node.left);
        } else if (result > 0) {
            if (node.right == null)
                node.right = newNode;
            else
                add(newNode, node.right);
        }

    }

    @Override
    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(Node root) {
        if (root == null)
            return -1;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Override
    public T getRoot() {
        if (root == null)
            throw new NoSuchElementException();
        return root.value;
    }

    @Override
    public boolean contains(T value) {
        return findNode(value, root) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void remove(T value) {

    }

    private Node findNode(T value, Node start) {
        int result = value.compareTo(start.value);
        if (result < 0) {
            if (start.left == null)
                return null;
            else
                return findNode(value, start.left);
        } else if (result > 0) {
            if (start.right == null)
                return null;
            else
                return findNode(value, start.right);
        }

        return start;
    }

    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

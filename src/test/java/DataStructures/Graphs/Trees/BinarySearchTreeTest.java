package DataStructures.Graphs.Trees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    @Test
    void add() {
        tree.add(1);
        assertEquals(1, tree.getRoot());
    }

    @Test
    void getDepth() {
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        assertEquals(3, tree.getDepth());
    }

    @Test
    void getHeight() {
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        assertEquals(4, tree.getHeight());
    }

    @Test
    void getRoot() {
        tree.add(1);
        assertEquals(1, tree.getRoot());
        tree.add(2);
        tree.add(5);
        tree.add(3);
        assertEquals(1, tree.getRoot());
    }

    @Test
    void contains() {
        tree.add(1);
        assertTrue(tree.contains(1));
        assertFalse(tree.contains(4));
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    void remove() {
    }
}
package bst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBSTTest {
    MyBST bst;

    @BeforeEach
    void init() {
        this.bst = new MyBST();
    }

    @AfterEach
    void clean() {
        this.bst = new MyBST();
    }

    @Test
    @DisplayName("Tests insert() by adding an element as the root")
    void insert_add_root() {
        this.bst.insert(1);

        assertEquals("1", this.bst.preorderTraversal());
    }

    @Test
    @DisplayName("Tests insert() by adding multiple elements")
    void insert_add_multiple() {
        int[] testArr = {6, 2, 1, 3, 9, 8, 10};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertEquals("6 2 1 3 9 8 10", this.bst.preorderTraversal()),
                () -> assertEquals("1 2 3 6 8 9 10", this.bst.inorderTraversal()),
                () -> assertEquals("1 3 2 8 10 9 6", this.bst.postorderTraversal())
        );
    }

    @Test
    @DisplayName("Tests insert() for duplicates")
    void insert_add_duplicate() {
        assertTrue(this.bst.insert(1));
        assertFalse(this.bst.insert(1));
    }

    @Test
    @DisplayName("Tests delete() by removing the root")
    void delete_root() {
        this.bst.insert(1);

        assertTrue(this.bst.delete(1));
        assertEquals("", this.bst.preorderTraversal());
    }

    @Test
    @DisplayName("Tests delete() by removing a leaf node")
    void delete_leaf_node() {
        int[] testArr = {6, 2, 1, 3, 9, 8, 10};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertTrue(this.bst.delete(3)),
                () -> assertEquals("6 2 1 9 8 10", this.bst.preorderTraversal()),
                () -> assertEquals("1 2 6 8 9 10", this.bst.inorderTraversal()),
                () -> assertEquals("1 2 8 10 9 6", this.bst.postorderTraversal())
        );
    }

    @Test
    @DisplayName("Tests delete() by removing a node with 1 child")
    void delete_node_1_child() {
        int[] testArr = {6, 2, 1, 3, 9, 8};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertTrue(this.bst.delete(9)),
                () -> assertEquals("6 2 1 3 8", this.bst.preorderTraversal()),
                () -> assertEquals("1 2 3 6 8", this.bst.inorderTraversal()),
                () -> assertEquals("1 3 2 8 6", this.bst.postorderTraversal())
        );
    }

    @Test
    @DisplayName("Tests delete() by removing an intermediary node with 2 children")
    void delete_node_2_children() {
        int[] testArr = {6, 2, 1, 3, 9, 8, 10};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertTrue(this.bst.delete(2)),
                () -> assertEquals("6 3 1 9 8 10", this.bst.preorderTraversal()),
                () -> assertEquals("1 3 6 8 9 10", this.bst.inorderTraversal()),
                () -> assertEquals("1 3 8 10 9 6", this.bst.postorderTraversal())
        );

    }

    @Test
    @DisplayName("Tests delete() by removing the root node with 2 children")
    void delete_root_2_children() {
        int[] testArr = {6, 2, 1, 3, 9, 8, 10};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertTrue(this.bst.delete(6)),
                () -> assertEquals("8 2 1 3 9 10", this.bst.preorderTraversal()),
                () -> assertEquals("1 2 3 8 9 10", this.bst.inorderTraversal()),
                () -> assertEquals("1 3 2 10 9 8", this.bst.postorderTraversal())
        );
    }

    @Test
    @DisplayName("Tests contains() by searching in an empty tree")
    void contains_empty_tree() {
        assertFalse(this.bst.contains(1));
    }

    @Test
    @DisplayName("Tests contains() by searching for root")
    void contains_root() {
        assertTrue(this.bst.insert(1));
        assertTrue(this.bst.contains(1));
    }

    @Test
    @DisplayName("Tests contains() by searching for multiple elements")
    void contains_multiple_elements() {
        int[] testArr = {6, 2, 1, 3, 9, 8, 10};

        for (int element : testArr) { assertTrue(this.bst.insert(element)); }

        assertAll(
                () -> assertTrue(this.bst.contains(2)),
                () -> assertTrue(this.bst.contains(10)),
                () -> assertTrue(this.bst.contains(1))
        );
    }
}
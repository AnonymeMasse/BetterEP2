package interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface IBinarySearchTreeTest<T extends IBinarySearchTree> {
    T createBinarySearchTree();

    @Test
    @DisplayName("Check contains on empty Tree")
    default void checkContainsOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(false, tree.contains(69));
    }

    @Test
    @DisplayName("Check remove on empty Tree")
    default void checkRemoveOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.remove(69));
    }

    @Test
    @DisplayName("Check findMin on empty Tree")
    default void checkFindMinOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.findMin());
    }

    @Test
    @DisplayName("Check findMax on empty Tree")
    default void checkFindMaxOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.findMax());
    }

    @Test
    @DisplayName("Check popMin on empty Tree")
    default void checkPopMinOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.popMin());
    }

    @Test
    @DisplayName("Check popMax on empty Tree")
    default void checkPopMaxOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.popMax());
    }

    @Test
    @DisplayName("Check length on empty Tree")
    default void checkLengthOnEmptyTree() {
        T tree = this.createBinarySearchTree();
        assertEquals(0, tree.length());
    }

    @Test
    @DisplayName("Check Put and Contains")
    default void checkPutAndContains() {
        T tree = this.createBinarySearchTree();

        assertEquals(false, tree.contains(0));
        tree.put(0);
        assertEquals(true, tree.contains(0));

        assertEquals(false, tree.contains(1));
        tree.put(1);
        assertEquals(true, tree.contains(1));

        assertEquals(false, tree.contains(-1));
        tree.put(-1);
        assertEquals(true, tree.contains(-1));

        tree.put(10);
        tree.put(5);
        tree.put(4);
        tree.put(7);
        tree.put(11);

        assertEquals(true, tree.contains(10));
        assertEquals(true, tree.contains(5));
        assertEquals(true, tree.contains(4));
        assertEquals(true, tree.contains(7));
        assertEquals(true, tree.contains(11));
    }

    @Test
    @DisplayName("Check Remove")
    default void checkRemove() {
        T tree = this.createBinarySearchTree();

        // this should produce a somewhat balanced tree
        tree.put(5);
        tree.put(7);
        tree.put(6);
        tree.put(8);
        tree.put(9);
        tree.put(2);
        tree.put(1);
        tree.put(0);
        tree.put(3);
        tree.put(4);

        assertEquals(null, tree.remove(69));

        assertEquals(5, tree.remove(5));
        assertEquals(null, tree.remove(5));

        assertEquals(3, tree.remove(3));
        assertEquals(null, tree.remove(3));

        assertEquals(8, tree.remove(8));
        assertEquals(null, tree.remove(8));

        assertEquals(7, tree.remove(7));
        assertEquals(null, tree.remove(7));

        assertEquals(6, tree.remove(6));
        assertEquals(null, tree.remove(6));

        assertEquals(2, tree.remove(2));
        assertEquals(null, tree.remove(2));

        assertEquals(1, tree.remove(1));
        assertEquals(null, tree.remove(1));

        assertEquals(4, tree.remove(4));
        assertEquals(null, tree.remove(4));

        assertEquals(9, tree.remove(9));
        assertEquals(null, tree.remove(9));

    }

    @Test
    @DisplayName("Check findMin")
    default void checkFindMin() {
        T tree = this.createBinarySearchTree();
        assertEquals(null, tree.findMin());

        tree.put(5);
        assertEquals(5, tree.findMin());

        tree.put(7);
        assertEquals(5, tree.findMin());

        tree.put(6);
        assertEquals(5, tree.findMin());

        tree.put(8);
        assertEquals(5, tree.findMin());

        tree.put(9);
        assertEquals(5, tree.findMin());

        tree.put(2);
        assertEquals(2, tree.findMin());

        tree.put(1);
        assertEquals(1, tree.findMin());

        tree.put(0);
        assertEquals(0, tree.findMin());

        tree.put(3);
        assertEquals(0, tree.findMin());
    }

    @Test
    @DisplayName("Check findMax")
    default void checkFindMax() {
        T tree = this.createBinarySearchTree();

        assertEquals(null, tree.findMax());

        tree.put(5);
        assertEquals(5, tree.findMax());

        tree.put(7);
        assertEquals(7, tree.findMax());

        tree.put(6);
        assertEquals(7, tree.findMax());

        tree.put(8);
        assertEquals(8, tree.findMax());

        tree.put(9);
        assertEquals(9, tree.findMax());

        tree.put(2);
        assertEquals(9, tree.findMax());

        tree.put(1);
        assertEquals(9, tree.findMax());

        tree.put(0);
        assertEquals(9, tree.findMax());

        tree.put(3);
        assertEquals(9, tree.findMax());
    }

    @Test
    @DisplayName("Check popMin")
    default void checkPopMin() {
        T tree = this.createBinarySearchTree();

        assertEquals(null, tree.popMin());

        // this should produce a somewhat balanced tree
        tree.put(5);
        tree.put(7);
        tree.put(6);
        tree.put(8);
        tree.put(9);
        tree.put(2);
        tree.put(1);
        tree.put(0);
        tree.put(3);
        tree.put(4);

        assertEquals(0, tree.popMin());
        assertEquals(1, tree.popMin());
        assertEquals(2, tree.popMin());
        assertEquals(3, tree.popMin());
        assertEquals(4, tree.popMin());
        assertEquals(5, tree.popMin());
        assertEquals(6, tree.popMin());
        assertEquals(7, tree.popMin());
        assertEquals(8, tree.popMin());
        assertEquals(9, tree.popMin());
    }

    @Test
    @DisplayName("Check popMax")
    default void checkPopMax() {
        T tree = this.createBinarySearchTree();

        assertEquals(null, tree.popMax());

        // this should produce a somewhat balanced tree
        tree.put(5);
        tree.put(7);
        tree.put(6);
        tree.put(8);
        tree.put(9);
        tree.put(2);
        tree.put(1);
        tree.put(0);
        tree.put(3);
        tree.put(4);

        assertEquals(9, tree.popMax());
        assertEquals(8, tree.popMax());
        assertEquals(7, tree.popMax());
        assertEquals(6, tree.popMax());
        assertEquals(5, tree.popMax());
        assertEquals(4, tree.popMax());
        assertEquals(3, tree.popMax());
        assertEquals(2, tree.popMax());
        assertEquals(1, tree.popMax());
        assertEquals(0, tree.popMax());

    }

    @Test
    @DisplayName("Check length")
    default void checkLength() {

        T tree = this.createBinarySearchTree();
        assertEquals(0, tree.length());

        tree.put(5);
        assertEquals(1, tree.length());

        tree.put(7);
        assertEquals(2, tree.length());

        tree.put(6);
        assertEquals(3, tree.length());

        tree.put(8);
        assertEquals(4, tree.length());

        tree.put(9);
        assertEquals(5, tree.length());

        tree.put(2);
        assertEquals(6, tree.length());

        tree.put(1);
        assertEquals(7, tree.length());

        tree.put(0);
        assertEquals(8, tree.length());

        tree.put(3);
        assertEquals(9, tree.length());

        tree.put(4);
        assertEquals(10, tree.length());
    }
}

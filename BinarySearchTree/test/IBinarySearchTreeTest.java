import interfaces.IBinarySearchTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public interface IBinarySearchTreeTest<T extends IBinarySearchTree> {
    T createBinarySearchTree();

    @Test
    @DisplayName("Put Single Element and Get it back")
    default void putGetTest() {
        T tree = this.createBinarySearchTree();
        assertEquals(0, tree.length());

        tree.put(69, 420);

        assertEquals(1, tree.length());

        assertEquals(420, tree.get(69));
    }

    @Test
    @DisplayName("Get Element which is not present in Tree")
    default void getElementWhichIsNotPresentInTree() {
        T tree = this.createBinarySearchTree();

        assertEquals(null, tree.get(69));

        tree.put(2, 2);
        tree.put(3, 3);
        tree.put(1, 1);
        tree.put(4, 4);

        assertEquals(null, tree.get(69));
    }

    @Test
    @DisplayName("Put and Get Multiple Elements")
    default void putAndGetMultipleElements() {
        T tree = this.createBinarySearchTree();

        tree.put(5, 5);
        tree.put(4, 4);
        tree.put(6, 6);
        tree.put(3, 3);
        tree.put(7, 7);
        tree.put(2, 2);
        tree.put(8, 8);
        tree.put(1, 1);
        tree.put(9, 9);
        tree.put(0, 0);

        assertEquals(10, tree.length());

        assertEquals(5, tree.get(5));
        assertEquals(4, tree.get(4));
        assertEquals(6, tree.get(6));
        assertEquals(3, tree.get(3));
        assertEquals(7, tree.get(7));
        assertEquals(2, tree.get(2));
        assertEquals(8, tree.get(8));
        assertEquals(1, tree.get(1));
        assertEquals(9, tree.get(9));
        assertEquals(0, tree.get(0));
    }

    @Test
    @DisplayName("Remove some elements")
    default void removeSomeElements() {
        T tree  = this.createBinarySearchTree();
        tree.put(5, 5);
        tree.put(4, 4);
        tree.put(6, 6);
        tree.put(3, 3);
        tree.put(7, 7);
        tree.put(2, 2);
        tree.put(8, 8);
        tree.put(1, 1);
        tree.put(9, 9);
        tree.put(0, 0);

        assertEquals(0, tree.remove(0));
        assertEquals(5, tree.remove(5));

        assertEquals(8, tree.length());

        assertEquals(1, tree.get(1));
        assertEquals(2, tree.get(2));
        assertEquals(3, tree.get(3));
        assertEquals(4, tree.get(4));
        assertEquals(6, tree.get(6));
        assertEquals(7, tree.get(7));
        assertEquals(8, tree.get(8));
        assertEquals(9, tree.get(9));


    }

}

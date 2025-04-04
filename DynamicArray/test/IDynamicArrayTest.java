import interfaces.IDynamicArray;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface IDynamicArrayTest<T extends IDynamicArray> {
    T createDynamicArray();

    @Test
    @DisplayName("Check Pop on empty array")
    default void checkPopOnEmptyArray() {
        T array = this.createDynamicArray();
        assertEquals(null, array.pop());
        assertEquals(null, array.pop());
    }

    @Test
    @DisplayName("Check remove on empty array")
    default void checkRemoveOnEmptyArray() {
        T array = this.createDynamicArray();
        assertEquals(null, array.remove(0));
        assertEquals(null, array.remove(-1));
        assertEquals(null, array.remove(10));
    }

    @Test
    @DisplayName("Check get on empty array")
    default void checkGetOnEmptyArray() {
        T array = this.createDynamicArray();
        assertEquals(null, array.get(0));
        assertEquals(null, array.get(-1));
        assertEquals(null, array.get(1));
    }

    @Test
    @DisplayName("Check length on empty array")
    default void checkLengthOnEmptyArray() {
        T array = this.createDynamicArray();
        assertEquals(0, array.length());
    }

    @Test
    @DisplayName("Check Push Single Value and Pop it")
    default void checkPushSingleValueAndPopIt() {
        T array = this.createDynamicArray();
        array.push(69);
        assertEquals(69, array.pop());
    }

    @Test
    @DisplayName("Check Push Single Value and Get it")
    default void checkPushSingleValueAndGetIt() {
        T array = this.createDynamicArray();
        array.push(69);
        assertEquals(69, array.get(0));
    }

    @Test
    @DisplayName("Check Get with Multiple Elements")
    default void checkGetWithMultipleElements() {
        T array = this.createDynamicArray();

        array.push(69);
        array.push(68);
        array.push(67);
        array.push(66);
        array.push(65);
        array.push(64);
        array.push(63);
        array.push(62);

        assertEquals(69, array.get(0));
        assertEquals(68, array.get(1));
        assertEquals(67, array.get(2));
        assertEquals(66, array.get(3));
        assertEquals(65, array.get(4));
        assertEquals(64, array.get(5));
        assertEquals(63, array.get(6));
        assertEquals(62, array.get(7));
    }

    @Test
    @DisplayName("Check Pop with Multiple Elements")
    default void checkPopWithMultipleElements() {
        T array = this.createDynamicArray();
        array.push(69);
        array.push(68);
        array.push(67);
        array.push(66);
        array.push(65);
        array.push(64);
        array.push(63);
        array.push(62);

        assertEquals(62, array.pop());
        assertEquals(63, array.pop());
        assertEquals(64, array.pop());
        assertEquals(65, array.pop());
        assertEquals(66, array.pop());
        assertEquals(67, array.pop());
        assertEquals(68, array.pop());
        assertEquals(69, array.pop());

        assertEquals(null, array.pop());

        array.push(69);
        array.push(70);
        assertEquals(70, array.pop());
        assertEquals(69, array.pop());
    }

    @Test
    @DisplayName("Check Length with Push")
    default void checkLengthWithPush() {
        T array = this.createDynamicArray();
        assertEquals(0, array.length());

        array.push(0);
        assertEquals(1, array.length());

        array.push(1);
        assertEquals(2, array.length());

        array.push(2);
        assertEquals(3, array.length());

        array.push(3);
        assertEquals(4, array.length());
    }

    @Test
    @DisplayName("Check Length with Pop")
    default void checkLengthWithPop() {
        T array = this.createDynamicArray();

        assertEquals(0, array.length());

        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);

        assertEquals(6, array.length());

        assertEquals(5, array.pop());
        assertEquals(5, array.length());

        assertEquals(4, array.pop());
        assertEquals(4, array.length());

        assertEquals(3, array.pop());
        assertEquals(3, array.length());

        assertEquals(2, array.pop());
        assertEquals(2, array.length());

        assertEquals(1, array.pop());
        assertEquals(1, array.length());

        assertEquals(0, array.pop());
        assertEquals(0, array.length());

        assertEquals(null, array.pop());
        assertEquals(0, array.length());
    }

    @Test
    @DisplayName("Check clear")
    default void checkClear() {
        T array = this.createDynamicArray();

        assertEquals(0, array.length());

        array.clear();
        assertEquals(0, array.length());
        assertEquals(null, array.pop());
        assertEquals(null, array.remove(0));
        assertEquals(null, array.get(0));

        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);

        array.clear();
        assertEquals(0, array.length());
        assertEquals(null, array.pop());
        assertEquals(null, array.remove(0));
        assertEquals(null, array.get(0));
    }

    @Test
    @DisplayName("Check Insert")
    default void checkInsert() {
        T array = this.createDynamicArray();

        // all of these should not be inserted because out of bounds index
        array.insert(69, 0);
        array.insert(69, -1);
        array.insert(69, 1);
        assertEquals(0, array.length());

        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);

        // should be inserted
        array.insert(69, 0);
        array.insert(420, 2);
        array.insert(96, 7);

        // should not be inserted
        array.insert(420, -1);
        array.insert(500, array.length());

        assertEquals(11, array.length());

        assertEquals(69, array.get(0));
        assertEquals(0, array.get(1));
        assertEquals(420, array.get(2));
        assertEquals(1, array.get(3));
        assertEquals(2, array.get(4));
        assertEquals(3, array.get(5));
        assertEquals(4, array.get(6));
        assertEquals(96, array.get(7));
        assertEquals(5, array.get(8));
        assertEquals(6, array.get(9));
        assertEquals(7, array.get(10));
    }

    @Test
    @DisplayName("Check remove")
    default void checkRemove() {
        T array = this.createDynamicArray();

        assertEquals(null, array.remove(0));
        assertEquals(null, array.remove(-1));
        assertEquals(null, array.remove(-1));

        // pushing a few things into the array so we can try removing them
        array.push(0); //
        array.push(1);
        array.push(2);
        array.push(3); //
        array.push(4);
        array.push(5);
        array.push(6); //
        array.push(7); //

        assertEquals(7, array.remove(7));
        assertEquals(7, array.length());

        assertEquals(0, array.remove(0));
        assertEquals(6, array.length());

        assertEquals(6, array.remove(5));
        assertEquals(5, array.length());

        assertEquals(3, array.remove(2));
        assertEquals(4, array.length());

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(4, array.get(2));
        assertEquals(5, array.get(3));
    }
}

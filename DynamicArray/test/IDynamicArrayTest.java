import interfaces.IDynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface IDynamicArrayTest<T extends IDynamicArray> {
    T createDynamicArray();

    @Test
    @DisplayName("Push and Pop a Single Element")
    default void pushAndPopSingleElementTest() {
        T array = this.createDynamicArray();
        array.push(69);
        assertEquals(69, array.pop());
    }

    @Test
    @DisplayName("Push and Pop 16 Multiple Elements")
    default void pushAndPop16ElementsTest() {
        T array = this.createDynamicArray();
        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(14);
        array.push(15);

        assertEquals(15, array.pop());
        assertEquals(14, array.pop());
        assertEquals(13, array.pop());
        assertEquals(12, array.pop());
        assertEquals(11, array.pop());
        assertEquals(10, array.pop());
        assertEquals(9, array.pop());
        assertEquals(8, array.pop());
        assertEquals(7, array.pop());
        assertEquals(6, array.pop());
        assertEquals(5, array.pop());
        assertEquals(4, array.pop());
        assertEquals(3, array.pop());
        assertEquals(2, array.pop());
        assertEquals(1, array.pop());
        assertEquals(0, array.pop());
    }

    @Test
    @DisplayName("Test insert value")
    default void insertTest() {
        T array = this.createDynamicArray();

        // push 10 elements into the array
        for (int i = 0; i < 10; i += 1) {
            array.push(i);
        }

        array.insert(69, 5);

        assertEquals(11, array.length());

        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
        assertEquals(2, array.get(2));
        assertEquals(3, array.get(3));
        assertEquals(4, array.get(4));
        assertEquals(69, array.get(5));   // inserted element
        assertEquals(5, array.get(6));
        assertEquals(6, array.get(7));
        assertEquals(7, array.get(8));
        assertEquals(8, array.get(9));
        assertEquals(9, array.get(10));
    }

    @Test
    @DisplayName("remove test")
    default void removeTest() {
        T array = this.createDynamicArray();

        // 10 elemente in das Array pushen
        for (int i = 0; i < 10; i += 1) {
            array.push(i);
        }

        assertEquals(10, array.length());
        int element = array.remove(7);
        assertEquals(7, element);

        assertEquals(9, array.length());

        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
        assertEquals(2, array.get(2));
        assertEquals(3, array.get(3));
        assertEquals(4, array.get(4));
        assertEquals(5, array.get(5));
        assertEquals(6, array.get(6));
        assertEquals(8, array.get(7)); // -> an dieser Stelle war das entfernte element
        assertEquals(9, array.get(8));

        // push 10 elements into the array
    }

    @Test
    @DisplayName(".length() check")
    default void lengthTest() {
        T array = this.createDynamicArray();

        // Initiale length sollte 0 sein
        assertEquals(0, array.length());

        // Nachdem ein element gepusht wird sollte length 1 sein
        array.push(69);
        assertEquals(1, array.length());

        // Nachdem dieses wieder gepoppt wird sollte die Laenge wieder 0 sein
        array.pop();
        assertEquals(0, array.length());


        // Nachdem wir 100 Elemente pushen sollte die Laenge 100 sein
        for (int i = 0; i < 100; i += 1) {
            array.push(i);
        }
        assertEquals(100, array.length());
    }
}

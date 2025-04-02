import interfaces.ILinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface ILinkedListTest<T extends ILinkedList> {
    T createLinkedList();

    @Test
    @DisplayName("Push and Pop a Single Element")
    default void pushAndPopSingleElementTest() {
        T list = this.createLinkedList();
        list.push(69);
        assertEquals(69, list.pop());
    }

    @Test
    @DisplayName("Push and Pop 16 Multiple Elements")
    default void pushAndPop16ElementsTest() {
        T array = this.createLinkedList();
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
        T list = this.createLinkedList();

        // push 10 elements into the array
        for (int i = 0; i < 10; i += 1) {
            list.push(i);
        }

        list.insert(69, 5);

        assertEquals(11, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(69, list.get(5));   // inserted element
        assertEquals(5, list.get(6));
        assertEquals(6, list.get(7));
        assertEquals(7, list.get(8));
        assertEquals(8, list.get(9));
        assertEquals(9, list.get(10));
    }

    @Test
    @DisplayName("remove test")
    default void removeTest() {
        T list = this.createLinkedList();

        // 10 elemente in das Array pushen
        for (int i = 0; i < 10; i += 1) {
            list.push(i);
        }

        assertEquals(10, list.length());
        int element = list.remove(7);
        assertEquals(7, element);

        assertEquals(9, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(8, list.get(7)); // -> an dieser Stelle war das entfernte element
        assertEquals(9, list.get(8));

        // push 10 elements into the array
    }

    @Test
    @DisplayName(".length() check")
    default void lengthTest() {
        T list = this.createLinkedList();

        // Initiale length sollte 0 sein
        assertEquals(0, list.length());

        // Nachdem ein element gepusht wird sollte length 1 sein
        list.push(69);
        assertEquals(1, list.length());

        // Nachdem dieses wieder gepoppt wird sollte die Laenge wieder 0 sein
        list.pop();
        assertEquals(0, list.length());


        // Nachdem wir 100 Elemente pushen sollte die Laenge 100 sein
        for (int i = 0; i < 100; i += 1) {
            list.push(i);
        }
        assertEquals(100, list.length());
    }
}

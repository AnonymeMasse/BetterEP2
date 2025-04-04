import interfaces.IDoublyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface IDoublyLinkedListTest<T extends IDoublyLinkedList> {
    T createDoublyLinkedList();

    @Test
    @DisplayName("Add Values and Check Length")
    default void addValuesAndCheckLength() {
        T list = this.createDoublyLinkedList();

        assertEquals(0, list.length());

        list.addFirst(0);
        assertEquals(1, list.length());

        list.addLast(0);
        assertEquals(2, list.length());

        list.addFirst(0);
        assertEquals(3, list.length());

        list.addLast(0);
        assertEquals(4, list.length());

        list.addFirst(0);
        assertEquals(5, list.length());

        list.addLast(0);
        assertEquals(6, list.length());

        list.addFirst(0);
        assertEquals(7, list.length());

        list.addLast(0);
        assertEquals(8, list.length());
    }

    @Test
    @DisplayName("Add Values and Check Order")
    default void addValuesAndCheckOrder() {
        T list = this.createDoublyLinkedList();

        list.addFirst(4);
        list.addLast(5);
        list.addFirst(3);
        list.addLast(6);
        list.addFirst(2);
        list.addLast(7);
        list.addFirst(1);
        list.addLast(8);
        list.addFirst(0);
        list.addLast(9);

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));
        assertEquals(8, list.get(8));
        assertEquals(9, list.get(9));
    }

    @Test
    @DisplayName("Check get on empty list")
    default void checkGetOnEmptyList() {
        T list = this.createDoublyLinkedList();
        assertEquals(null, list.get(0));
    }

    @Test
    @DisplayName("Check remove on empty List")
    default void checkRemoveOnEmptyList() {
        T list = this.createDoublyLinkedList();
        assertEquals(null, list.remove(0));
        assertEquals(null, list.removeFirst());
        assertEquals(null, list.removeLast());
    }

    @Test
    @DisplayName("Check Length on empty List")
    default void checkLengthOnEmptyList() {
        T list = this.createDoublyLinkedList();
        assertEquals(0, list.length());
    }

    @Test
    @DisplayName("Check insert on empty list")
    default void checkInsertOnEmptyList() {
        T list = this.createDoublyLinkedList();
        list.insert(69, 0);
        assertEquals(0, list.length());
    }

    @Test
    @DisplayName("Check Insert with invalid index")
    default void checkInsertWithInvalidIndex() {
        T list = this.createDoublyLinkedList();
        list.insert(69, 0);
        assertEquals(0, list.length());

        list.addFirst(420);

        list.insert(69, -1);
        list.insert(69, 2);
        list.insert(69, 400);

        assertEquals(1, list.length());
    }

    @Test
    @DisplayName("Check Insert")
    default void checkInsert() {
        T list = this.createDoublyLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));
        assertEquals(8, list.get(8));
        assertEquals(9, list.get(9));

        list.insert(69, 0);

        assertEquals(11, list.length());

        assertEquals(69, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(3, list.get(4));
        assertEquals(4, list.get(5));
        assertEquals(5, list.get(6));
        assertEquals(6, list.get(7));
        assertEquals(7, list.get(8));
        assertEquals(8, list.get(9));
        assertEquals(9, list.get(10));

        list.insert(420, 5);
        assertEquals(12, list.length());

        assertEquals(69, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(3, list.get(4));
        assertEquals(420, list.get(5));
        assertEquals(4, list.get(6));
        assertEquals(5, list.get(7));
        assertEquals(6, list.get(8));
        assertEquals(7, list.get(9));
        assertEquals(8, list.get(10));
        assertEquals(9, list.get(11));
    }

    @Test
    @DisplayName("Check RemoveLast")
    default void checkRemoveLast() {
        Integer removed;
        T list = this.createDoublyLinkedList();

        assertEquals(null, list.removeLast());

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);

        assertEquals(10, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));
        assertEquals(8, list.get(8));
        assertEquals(9, list.get(9));

        removed = list.removeLast();
        assertEquals(9, removed);

        assertEquals(9, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));
        assertEquals(8, list.get(8));

        removed = list.removeLast();
        assertEquals(8, removed);

        assertEquals(8, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));

        removed = list.removeLast();
        assertEquals(7, removed);
        removed = list.removeLast();
        assertEquals(6, removed);
        removed = list.removeLast();
        assertEquals(5, removed);
        removed = list.removeLast();
        assertEquals(4, removed);
        removed = list.removeLast();
        assertEquals(3, removed);
        removed = list.removeLast();
        assertEquals(2, removed);
        removed = list.removeLast();
        assertEquals(1, removed);
        removed = list.removeLast();
        assertEquals(0, removed);

        assertEquals(0, list.length());
        assertEquals(null, list.removeLast());
    }

    @Test
    @DisplayName("Check removeFirst")
    default void checkRemoveFirst() {
        Integer removed;
        T list = this.createDoublyLinkedList();

        assertEquals(null, list.removeFirst());

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);

        removed = list.removeFirst();
        assertEquals(0, removed);
        assertEquals(9, list.length());

        removed = list.removeFirst();
        assertEquals(1, removed);
        assertEquals(8, list.length());

        removed = list.removeFirst();
        assertEquals(2, removed);
        assertEquals(7, list.length());

        removed = list.removeFirst();
        assertEquals(3, removed);
        assertEquals(6, list.length());

        removed = list.removeFirst();
        assertEquals(4, removed);
        assertEquals(5, list.length());

        removed = list.removeFirst();
        assertEquals(5, removed);
        assertEquals(4, list.length());

        removed = list.removeFirst();
        assertEquals(6, removed);
        assertEquals(3, list.length());

        removed = list.removeFirst();
        assertEquals(7, removed);
        assertEquals(2, list.length());

        removed = list.removeFirst();
        assertEquals(8, removed);
        assertEquals(1, list.length());

        removed = list.removeFirst();
        assertEquals(9, removed);
        assertEquals(0, list.length());

        removed = list.removeFirst();
        assertEquals(null, removed);
        assertEquals(0, list.length());
    }

    @Test
    @DisplayName("Check remove")
    default void checkRemove() {
        T list = this.createDoublyLinkedList();

        assertEquals(null, list.remove(0));
        assertEquals(null, list.remove(-1));
        assertEquals(null, list.remove(100));

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);

        list.insert(69, 0);
        list.insert(420, 5);

        assertEquals(420, list.remove(5));
        assertEquals(69, list.remove(0));
        assertEquals(null, list.remove(-10));
        assertEquals(null, list.remove(100));
        assertEquals(null, list.remove(list.length()));

        assertEquals(10, list.length());

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
        assertEquals(6, list.get(6));
        assertEquals(7, list.get(7));
        assertEquals(8, list.get(8));
        assertEquals(9, list.get(9));
    }
}

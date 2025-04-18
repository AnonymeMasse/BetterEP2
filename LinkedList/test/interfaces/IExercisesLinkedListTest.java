package interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface IExercisesLinkedListTest {
    IExercisesLinkedList createExercisesLinkedList();

    @Test
    @DisplayName("Check linkedListFromArray")
    default void checkLinkedListFromArray() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array = new int[0];
            ILinkedList list = exercises.linkedListFromArray(array);
            assertEquals(0, list.length());
        }

        {
            int[] array = new int[]{1};

            ILinkedList list = exercises.linkedListFromArray(array);

            assertEquals(1, list.length());
            assertEquals(1, list.get(0));
        }

        {
            int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
            ILinkedList list = exercises.linkedListFromArray(array);

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
        }
    }

    @Test
    @DisplayName("Check copyLinkedList")
    default void checkCopyLinkedList() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array = new int[]{};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList copy = exercises.copyLinkedList(list);

            assertEquals(0, copy.length());
            assertNotEquals(copy, list);
        }

        {
            int[] array = new int[]{1};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList copy = exercises.copyLinkedList(list);

            assertNotEquals(list, copy);
            assertEquals(1, copy.get(0));
            assertEquals(1, copy.length());
        }

        {
            int[] array = new int[]{0, 1, 2, 3, 4};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList copy = exercises.copyLinkedList(list);
            assertNotEquals(list, copy);

            assertEquals(5, copy.length());

            assertEquals(0, copy.get(0));
            assertEquals(1, copy.get(1));
            assertEquals(2, copy.get(2));
            assertEquals(3, copy.get(3));
            assertEquals(4, copy.get(4));
        }
    }

    @Test
    @DisplayName("Check mergeTwoSortedLinkedLists")
    default void checkMergeTwoSortedLinkedLists() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array0 = new int[]{1, 2, 3, 4};
            int[] array1 = new int[]{2, 3, 4, 5};

            ILinkedList list0 = exercises.linkedListFromArray(array0);
            ILinkedList list1 = exercises.linkedListFromArray(array1);

            ILinkedList list = exercises.mergeTwoSortedLinkedLists(list0, list1);

            assertEquals(8, list.length());

            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(2, list.get(2));
            assertEquals(3, list.get(3));
            assertEquals(3, list.get(4));
            assertEquals(4, list.get(5));
            assertEquals(4, list.get(6));
            assertEquals(5, list.get(7));
        }

        {
            int[] array0 = new int[]{};
            int[] array1 = new int[]{1, 2};

            ILinkedList list0 = exercises.linkedListFromArray(array0);
            ILinkedList list1 = exercises.linkedListFromArray(array1);

            ILinkedList list = exercises.mergeTwoSortedLinkedLists(list0, list1);

            assertEquals(2, list.length());

            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
        }
        {
            int[] array0 = new int[]{1, 2};
            int[] array1 = new int[]{};

            ILinkedList list0 = exercises.linkedListFromArray(array0);
            ILinkedList list1 = exercises.linkedListFromArray(array1);

            ILinkedList list = exercises.mergeTwoSortedLinkedLists(list0, list1);

            assertEquals(2, list.length());

            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
        }

        {
            int[] array0 = new int[]{};
            int[] array1 = new int[]{};

            ILinkedList list0 = exercises.linkedListFromArray(array0);
            ILinkedList list1 = exercises.linkedListFromArray(array1);

            ILinkedList list = exercises.mergeTwoSortedLinkedLists(list0, list1);

            assertEquals(0, list.length());
        }

        {
            int[] array0 = new int[]{0, 1, 2};
            int[] array1 = new int[]{3, 4, 5};

            ILinkedList list0 = exercises.linkedListFromArray(array0);
            ILinkedList list1 = exercises.linkedListFromArray(array1);

            ILinkedList list = exercises.mergeTwoSortedLinkedLists(list0, list1);

            assertEquals(6, list.length());

            assertEquals(0, list.get(0));
            assertEquals(1, list.get(1));
            assertEquals(2, list.get(2));
            assertEquals(3, list.get(3));
            assertEquals(4, list.get(4));
            assertEquals(5, list.get(5));
        }
    }

    @Test
    @DisplayName("Check getLowerHalfOfLinkedList")
    default void checkGetLowerHalfOfLinkedList() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array = new int[]{1};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList lower = exercises.getLowerHalfOfLinkedList(list);

            assertEquals(0, lower.length());
        }

        {
            int[] array = new int[]{1, 2};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList lower = exercises.getLowerHalfOfLinkedList(list);

            assertEquals(1, lower.length());
            assertEquals(1, lower.get(0));
        }

        {
            int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList lower = exercises.getLowerHalfOfLinkedList(list);

            assertEquals(3, lower.length());

            assertEquals(0, lower.get(0));
            assertEquals(1, lower.get(1));
            assertEquals(2, lower.get(2));
        }
    }

    @Test
    @DisplayName("Check getUpperHalfOfLinkedList")
    default void checkGetUpperHalfOfLinkedList() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array = new int[]{1};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList upper = exercises.getUpperHalfOfLinkedList(list);

            assertEquals(1, upper.length());
            assertEquals(1, upper.get(0));
        }

        {
            int[] array = new int[]{1, 2};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList upper = exercises.getUpperHalfOfLinkedList(list);

            assertEquals(1, upper.length());
            assertEquals(2, upper.get(0));
        }

        {
            int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList upper = exercises.getUpperHalfOfLinkedList(list);

            assertEquals(4, upper.length());

            assertEquals(3, upper.get(0));
            assertEquals(4, upper.get(1));
            assertEquals(5, upper.get(2));
            assertEquals(6, upper.get(3));
        }
    }

    @Test
    @DisplayName("Check mergeSortLinekdList")
    default void mergeSortLinkedList() {
        IExercisesLinkedList exercises = this.createExercisesLinkedList();

        {
            int[] array = new int[]{1};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList sorted = exercises.mergeSortLinkedList(list);

            assertEquals(1, sorted.length());
            assertEquals(1, sorted.get(0));
        }

        {
            int[] array = new int[]{2, 1, 0, 3, 5, 4};
            ILinkedList list = exercises.linkedListFromArray(array);
            ILinkedList sorted = exercises.mergeSortLinkedList(list);

            assertEquals(6, sorted.length());
            assertEquals(0, sorted.get(0));
            assertEquals(1, sorted.get(1));
            assertEquals(2, sorted.get(2));
            assertEquals(3, sorted.get(3));
            assertEquals(4, sorted.get(4));
            assertEquals(5, sorted.get(5));
        }
    }
}

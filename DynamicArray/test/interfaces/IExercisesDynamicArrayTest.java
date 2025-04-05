package interfaces;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public interface IExercisesDynamicArrayTest<D extends IDynamicArray, T extends IExercisesDynamicArray<D>> {
    T createExercisesDynamicArray();

    @Test
    @DisplayName("Check dynamicArrayFromArray")
    default void checkDynamicArrayFromArray() {
        T exercises = this.createExercisesDynamicArray();

        // check for empty array
        {
            int[] input = new int[]{};
            D array = exercises.dynamicArrayFromArray(input);
            assertEquals(0, array.length());
        }

        // check with array with length 1
        {
            int[] input = new int[]{1};
            D array = exercises.dynamicArrayFromArray(input);
            assertEquals(1, array.length());
            assertEquals(1, array.get(0));
        }

        // check with multiple elements
        {
            int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            D array = exercises.dynamicArrayFromArray(input);

            assertEquals(10, array.length());

            assertEquals(0, array.get(0));
            assertEquals(1, array.get(1));
            assertEquals(2, array.get(2));
            assertEquals(3, array.get(3));
            assertEquals(4, array.get(4));
            assertEquals(5, array.get(5));
            assertEquals(6, array.get(6));
            assertEquals(7, array.get(7));
            assertEquals(8, array.get(8));
            assertEquals(9, array.get(9));
        }
    }

    @Test
    @DisplayName("Check copyDynamicArray")
    default void checkCopyDynamicArray() {
        T exercises = this.createExercisesDynamicArray();

        // check for empty array
        {
            int[] input = new int[]{};
            D input_array = exercises.dynamicArrayFromArray(input);
            D array = exercises.copyDynamicArray(input_array);
            assertEquals(0, array.length());
            assertNotEquals(input_array, array);
        }

        // check with array with length 1
        {
            int[] input = new int[]{1};

            D input_array = exercises.dynamicArrayFromArray(input);
            D array = exercises.copyDynamicArray(input_array);
            assertNotEquals(input_array, array);

            assertEquals(1, array.length());
            assertEquals(1, array.get(0));
        }

        // check with multiple elements
        {
            int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            D input_array = exercises.dynamicArrayFromArray(input);
            D array = exercises.copyDynamicArray(input_array);
            assertNotEquals(input_array, array);

            assertEquals(10, array.length());

            assertEquals(0, array.get(0));
            assertEquals(1, array.get(1));
            assertEquals(2, array.get(2));
            assertEquals(3, array.get(3));
            assertEquals(4, array.get(4));
            assertEquals(5, array.get(5));
            assertEquals(6, array.get(6));
            assertEquals(7, array.get(7));
            assertEquals(8, array.get(8));
            assertEquals(9, array.get(9));
        }
    }

    @Test
    @DisplayName("Check reverseDynamicArray")
    default void checkReverseDynamicArray() {
        T exercises = this.createExercisesDynamicArray();

        // check for empty array
        {
            int[] input = new int[]{};
            D array = exercises.dynamicArrayFromArray(input);
            array = exercises.reverseDynamicArray(array);

            assertEquals(0, array.length());
        }

        // check for array with length 1
        {
            int[] input = new int[]{1};
            D array = exercises.dynamicArrayFromArray(input);
            array = exercises.reverseDynamicArray(array);

            assertEquals(1, array.length());
            assertEquals(1, array.get(0));
        }

        // check for array with multiple elements
        {
            int[] input = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
            D array = exercises.dynamicArrayFromArray(input);
            array = exercises.reverseDynamicArray(array);

            assertEquals(10, array.length());

            assertEquals(0, array.get(0));
            assertEquals(1, array.get(1));
            assertEquals(2, array.get(2));
            assertEquals(3, array.get(3));
            assertEquals(4, array.get(4));
            assertEquals(5, array.get(5));
            assertEquals(6, array.get(6));
            assertEquals(7, array.get(7));
            assertEquals(8, array.get(8));
            assertEquals(9, array.get(9));
        }
    }

    @Test
    @DisplayName("Check mergeTwoSortedDynamicArrays")
    default void checkMergeTwoSortedDynamicArrays() {
        T exercises = this.createExercisesDynamicArray();

        // check with empty
        {
            int[] inputBase0 = new int[]{};
            int[] inputBase1 = new int[]{};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            D array = exercises.mergeTwoSortedDynamicArrays(input0, input1);
            assertEquals(0, array.length());
        }

        // check with input0 empty
        // check with empty
        {
            int[] inputBase0 = new int[]{};
            int[] inputBase1 = new int[]{0, 1};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            D array = exercises.mergeTwoSortedDynamicArrays(input0, input1);
            assertEquals(2, array.length());

            assertEquals(0, array.get(0));
            assertEquals(1, array.get(1));
        }

        // check with input1 empty
        // check with empty
        {
            int[] inputBase0 = new int[]{0, 1};
            int[] inputBase1 = new int[]{};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            D array = exercises.mergeTwoSortedDynamicArrays(input0, input1);
            assertEquals(2, array.length());

            assertEquals(0, array.get(0));
            assertEquals(1, array.get(1));
        }

        // check with both full
        {
            int[] inputBase0 = new int[]{0, 1};
            int[] inputBase1 = new int[]{-1, 1, 2, 3};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            D array = exercises.mergeTwoSortedDynamicArrays(input0, input1);
            assertEquals(6, array.length());

            assertEquals(-1, array.get(0));
            assertEquals(0, array.get(1));
            assertEquals(1, array.get(2));
            assertEquals(1, array.get(3));
            assertEquals(2, array.get(4));
            assertEquals(3, array.get(5));
        }
    }

    @Test
    @DisplayName("Check findMedianOfTwoSortedArrays")
    default void checkFindMedianOfTwoSortedArrays() {
        T exercises = this.createExercisesDynamicArray();

        // test case 0
        {
            int[] inputBase0 = new int[]{0, 1};
            int[] inputBase1 = new int[]{-1};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            int median = exercises.findMedianOfTwoSortedDynamicArrays(input0, input1);
            assertEquals(0, median);
        }

        // test case 1
        {
            int[] inputBase0 = new int[]{0, 1, 2, 3};
            int[] inputBase1 = new int[]{-1, 4, 5, 6};

            D input0 = exercises.dynamicArrayFromArray(inputBase0);
            D input1 = exercises.dynamicArrayFromArray(inputBase1);

            int median = exercises.findMedianOfTwoSortedDynamicArrays(input0, input1);
            assertEquals(3, median);
        }
    }

    @Test
    @DisplayName("Check findLocalMinima")
    default void checkFindLocalMinima() {
        T exercises = this.createExercisesDynamicArray();

        // test with empty input
        {
            int[] inputBase = new int[]{};
            D input = exercises.dynamicArrayFromArray(inputBase);
            D array = exercises.findLocalMinima(input);
            assertEquals(0, array.length());
        }

        // test with sorted input
        {
            int[] inputBase = new int[]{0, 1, 2, 3, 4, 5};
            D input = exercises.dynamicArrayFromArray(inputBase);
            D array = exercises.findLocalMinima(input);
            assertEquals(0, array.length());
        }

        // test with sorted input
        {
            int[] inputBase = new int[]{0, 1, 2, 1, 3, 4, 2, 5};
            D input = exercises.dynamicArrayFromArray(inputBase);
            D array = exercises.findLocalMinima(input);
            assertEquals(2, array.length());

            assertEquals(1, array.get(0));
            assertEquals(2, array.get(1));
        }
    }

    @Test
    @DisplayName("Check isArrayPalindrom")
    default void checkIsArrayPalindrom() {
        T exercises = this.createExercisesDynamicArray();

        // test with empty input
        {
            int[] inputBase = new int[]{};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(false, isPalindrom);
        }

        // test with input
        {
            int[] inputBase = new int[]{1, 2, 2, 1};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(true, isPalindrom);
        }

        // test with input
        {
            int[] inputBase = new int[]{1, 2, 3, 3, 2, 1};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(true, isPalindrom);
        }

        // test with input
        {
            int[] inputBase = new int[]{69, 420, 420, 69};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(true, isPalindrom);
        }

        // test with input
        {
            int[] inputBase = new int[]{69, 420, 420, 69, 1};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(false, isPalindrom);
        }

        // test with input
        {
            int[] inputBase = new int[]{2, 1, 69, 420, 420, 69, 1};
            D input = exercises.dynamicArrayFromArray(inputBase);
            boolean isPalindrom = exercises.isArrayAPalindrome(input);
            assertEquals(false, isPalindrom);
        }
    }
}

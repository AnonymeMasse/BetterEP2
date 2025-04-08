package examples;

import interfaces.IDynamicArray;
import interfaces.IExercisesDynamicArray;

public class ExampleExercisesDynamicArray implements IExercisesDynamicArray {
    /**
     * creates a dynamic array from input and returns it
     * the values should be stored in the same order as in input
     *
     * @param input input array, from which the dynamic array should be created
     *              - might be empty -> return empty dynamic array
     *              - might be null  -> return empty dynamic array
     *              - may be altered
     * @return a dynamic array with the same values as input
     */
    @Override
    public IDynamicArray dynamicArrayFromArray(int[] input) {
        ExampleDynamicArray array = new ExampleDynamicArray();

        // push every value in input into array
        for (int i = 0; i < input.length; i += 1) {
            array.push(input[i]);
        }

        return array;
    }

    /**
     * create a copy of input
     *
     * @param input dynamic array which should be copied
     *              - might be empty -> return empty dynamic array
     *              - should not be altered
     * @return a copy of input
     */
    @Override
    public IDynamicArray copyDynamicArray(IDynamicArray input) {
        ExampleDynamicArray array = new ExampleDynamicArray();

        // push every value in input into array
        for (int i = 0; i < input.length(); i += 1) {
            array.push(input.get(i));
        }

        return array;
    }

    /**
     * reverse the ordering of input
     *
     * @param input input array
     *              - may be altered
     *              - might be empty -> return empty dynamic array
     * @return a dynamic array with all values from input in reverse order
     */
    @Override
    public IDynamicArray reverseDynamicArray(IDynamicArray input) {
        ExampleDynamicArray array = new ExampleDynamicArray();

        // we pop every value from the array this produces a reverse order
        // we stop popping when there's no longer stuff to pop
        Integer value = input.pop();
        while (value != null) {
            array.push(value);
            value = input.pop();
        }

        // note: you could also iterate in reverse over input.. so from length() - 1 to (including) 0

        return array;
    }

    /**
     * merge two sorted (ascending order) dynamic arrays into a single sorted dynamic array
     *
     * @param input0 sorted (ascending order) input array
     *               - might be empty
     *               - may be altered
     * @param input1 sorted (ascending order) input array
     *               - might be empty
     *               - may be altered
     * @return a sorted (ascending order) dynamic array containing all values from input0 and input1
     */
    @Override
    public IDynamicArray mergeTwoSortedDynamicArrays(IDynamicArray input0, IDynamicArray input1) {
        ExampleDynamicArray array = new ExampleDynamicArray();

        int index0 = 0;
        int index1 = 0;

        // iterate over input0 and input1, push the smaller element each iteration
        while (index0 < input0.length() && index1 < input1.length()) {
            int value0 = input0.get(index0);
            int value1 = input1.get(index1);

            if (value0 < value1) {
                array.push(value0);
                index0 += 1;
            } else {
                array.push(value1);
                index1 += 1;
            }
        }

        // push the remainder of input0 into array
        for (; index0 < input0.length(); index0 += 1) {
            array.push(input0.get(index0));
        }

        // push the remainder of input1 into array
        for (; index1 < input1.length(); index1 += 1) {
            array.push(input1.get(index1));
        }

        return array;
    }

    /**
     * returns the median of two sorted arrays
     * median: is the value stored at length() / 2
     *
     * @param input0 sorted (ascending order) input array
     *               - may be altered
     * @param input1 sorted (ascending order) input array
     *               - may be altered
     * @return the median of the two sorted inputs
     */
    @Override
    public int findMedianOfTwoSortedDynamicArrays(IDynamicArray input0, IDynamicArray input1) {
        IDynamicArray array = mergeTwoSortedDynamicArrays(input0, input1);
        return array.get(array.length() / 2);
    }

    /**
     * returns an array with all local minima of values
     * local minima: a value in input where the value left of it is bigger and the value right of it is bigger
     * - values at index: 0 and index: length() - 1 cannot be local minima
     * For example:
     * the local minima of the following array:
     * [0, 1, 2, 3 1, 2, 3, 2, 4]
     * would be:
     * [1, 2]
     * <p>
     * the local minima of the following array:
     * [0, 1, 2, 3, 4, 5]
     * would be:
     * []
     * <p>
     * note: this is not a real definition of local minima
     *
     * @param input input array
     *              - might be empty
     *              - may be altered
     * @return a dynamic array containing all local minima of input
     */
    @Override
    public IDynamicArray findLocalMinima(IDynamicArray input) {
        ExampleDynamicArray array = new ExampleDynamicArray();

        // iterate only from 1 to length() - 1 not over full array
        for (int i = 1; i < input.length() - 1; i += 1) {
            // if the left element is smaller we don't have a local minima
            if (input.get(i - 1) <= input.get(i)) {
                continue;
            }

            // if the right element is smaller we don't have a local minima
            if (input.get(i + 1) <= input.get(i)) {
                continue;
            }

            array.push(input.get(i));
        }
        return array;
    }

    /**
     * checks if input is a palindrom array
     * <p>
     * palindrom array an array where the first value is the same as the last value, the second first value is the
     * same as the second last value etc.
     * <p>
     * For example:
     * [1, 2, 3, 3, 2, 1]
     * [0, 0]
     * [1, 1, 0, 0, 1, 1]
     * [69, 420, 420, 69]
     * are a palindroms
     * <p>
     * [1, 2, 3, 4, 5]
     * []
     * [1, 2, 3, 1]
     * <p>
     * are not palindroms
     * <p>
     * palindrom
     *
     * @param input input array
     *              - length() is even
     *              - may be empty
     *              - may be altered
     * @return true if input is a palindrom and false if it is not
     */
    @Override
    public boolean isArrayAPalindrome(IDynamicArray input) {
        if (input.length() == 0) {
            return false;
        }

        // we can detect palindromes by reversing the list and comparing pair wise
        IDynamicArray reversed = reverseDynamicArray(copyDynamicArray(input));

        // note: we need to copy input because reverse may alter its parameters

        for (int i = 0; i < input.length(); i += 1) {
            // we don't have a palindrom
            if ((int) input.get(i) != (int) reversed.get(i)) {
                return false;
            }
            // note: we need to cast here otherwise the addresses of the Integer classes will be compared and not the
            //       ints themselves
        }

        return true;
    }
}

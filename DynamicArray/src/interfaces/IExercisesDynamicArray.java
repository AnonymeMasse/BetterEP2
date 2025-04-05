package interfaces;

public interface IExercisesDynamicArray<T extends IDynamicArray> {
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
    T dynamicArrayFromArray(int[] input);

    /**
     * create a copy of input
     *
     * @param input dynamic array which should be copied
     *              - might be empty -> return empty dynamic array
     *              - should not be altered
     * @return a copy of input
     */
    T copyDynamicArray(T input);

    /**
     * reverse the ordering of input
     *
     * @param input input array
     *              - may be altered
     *              - might be empty -> return empty dynamic array
     * @return a dynamic array with all values from input in reverse order
     */
    T reverseDynamicArray(T input);

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
    T mergeTwoSortedDynamicArrays(T input0, T input1);

    /**
     * returns the median of two sorted arrays
     * median: is the value stored at length() / 2
     *
     * @param input0 sorted (ascending order) input array
     *               - is not empty
     *               - may be altered
     * @param input1 sorted (ascending order) input array
     *               - is not empty
     *               - may be altered
     * @return the median of the two sorted inputs
     */
    int findMedianOfTwoSortedDynamicArrays(T input0, T input1);

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
    T findLocalMinima(T input);

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
    boolean isArrayAPalindrome(T input);
}

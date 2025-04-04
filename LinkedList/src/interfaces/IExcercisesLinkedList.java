package interfaces;

public interface IExcercisesLinkedList<T extends ILinkedList> {

    /**
     * add every single value into a linked list and return it the original order of the values should be preserved
     *
     * @param array array with values which should be added to a linked list
     *              - might be empty
     *              - may be altered
     * @return      a list with all values from array in the same order as in array
     */
    T linkedListFromArray(int[] array);

    /**
     * constructs a new linked list and copies all values (in the same order) from input into it
     * @param input list which should be copied
     *              - should not be altered
     *
     * @return      a copy of input
     */
    T copyLinkedList(T input);

    /**
     * merge the two sorted lists a and b into a new linked list and return it
     *
     * note: everything is sorted in ascending order
     *
     * @param a sorted linked list
     *          - might be empty
     *          - may be altered
     * @param b sorted linked list
     *          - might be empty
     *          - may be altered
     * @return a sorted linked list (ascending order) with every value from a and b
     */
    T mergeTwoSortedLinkedLists(T a, T b);

    /**
     * constructs a new linked list and fills it with the lower half of input
     *
     * lower half means index 0 up to (not including)  input.length() / 2
     *
     * @param input with the values for the new list
     *              - may be altered
     *
     * @return a new linked list containing the lower half (in the same order) of input
     */
    T getLowerHalfOfLinkedList(T input);

    /**
     * constructs a new linked list and fills it with the upper half of input
     *
     * upper half means index input.length() / 2 up to (not including) input.length()
     *
     * @param input with the values for the new list
     *              - may be altered
     *
     * @return a new linked list containing the lower half (in the same order) of input
     */
    T getUpperHalfOfLinkedList(T input);

    /**
     * sort input with merge sort using the earlier methods: getLowerHalfOfLinkedList, getUpperHalfOfLinkedList, and mergeTwoSortedLinkedLists
     *
     * merge sort splits the given input recursively into a lower and an upper half
     * until each half is either empty or holds exactly on value then each have is merged again
     *
     * for a deeper explanation of mergesort see:
     * - https://en.wikipedia.org/wiki/Merge_sort
     * - https://developer.nvidia.com/blog/merge-sort-explained-a-data-scientists-algorithm-guide/
     *
     * @param input linked list which should be sorted
     *              - should not be altered
     *
     * @return      a new sorted linked list
     */
    T mergeSortLinkedList(T input);
}

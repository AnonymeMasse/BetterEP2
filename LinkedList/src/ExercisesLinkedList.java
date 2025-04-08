import interfaces.IExercisesLinkedList;
import interfaces.ILinkedList;

public class ExercisesLinkedList implements IExercisesLinkedList {

    // ---------------------------------------------------------------------------------------------------------------//
    // GENERAL NOTE:    these exercises are meant to be solved top too bottom and are building on one another         //
    //                  so if tests of linkedListFromArray is failing fix this first and fix the others after that    //
    // ---------------------------------------------------------------------------------------------------------------//

    /**
     * add every single value into a linked list and return it the original order of the values should be preserved
     *
     * @param array array with values which should be added to a linked list
     *              - might be empty
     *              - may be altered
     * @return a list with all values from array in the same order as in array
     */
    @Override
    public ILinkedList linkedListFromArray(int[] array) {
        // TODO: implement method
        return null;
    }

    /**
     * constructs a new linked list and copies all values (in the same order) from input into it
     *
     * @param input list which should be copied
     *              - should not be altered
     * @return a copy of input
     */
    @Override
    public ILinkedList copyLinkedList(ILinkedList input) {
        // TODO: implement method
        return null;
    }

    /**
     * merge the two sorted lists a and b into a new linked list and return it
     * <p>
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
    @Override
    public ILinkedList mergeTwoSortedLinkedLists(ILinkedList a, ILinkedList b) {
        // TODO: implement method
        return null;
    }

    /**
     * constructs a new linked list and fills it with the lower half of input
     * <p>
     * lower half means index 0 up to (not including)  input.length() / 2
     *
     * @param input with the values for the new list
     *              - may be altered
     * @return a new linked list containing the lower half (in the same order) of input
     */
    @Override
    public ILinkedList getLowerHalfOfLinkedList(ILinkedList input) {
        // TODO: implement method
        return null;
    }

    /**
     * constructs a new linked list and fills it with the upper half of input
     * <p>
     * upper half means index input.length() / 2 up to (not including) input.length()
     *
     * @param input with the values for the new list
     *              - may be altered
     * @return a new linked list containing the lower half (in the same order) of input
     */
    @Override
    public ILinkedList getUpperHalfOfLinkedList(ILinkedList input) {
        // TODO: implement method
        return null;
    }

    /**
     * sort input with merge sort using the earlier methods: getLowerHalfOfILinkedList, getUpperHalfOfILinkedList, and mergeTwoSortedILinkedLists
     * <p>
     * merge sort splits the given input recursively into a lower and an upper half
     * until each half is either empty or holds exactly on value then each have is merged again
     * <p>
     * for a deeper explanation of mergesort see:
     * - https://en.wikipedia.org/wiki/Merge_sort
     * - https://developer.nvidia.com/blog/merge-sort-explained-a-data-scientists-algorithm-guide/
     *
     * @param input linked list which should be sorted
     *              - should not be altered
     * @return a new sorted linked list
     */
    @Override
    public ILinkedList mergeSortLinkedList(ILinkedList input) {
        // TODO: implement method
        return null;
    }
}

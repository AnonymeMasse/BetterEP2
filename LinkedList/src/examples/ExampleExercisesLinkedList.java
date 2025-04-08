package examples;

import interfaces.IExercisesLinkedList;
import interfaces.ILinkedList;

public class ExampleExercisesLinkedList implements IExercisesLinkedList {
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
        ExampleLinkedList list = new ExampleLinkedList();

        // loop over array and add every value to list
        for (int i = 0; i < array.length; i += 1) {
            list.addLast(array[i]);
        }

        return list;
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
        ExampleLinkedList list = new ExampleLinkedList();

        // loop over input and add every value to list
        for (int i = 0; i < input.length(); i += 1) {
            list.addLast(input.get(i));
        }

        return list;
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
        Integer valueA = a.removeFirst();
        Integer valueB = b.removeFirst();

        ExampleLinkedList list = new ExampleLinkedList();

        // this loop will break if either a or b is empty
        while (valueA != null && valueB != null) {

            // here we now that neither valueA nor valueB is empty therefore we can compare them safely

            // if valueA is smaller add that to the list and get the next valueA from a
            if (valueA < valueB) {
                list.addLast(valueA);
                valueA = a.removeFirst();
            }
            // otherwise add valueB to the list and get the next valueB from b
            else {
                list.addLast(valueB);
                valueB = b.removeFirst();
            }
        }

        // above loop broke because either a or b is empty

        // loop over all values still present in a and add them to list
        // this does nothing if a is empty
        while (valueA != null) {
            list.addLast(valueA);
            valueA = a.removeFirst();
        }

        // loop over all values still present in b and add them to list
        // this does nothing if b is empty
        while (valueB != null) {
            list.addLast(valueB);
            valueB = b.removeFirst();
        }

        return list;
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
        ExampleLinkedList list = new ExampleLinkedList();

        // iterate over lower half of input and add it to list
        for (int i = 0; i < input.length() / 2; i += 1) {
            list.addLast(input.get(i));
        }

        return list;
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

        ExampleLinkedList list = new ExampleLinkedList();

        // iterate over upper half of list and add it to list
        for (int i = input.length() / 2; i < input.length(); i += 1) {
            list.addLast(input.get(i));
        }

        return list;
    }

    /**
     * sort input with merge sort using the earlier methods: getLowerHalfOfLinkedList, getUpperHalfOfLinkedList, and mergeTwoSortedLinkedLists
     * <p>
     * merge sort splits the given input recursively into a lower and an upper half
     * until each half is either empty or holds exactly on value then each have is merged again
     * <p>
     * for a deeper explanation of mergesort see:
     * - https://en.wikipedia.org/wiki/Merge_sort
     * - https://developer.nvidia.com/blog/merge-sort-explained-a-data-scientists-algorithm-guide/
     * - or AlgoDat LVA
     *
     * @param input linked list which should be sorted
     *              - should not be altered
     * @return a new sorted linked list
     */
    @Override
    public ILinkedList mergeSortLinkedList(ILinkedList input) {
        // check if lists are two small to be split again
        // if so the lists are sorted therefore they can be returned as sorted
        // copy here because we should return a 'new' linked list
        if (input.length() == 0) {
            return copyLinkedList(input);
        }
        if (input.length() == 1) {
            return copyLinkedList(input);
        }

        // split list into lower and upper
        // we need the copy again because getLowerHalfOfLinkedList / getUpperHalfOfLinkedList may alter the input
        ILinkedList lower = getLowerHalfOfLinkedList(copyLinkedList(input));
        ILinkedList upper = getUpperHalfOfLinkedList(copyLinkedList(input));

        // sort the two half's
        lower = mergeSortLinkedList(lower);
        upper = mergeSortLinkedList(upper);

        // merge the two sorted half's back together
        return mergeTwoSortedLinkedLists(lower, upper);
    }
}

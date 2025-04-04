import interfaces.IDoublyLinkedList;

public class DoublyLinkedList implements IDoublyLinkedList {
    /**
     * Nested class for the Node as a Node without a Linked List is sorta wrong
     * for more information about nested classes see:
     * https://www.w3schools.com/java/java_inner_classes.asp
     * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     *
     * About if you should use nested classes see:
     * https://stackoverflow.com/questions/1028850/are-inner-classes-commonly-used-in-java-are-they-bad
     */
    private static class Node {
        public int value;
        public Node next;
        public Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    // TODO: private object member variables

    /**
     * construct a new empty list
     */
    public DoublyLinkedList() {
        // TODO: implement method
    }

    /**
     * adds `value` to the end of the list
     *
     * @param value value to be added to the end of the list
     */
    @Override
    public void addLast(int value) {
        // TODO: implement method
    }

    /**
     * adds `value` to the front of the list
     *
     * @param   value value to be added to the front of the list
     */
    @Override
    public void addFirst(int value) {
        // TODO: implement method

    }

    /**
     * inserts `value` at position `index` into the list
     *
     * @param value value to be inserted into the list
     * @param index index at which `value` will be inserted
     */
    @Override
    public void insert(int value, int index) {
        // TODO: implement method

    }

    /**
     * get the value stored at `index` or `null` if index is invalid
     *
     * @param   index of the looked for value in the list
     * @return  value stored at `index` or `null` if `index < 0` or `index >= this.length()`
     */
    @Override
    public Integer get(int index) {
        // TODO: implement method
        return 0;
    }

    /**
     * remove the last value in the list and return it
     *
     * @return  either the last value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeLast() {
        // TODO: implement method
        return 0;
    }

    /**
     * remove the first value in the list and return it
     * @return  either the first value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeFirst() {
        // TODO: implement method
        return 0;
    }

    /**
     * remove the value stored at index from the list and return it
     * @param index     index of the to be removed value
     * @return          either the value of the node stored at `index` or `null` if
     *                  - the list is empty
     *                  - `index < 0`
     *                  - `index >= this.length()`
     */
    @Override
    public Integer remove(int index) {
        // TODO: implement method
        return 0;
    }

    /**
     * get the number of values stored in the list
     * @return  number of values stored in the list
     */
    @Override
    public int length() {
        // TODO: implement method
        return 0;
    }
}

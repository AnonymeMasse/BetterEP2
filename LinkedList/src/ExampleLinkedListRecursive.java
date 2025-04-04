import interfaces.ILinkedList;

public class ExampleLinkedListRecursive implements ILinkedList {
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

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    /**
     * construct a new empty list
     */
    public ExampleLinkedListRecursive() {
        this.head = null;
    }

    /**
     * adds `value` to the end of the list
     *
     * @param value value to be added to the end of the list
     */
    @Override
    public void addLast(int value) {
        this.addLastHelper(null, this.head, value);
    }

    /**
     * iterates through nodes until `current` becomes `null` and `parent.next` is updated to `value`
     *
     * @param parent    parent node of `current`
     * @param current   current node which is to be expected
     * @param value     value to be inserted
     */
    private void addLastHelper(Node parent, Node current, int value) {
        // if `current == null` -> we have reached the end of the list... `parent` is reference to last element
        if (current == null) {
            Node newNode = new Node(value);

            // if the `parent` is also `null` the list was empty
            if (parent == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
            return;
        }

        // otherwise we call the function recursively with `current` as parent and `current.next` as the new `current`
        this.addLastHelper(current, current.next, value);
    }

    /**
     * adds `value` to the front of the list
     *
     * @param value value to be added to the front of the list
     */
    @Override
    public void addFirst(int value) {
        // note: we don't need to check for empty list
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    /**
     * inserts `value` at position `index` into the list
     *
     * @param value value to be inserted into the list
     * @param index index at which `value` will be inserted
     */
    @Override
    public void insert(int value, int index) {
        // check if index is in bounds
        if (index < 0) {
            return;
        }

        // upper bounds check is handled in the helper method
        this.insertHelper(null, this.head, value, index);
    }

    private void insertHelper(Node parent, Node current, int value, int index) {
        // check if a node with the given index even exists
        if (current == null) {
            return;
        }

        // we have found our node at index and its parent
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = current;
            // if the parent is null index was 0
            if (parent == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
            return;
        }

        // otherwise call function recursively with current as the new parent and current.next as the new current
        // and a decremented index
        this.insertHelper(current, current.next, value, index - 1);
    }

    /**
     * get the value stored at `index` or `null` if index is invalid
     *
     * @param   index of the looked for value in the list
     * @return  value stored at `index` or `null` if `index < 0` or `index >= this.length()`
     */
    @Override
    public Integer get(int index) {
        // check if index is in bounds
        if (index < 0) {
            return null;
        }
        // upper bounds check will is handled in the helper

        // call helper
        return this.getHelper(this.head, index);
    }

    /**
     * recursively finds node at index
     * @param current   current node
     * @param index     index we are looking for
     * @return          either value of node at index or null if index is out of bounds
     */
    private Integer getHelper(Node current, int index) {
        // list has no node at index
        if (current == null) {
            return null;
        }

        // we have found our node
        if (index == 0) {
            return current.value;
        }

        // check the next node
        return this.getHelper(current.next, index - 1);
    }

    /**
     * remove the last value in the list and return it
     *
     * @return  either the last value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeLast() {
        // check if list is empty
        if (this.head == null) {
            return null;
        }
        return this.removeLastHelper(null, this.head);
    }

    /**
     * iterate until we find the last node and its parent than remove that node and return its value
     * @param parent    parent of current
     * @param current   current node
     * @return          the value of the last node in the list
     */
    private Integer removeLastHelper(Node parent, Node current) {
        // check if current is the last element
        if (current.next == null) {
            // if parent == null than current is the head of the list
            if (parent == null) {
                this.head = null;
            } else {
                parent.next = null;
            }
            return current.value;
        }
        return this.removeLastHelper(current, current.next);
    }

    /**
     * remove the first value in the list and return it
     * @return  either the first value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeFirst() {
        if (this.head == null) {
            return null;
        }
        int value = this.head.value;
        this.head = this.head.next;
        return value;
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
        if (this.head == null) {
            return null;
        }
        return this.removeHelper(null, this.head, index);
    }

    /**
     * iterate until we find node at index and its parent than remove that node and return its value
     * @param parent    parent node of current
     * @param current   current node
     * @param index     index to be looked for
     * @return          either the value of the node at index or null if the index is out of bounds
     */
    private Integer removeHelper(Node parent, Node current, int index) {
        // check if we have reached the end of the list
        if (current == null) {
            return null;
        }
        // check if we have reached our desired node
        if (index == 0) {
            // if the parent is null current is head
            if (parent == null) {
                this.head = current.next;
            } else {
                parent.next = current.next;
            }
            return current.value;
        }
        return this.removeHelper(current, current.next, index - 1);
    }

    /**
     * get the number of values stored in the list
     * @return  number of values stored in the list
     */
    @Override
    public int length() {
        return this.lengthHelper(this.head);
    }

    /**
     * count the number of non-null nodes we find
     * @param current   current node
     * @return
     */
    private int lengthHelper(Node current) {
        if (current == null) {
            return 0;
        }
        // return 1 + the number of nodes coming after current
        return 1 + this.lengthHelper(current.next);
    }
}

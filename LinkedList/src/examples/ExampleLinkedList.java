package examples;

import interfaces.ILinkedList;

public class ExampleLinkedList implements ILinkedList {
    /**
     * Nested class for the Node as a Node without a Linked List is sorta wrong
     * for more information about nested classes see:
     * https://www.w3schools.com/java/java_inner_classes.asp
     * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     *
     * About if you should use nested classes see:
     * https://stackoverflow.com/questions/1028850/are-inner-classes-commonly-used-in-java-are-they-bad
     */
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head = null;

    /**
     * construct a new empty list
     */
    public ExampleLinkedList() {
        this.head = null;
    }


    /**
     * adds `value` to the end of the list
     *
     * @param value value to be added to the end of the list
     */
    @Override
    public void addLast(int value) {
        // if list is empty we update the head
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }

        // otherwise iterate until we find the last node and update its next
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value);
    }

    /**
     * adds `value` to the front of the list
     *
     * @param value value to be added to the front of the list
     */
    @Override
    public void addFirst(int value) {
        // note: this works for both: head == null and head != null
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
        // note: we don't check for empty list as it is covered
        //       by the bounds check

        // check if the index is out of bounds
        if (index < 0) {
            return;
        }
        if (index >= length()) {
            return;
        }

        // find the node with index 0 and its parent
        Node parent = null;
        Node current = this.head;
        for (; index != 0; index -= 1) {
            parent = current;
            current = current.next;
        }

        Node newNode = new Node(value);

        // if the parent is null we know that current is head
        if (parent == null) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            newNode.next = current;
            parent.next = newNode;
        }
    }

    /**
     * get the value stored at `index` or `null` if index is invalid
     *
     * @param   index of the looked for value in the list
     * @return  value stored at `index` or `null` if `index < 0` or `index >= this.length()`
     */
    public Integer get(int index) {
        // note: we don't need to check for empty list as it
        //       is covered in the bounds check

        // check if the index is out ouf bounds
        if (index < 0) {
            return null;
        }
        if (index >= length()) {
            return null;
        }

        // find the node stored at index
        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }

        // note: we don't have to check for current == null
        //       because we checked earlier if the index is in
        //       bounds

        // return its value
        return current.value;
    }

    /**
     * remove the last value in the list and return it
     *
     * @return  either the last value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeLast() {
        // check if the list is empty
        if (this.head == null) {
            return null;
        }

        // find last node and its parent in the list
        Node parent = null;
        Node current = this.head;

        while (current.next != null) {
            parent = current;
            current = current.next;
        }

        // if parent is null we know that current is the head
        // and therefore that the list has only one node stored in it
        if (parent == null) {
            this.head = null;
        } else {
            parent.next = null;
        }

        return current.value;
    }

    /**
     * remove the first value in the list and return it
     * @return  either the first value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeFirst() {
        // check if the list is empty
        if (this.head == null) {
            return null;
        }

        // store value for later return and update head
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
        // note: we don't need to check for empty list as because that check is covered by the bounds check

        // check if index is in bounds
        if (index < 0) {
            return null;
        }
        if (index >= this.length()) {
            return null;
        }

        // find the node at index and its parent
        Node parent = null;
        Node current = this.head;

        for (; index != 0; index -= 1) {
            parent = current;
            current = current.next;
        }

        // note: we don't need to check for current == null because of the bounds check

        // if the parent is null we know current is head
        if (parent == null) {
            this.head = current.next;
        } else {
            parent.next = current.next;
        }

        return current.value;
    }

    /**
     * get the number of values stored in the list
     * @return  number of values stored in the list
     */
    @Override
    public int length() {
        // count the nodes currently present in the list
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.next;
        }

        // note: it is also ok to keep a `private int length` member and update it in the various methods
        return length;
    }

}

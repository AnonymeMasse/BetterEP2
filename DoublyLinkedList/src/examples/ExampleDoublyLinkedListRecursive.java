package examples;

import interfaces.IDoublyLinkedList;

public class ExampleDoublyLinkedListRecursive implements IDoublyLinkedList {
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

    private Node head;
    private Node tail;

    /**
     * construct a new empty list
     */
    public ExampleDoublyLinkedListRecursive() {
        this.head = null;
        this.tail = null;
    }

    /**
     * adds `value` to the end of the list
     *
     * @param value value to be added to the end of the list
     */
    @Override
    public void addLast(int value) {
        Node newNode = new Node(value);

        // check if the list is empty
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // otherwise insert at tail
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }

    /**
     * adds `value` to the front of the list
     *
     * @param   value value to be added to the front of the list
     */
    @Override
    public void addFirst(int value) {
        Node newNode = new Node(value);

        // check if the list is empty
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // otherwise insert at head
        newNode.next = this.head;
        this.head.previous = newNode;
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
        // check if the index is in bounds
        if (index < 0) {
            return;
        }
        if (index >= this.length()) {
            return;
        }

        // if we try to insert at 0 we can just use addFirst
        if (index == 0) {
            addFirst(value);
            return;
        }

        this.insertHelper(this.head, value, index);
    }

    private void insertHelper(Node current, int value, int index) {
        // check if we have found the right position
        if (index == 0) {
            Node newNode = new Node(value);

            // insert newNode between previous and current
            Node previous = current.previous;

            newNode.next = current;
            current.previous = newNode;

            previous.next = newNode;
            newNode.previous = previous;
            return;
        }

        // otherwise look at the next node with index - 1
        this.insertHelper(current.next, value, index - 1);
    }

    /**
     * get the value stored at `index` or `null` if index is invalid
     *
     * @param   index of the looked for value in the list
     * @return  value stored at `index` or `null` if `index < 0` or `index >= this.length()`
     */
    @Override
    public Integer get(int index) {
        // check if the index is in bounds
        if (index < 0) {
            return null;
        }

        // note: upper bounds check is done by the helper function
        // note: the lower bounds check could actually be performed by the Helper method too

        return this.getHelper(this.head, index);
    }

    private Integer getHelper(Node current, int index) {
        // if current gets to null index is not present in the list
        if (current == null) {
            return null;
        }

        // check if we have found the right node
        if (index == 0) {
            return current.value;
        }

        // otherwise we look at the next element
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

        // check if list is only one element long
        // note: this check could also be done with the previous member of tail
        if (this.length() == 1) {
            int value = this.tail.value;
            this.head = null;
            this.tail = null;
            return value;
        }

        // store value of tail for later return
        int value = this.tail.value;

        //  update tail
        this.tail = this.tail.previous;
        this.tail.next = null;

        return value;
    }

    /**
     * remove the first value in the list and return it
     * @return  either the first value stored in the list or `null` if the list is empty
     */
    @Override
    public Integer removeFirst() {
        // check if list is empty
        if (this.head == null) {
            return null;
        }

        // check if list has only one node
        // note: this check could also be done with the head.next member
        if (this.length() == 1) {
            int value = this.head.value;
            this.head = null;
            this.tail = null;
            return value;
        }

        // store value for later return
        int value = this.head.value;

        // update head
        this.head = this.head.next;
        this.head.previous = null;

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
        // check if index is in bounds
        if (index < 0) {
            return null;
        }
        if (index >= this.length()) {
            return null;
        }

        // we already have written code to handle the this.tail and this.head updates
        // lets just use it
        if (index == 0) {
            return removeFirst();
        }
        if (index == this.length() - 1) {
            return removeLast();
        }

        // actually find and remove the node at index
        return this.removeHelper(this.head, index);
    }

    private Integer removeHelper(Node current, int index) {
        // check if we have found the node
        if (index == 0) {
            // remove current bei joining previous and next
            Node previous = current.previous;
            Node next = current.next;

            previous.next = next;
            next.previous = previous;
            return current.value;
        }
        // otherwise try with next item
        return this.removeHelper(current.next, index - 1);
    }

    /**
     * get the number of values stored in the list
     * @return  number of values stored in the list
     */
    @Override
    public int length() {
        return this.lengthHelper(this.head);
    }

    private int lengthHelper(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + this.lengthHelper(current.next);
    }
}

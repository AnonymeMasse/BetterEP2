import interfaces.IDoublyLinkedList;

public class ExampleDoublyLinkedList implements IDoublyLinkedList {
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

    private Node head = null;
    private Node tail = null;

    /**
     * construct a new empty list
     */
    public ExampleDoublyLinkedList() {
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
        // check if index is in bounds
        if (index < 0) {
            return;
        }
        if (index >= this.length()) {
            return;
        }

        // note: if we reach here list is not empty

        // find node at index in the list
        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }

        // set references of new node
        Node newNode = new Node(value);
        Node previous = current.previous;

        current.previous = newNode;
        newNode.next = current;

        newNode.previous = previous;

        // if previous is null current was the head
        if (previous == null) {
            this.head = newNode;
        } else {
            previous.next = newNode;
        }
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
        if (index >= this.length()) {
            return null;
        }

        // find node at index
        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }

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

        // find node at index
        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }

        // we already have written the logic to handle the this.tail and this.head updates
        // lets just use it
        if (current.previous == null) {
            return removeFirst();
        }
        if (current.next == null) {
            return removeLast();
        }

        // remove current between previous and next
        Node previous = current.previous;
        Node next = current.next;

        previous.next = next;
        next.previous = previous;

        return current.value;
    }

    /**
     * get the number of values stored in the list
     * @return  number of values stored in the list
     */
    @Override
    public int length() {
        // count how many nodes are present in the list
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.next;
        }

        // note: this could also be done with a member `private int length;` which is updated in the various length
        // altering methods
        return length;
    }
}

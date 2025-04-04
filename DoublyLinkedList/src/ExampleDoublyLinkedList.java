import interfaces.IDoublyLinkedList;

public class ExampleDoublyLinkedList implements IDoublyLinkedList {
    private class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    @Override
    public void addLast(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }

    @Override
    public void addFirst(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
    }

    @Override
    public void insert(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index >= this.length()) {
            return;
        }

        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }
        Node newNode = new Node(value);
        Node previous = current.previous;

        current.previous = newNode;
        newNode.next = current;
        newNode.previous = previous;

        if (previous == null) {
            this.head = newNode;
        } else {
            previous.next = newNode;
        }
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= this.length()) {
            return null;
        }

        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Integer removeLast() {
        if (this.head == null) {
            return null;
        }
        int value = this.tail.value;

        if (this.tail.previous == null) {
            this.head = null;
            this.tail = null;
            return value;
        }

        this.tail = this.tail.previous;
        this.tail.next = null;
        return value;
    }

    @Override
    public Integer removeFirst() {
        if (this.head == null) {
            return null;
        }

        int value = this.head.value;

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
            return value;
        }

        this.head = this.head.next;
        this.head.previous = null;

        return value;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= this.length()) {
            return null;
        }

        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }
        if (current.previous == null) {
            return removeFirst();
        }
        if (current.next == null) {
            return removeLast();
        }

        Node previous = current.previous;
        Node next = current.next;

        previous.next = next;
        next.previous = previous;

        return current.value;
    }

    @Override
    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.next;
        }
        return length;
    }
}

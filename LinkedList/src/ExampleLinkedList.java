import interfaces.ILinkedList;

public class ExampleLinkedList implements ILinkedList {
    private class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head = null;

    public ExampleLinkedList() {
        this.head = null;
    }

    public void push(int element) {
        if (this.head == null) {
            this.head = new Node(element);
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(element);
    }

    public int pop() {
        Node parent = null;
        Node current = this.head;
        while (current.next != null) {
            parent = current;
            current = current.next;
        }

        if (parent == null) {
            this.head = null;
        } else {
            parent.next = null;
        }
        return current.element;
    }

    public int get(int index) {
        int i = 0;
        Node current = this.head;

        while (current != null && i < index) {
            current = current.next;
            i += 1;
        }
        return current.element;
    }

    public int length() {
        int length = 0;
        Node current = this.head;

        while (current != null) {
            current = current.next;
            length += 1;
        }

        return length;
    }

    public void insert(int element, int index) {
        Node parent = null;
        Node current = this.head;

        while (index != 0) {
            parent = current;
            current = current.next;
            index -= 1;
        }

        if (parent == null) {
            this.head = new Node(element);
            this.head.next = current;
        } else {
            Node node = new Node(element);
            node.next = current;
            parent.next = node;
        }
    }

    public int remove(int index) {
        Node parent = null;
        Node current = this.head;

        while (index != 0) {
            index -= 1;
            parent = current;
            current = current.next;
        }

        if (parent == null) {
            this.head = current.next;
        } else {
            parent.next = current.next;
        }
        return current.element;
    }
}

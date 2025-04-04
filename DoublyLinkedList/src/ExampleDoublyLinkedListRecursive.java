import interfaces.IDoublyLinkedList;

public class ExampleDoublyLinkedListRecursive implements IDoublyLinkedList {
    private class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;

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
        if (index == 0) {
            addFirst(value);
            return;
        }

        this.insertHelper(this.head, value, index);
    }

    private void insertHelper(Node current, int value, int index) {
        if (current == null) {
            return;
        }
        if (index == 0) {
            Node newNode = new Node(value);
            Node previous = current.previous;

            newNode.next = current;
            current.previous = newNode;

            previous.next = newNode;
            newNode.previous = previous;
            return;
        }

        this.insertHelper(current.next, value, index - 1);
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            return null;
        }
        return this.getHelper(this.head, index);
    }

    private Integer getHelper(Node current, int index) {
        if (current == null) {
            return null;
        }
        if (index == 0) {
            return current.value;
        }
        return this.getHelper(current.next, index - 1);
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
        if (index == 0) {
            return removeFirst();
        }
        if (index == this.length() - 1) {
            return removeLast();
        }

        return this.removeHelper(this.head, index);
    }

    private Integer removeHelper(Node current, int index) {
        if (index == 0) {
            Node previous = current.previous;
            Node next = current.next;

            previous.next = next;
            next.previous = previous;
            return current.value;
        }
        return this.removeHelper(current.next, index - 1);
    }

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

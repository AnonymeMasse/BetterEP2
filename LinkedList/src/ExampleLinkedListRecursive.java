import interfaces.ILinkedList;

public class ExampleLinkedListRecursive implements ILinkedList {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public ExampleLinkedListRecursive() {
        this.head = null;
    }

    @Override
    public void addLast(int value) {
        this.addLastHelper(null, this.head, value);
    }

    public void addLastHelper(Node parent, Node current, int value) {
        if (current == null) {
            Node newNode = new Node(value);
            if (parent == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
            return;
        }
        this.addLastHelper(current, current.next, value);
    }

    @Override
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    @Override
    public void insert(int value, int index) {
        if (index < 0) {
            return;
        }
        this.insertHelper(null, this.head, value, index);
    }

    private void insertHelper(Node parent, Node current, int value, int index) {
        if (current == null) {
            return;
        }
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = current;
            if (parent == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
            return;
        }
        this.insertHelper(current, current.next, value, index - 1);
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
        return this.removeLastHelper(null, this.head);
    }

    private Integer removeLastHelper(Node parent, Node current) {
        if (current.next == null) {
            if (parent == null) {
                this.head = null;
            } else {
                parent.next = null;
            }
            return current.value;
        }
        return this.removeLastHelper(current, current.next);
    }

    @Override
    public Integer removeFirst() {
        if (this.head == null) {
            return null;
        }
        int value = this.head.value;
        this.head = this.head.next;
        return value;
    }

    @Override
    public Integer remove(int index) {
        if (this.head == null) {
            return null;
        }
        return this.removeHelper(null, this.head, index);
    }

    private Integer removeHelper(Node parent, Node current, int index) {
        if (current == null) {
            return null;
        }
        if (index == 0) {
            if (parent == null) {
                this.head = current.next;
            } else {
                parent.next = current.next;
            }
            return current.value;
        }
        return this.removeHelper(current, current.next, index - 1);
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

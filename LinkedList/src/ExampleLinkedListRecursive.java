import interfaces.ILinkedList;

public class ExampleLinkedListRecursive implements ILinkedList {
    private class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head = null;

    public void push(int element) {
        if (this.head == null) {
            this.head = new Node(element);
            return;
        }
        pushHelper(this.head, element);
    }

    private void pushHelper(Node current, int element) {
        if (current.next == null) {
            current.next = new Node(element);
            return;
        }
        pushHelper(current.next, element);
    }

    public int pop() {
        return popHelper(null, this.head);
    }

    private int popHelper(Node parent, Node current) {
        if (current.next == null) {
            if (parent == null) {
                this.head = null;
            } else {
                parent.next = null;
            }
            return current.element;
        }
        return popHelper(current, current.next);
    }

    public int get(int index) {
        return getHelper(this.head, index);
    }

    private int getHelper(Node current, int index) {
        if (index == 0) {
            return current.element;
        }
        return getHelper(current.next, index - 1);
    }

    public int length() {
        return lengthHelper(this.head);
    }

    private int lengthHelper(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + lengthHelper(current.next);
    }

    public void insert(int element, int index) {
        insertHelper(null, this.head, element, index);
    }

    private void insertHelper(Node parent, Node current, int element, int index) {
        if (index == 0)  {
            Node node = new Node(element);
            node.next = current;
            if (parent == null)  {
                this.head = node;
            } else {
                parent.next = node;
            }
            return;
        }
        insertHelper(current, current.next, element, index - 1);
    }

    public int remove(int index) {
        return removeHelper(null, this.head, index);
    }

    private int removeHelper(Node parent, Node current, int index) {
        if (index == 0) {
            if (parent == null) {
                this.head = current.next;
            } else {
                parent.next = current.next;
            }
            return current.element;
        }
        return removeHelper(current, current.next, index - 1);
    }
}

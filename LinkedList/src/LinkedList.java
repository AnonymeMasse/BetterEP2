import interfaces.ILinkedList;

public class LinkedList implements ILinkedList {
    private class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    public void push(int element) {

    }

    public int pop() {
        return 0;
    }

    public int get(int index) {
        return 0;
    }

    public int length() {
        return 0;
    }

    public void insert(int element, int index) {

    }

    public int remove(int index) {
        return 0;
    }
}

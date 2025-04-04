package interfaces;

public interface IDoublyLinkedList {
    void addLast(int value);
    void addFirst(int value);
    void insert(int value, int index);
    Integer get(int index);
    Integer removeLast();
    Integer removeFirst();
    Integer remove(int index);
    int length();
}

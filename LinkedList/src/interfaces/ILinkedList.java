package interfaces;

public interface ILinkedList {
    /**
     * adds `value` to the end of the list
     *
     * @param value value to be added to the end of the list
     */
    void addLast(int value);
    void addFirst(int value);
    void insert(int value, int index);
    Integer get(int index);
    Integer removeLast();
    Integer removeFirst();
    Integer remove(int index);
    int length();
}

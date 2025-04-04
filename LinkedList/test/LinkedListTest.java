import interfaces.ILinkedListTest;

public class LinkedListTest implements ILinkedListTest<LinkedList> {
    @Override
    public LinkedList createLinkedList() {
        return new LinkedList();
    }
}

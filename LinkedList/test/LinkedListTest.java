import interfaces.ILinkedListTest;

public class LinkedListTest implements ILinkedListTest {
    @Override
    public LinkedList createLinkedList() {
        return new LinkedList();
    }
}

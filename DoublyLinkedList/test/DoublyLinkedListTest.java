import interfaces.IDoublyLinkedListTest;

public class DoublyLinkedListTest implements IDoublyLinkedListTest {
    @Override
    public DoublyLinkedList createDoublyLinkedList() {
        return new DoublyLinkedList();
    }
}

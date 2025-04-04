import interfaces.IDoublyLinkedListTest;

public class DoublyLinkedListTest implements IDoublyLinkedListTest<DoublyLinkedList> {
    @Override
    public DoublyLinkedList createDoublyLinkedList() {
        return new DoublyLinkedList();
    }
}

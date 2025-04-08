package examples;

import interfaces.IDoublyLinkedListTest;

public class ExampleDoublyLinkedListTest implements IDoublyLinkedListTest {

    @Override
    public ExampleDoublyLinkedList createDoublyLinkedList() {
        return new ExampleDoublyLinkedList();
    }
}

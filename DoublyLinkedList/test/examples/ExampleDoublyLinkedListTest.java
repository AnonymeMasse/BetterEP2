package examples;

import interfaces.IDoublyLinkedListTest;

public class ExampleDoublyLinkedListTest implements IDoublyLinkedListTest<ExampleDoublyLinkedList> {

    @Override
    public ExampleDoublyLinkedList createDoublyLinkedList() {
        return new ExampleDoublyLinkedList();
    }
}

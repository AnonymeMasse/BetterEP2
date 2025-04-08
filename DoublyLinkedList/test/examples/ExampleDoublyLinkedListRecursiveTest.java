package examples;

import interfaces.IDoublyLinkedListTest;

public class ExampleDoublyLinkedListRecursiveTest implements IDoublyLinkedListTest {
    @Override
    public ExampleDoublyLinkedListRecursive createDoublyLinkedList() {
        return new ExampleDoublyLinkedListRecursive();
    }
}

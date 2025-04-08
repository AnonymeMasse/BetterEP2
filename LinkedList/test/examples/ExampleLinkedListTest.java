package examples;

import interfaces.ILinkedListTest;

public class ExampleLinkedListTest implements ILinkedListTest {
    @Override
    public ExampleLinkedList createLinkedList() {
        return new ExampleLinkedList();
    }
}

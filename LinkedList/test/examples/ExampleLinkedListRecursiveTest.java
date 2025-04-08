package examples;

import interfaces.ILinkedListTest;

public class ExampleLinkedListRecursiveTest implements ILinkedListTest {
    @Override
    public ExampleLinkedListRecursive createLinkedList() {
        return new ExampleLinkedListRecursive();
    }
}

package examples;

import interfaces.ILinkedListTest;

public class ExampleLinkedListRecursiveTest implements ILinkedListTest<ExampleLinkedListRecursive> {
    @Override
    public ExampleLinkedListRecursive createLinkedList() {
        return new ExampleLinkedListRecursive();
    }
}

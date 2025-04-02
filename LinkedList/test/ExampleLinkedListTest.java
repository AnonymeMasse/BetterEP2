public class ExampleLinkedListTest implements ILinkedListTest<ExampleLinkedList> {
    @Override
    public ExampleLinkedList createLinkedList() {
        return new ExampleLinkedList();
    }
}

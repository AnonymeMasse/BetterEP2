import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

public class LinkedListTest implements ILinkedListTest<LinkedList> {
    @Override
    public LinkedList createLinkedList() {
        return new LinkedList();
    }
}

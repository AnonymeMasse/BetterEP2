import interfaces.IDynamicArrayTest;

public class DynamicArrayTest implements IDynamicArrayTest {
    @Override
    public DynamicArray createDynamicArray() {
        return new DynamicArray();
    }
}

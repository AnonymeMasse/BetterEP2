public class DynamicArrayTest implements IDynamicArrayTest<DynamicArray>{
    @Override
    public DynamicArray createDynamicArray() {
        return new DynamicArray();
    }
}

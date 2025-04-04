public class ExampleDynamicArrayTest implements IDynamicArrayTest<ExampleDynamicArray>{
    @Override
    public ExampleDynamicArray createDynamicArray() {
        return new ExampleDynamicArray();
    }
}

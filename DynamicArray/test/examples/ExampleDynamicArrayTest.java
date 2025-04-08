package examples;

import interfaces.IDynamicArrayTest;

public class ExampleDynamicArrayTest implements IDynamicArrayTest {
    @Override
    public ExampleDynamicArray createDynamicArray() {
        return new ExampleDynamicArray();
    }
}

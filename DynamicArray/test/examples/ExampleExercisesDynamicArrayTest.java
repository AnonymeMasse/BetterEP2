package examples;

import interfaces.IExercisesDynamicArrayTest;

public class ExampleExercisesDynamicArrayTest implements IExercisesDynamicArrayTest {
    @Override
    public ExampleExercisesDynamicArray createExercisesDynamicArray() {
        return new ExampleExercisesDynamicArray();
    }
}

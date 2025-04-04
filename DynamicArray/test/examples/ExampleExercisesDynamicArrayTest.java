package examples;

import interfaces.IExercisesDynamicArrayTest;

public class ExampleExercisesDynamicArrayTest implements IExercisesDynamicArrayTest<ExampleDynamicArray, ExampleExercisesDynamicArray> {
    @Override
    public ExampleExercisesDynamicArray createExercisesDynamicArray() {
        return new ExampleExercisesDynamicArray();
    }
}

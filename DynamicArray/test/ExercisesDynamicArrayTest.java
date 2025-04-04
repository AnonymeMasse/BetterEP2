import interfaces.IExercisesDynamicArrayTest;

public class ExercisesDynamicArrayTest implements IExercisesDynamicArrayTest<DynamicArray, ExercisesDynamicArray> {
    @Override
    public ExercisesDynamicArray createExercisesDynamicArray() {
        return new ExercisesDynamicArray();
    }
}

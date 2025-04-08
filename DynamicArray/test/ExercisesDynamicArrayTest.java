import interfaces.IExercisesDynamicArrayTest;

public class ExercisesDynamicArrayTest implements IExercisesDynamicArrayTest {
    @Override
    public ExercisesDynamicArray createExercisesDynamicArray() {
        return new ExercisesDynamicArray();
    }
}

package interfaces;

public interface IExercisesDynamicArrayTest<D extends IDynamicArray, T extends IExercisesDynamicArray<D>> {
    T createExercisesDynamicArray();
}

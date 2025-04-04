import interfaces.IExercisesBinarySearchTreeTest;

public class ExercisesBinarySearchTreeTest implements IExercisesBinarySearchTreeTest<BinarySearchTree, ExercisesBinarySearchTree> {
    @Override
    public ExercisesBinarySearchTree createExercisesBinarySearchTree() {
        return new ExercisesBinarySearchTree();
    }
}

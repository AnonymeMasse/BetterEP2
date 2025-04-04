package examples;

import interfaces.IExercisesBinarySearchTreeTest;

public class ExampleExercisesBinarySearchTreeTest implements IExercisesBinarySearchTreeTest<ExampleBinarySearchTree, ExamplesExercisesBinarySearchTree> {
    @Override
    public ExamplesExercisesBinarySearchTree createExercisesBinarySearchTree() {
        return new ExamplesExercisesBinarySearchTree();
    }
}
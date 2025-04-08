package examples;

import interfaces.IExercisesBinarySearchTreeTest;

public class ExampleExercisesBinarySearchTreeTest implements IExercisesBinarySearchTreeTest {
    @Override
    public ExamplesExercisesBinarySearchTree createExercisesBinarySearchTree() {
        return new ExamplesExercisesBinarySearchTree();
    }
}
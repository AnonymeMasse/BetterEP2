package examples;

import interfaces.IExercisesLinkedListTest;

public class ExampleExercisesLinkedListTest implements IExercisesLinkedListTest {
    @Override
    public ExampleExercisesLinkedList createExercisesLinkedList() {
        return new ExampleExercisesLinkedList();
    }
}

package examples;

import interfaces.IExercisesLinkedListTest;

public class ExampleExercisesTest implements IExercisesLinkedListTest<ExampleLinkedList, ExampleExercisesLinkedList> {
    @Override
    public ExampleExercisesLinkedList createExercisesLinkedList() {
        return new ExampleExercisesLinkedList();
    }
}

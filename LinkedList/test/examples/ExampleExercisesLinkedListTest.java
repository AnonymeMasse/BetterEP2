package examples;

import interfaces.IExercisesLinkedListTest;

public class ExampleExercisesLinkedListTest implements IExercisesLinkedListTest<ExampleLinkedList, ExampleExercisesLinkedList> {
    @Override
    public ExampleExercisesLinkedList createExercisesLinkedList() {
        return new ExampleExercisesLinkedList();
    }
}

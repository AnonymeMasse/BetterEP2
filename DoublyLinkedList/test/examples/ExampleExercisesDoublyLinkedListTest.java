package examples;

import interfaces.IExercisesDoublyLinkedListTest;

public class ExampleExercisesDoublyLinkedListTest implements IExercisesDoublyLinkedListTest {
    @Override
    public ExampleExercisesDoublyLinkedList createExercisesDoublyLinkedList() {
        return new ExampleExercisesDoublyLinkedList();
    }
}

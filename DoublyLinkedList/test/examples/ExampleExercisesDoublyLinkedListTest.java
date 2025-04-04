package examples;

import interfaces.IExercisesDoublyLinkedListTest;

public class ExampleExercisesDoublyLinkedListTest implements IExercisesDoublyLinkedListTest<ExampleDoublyLinkedList, ExampleExercisesDoublyLinkedList> {
    @Override
    public ExampleExercisesDoublyLinkedList createExercisesDoublyLinkedList() {
        return new ExampleExercisesDoublyLinkedList();
    }
}

import interfaces.IExercisesDoublyLinkedListTest;

public class ExercisesDoublyLinkedListTest implements IExercisesDoublyLinkedListTest<DoublyLinkedList, ExercisesDoublyLinkedList> {
    @Override
    public ExercisesDoublyLinkedList createExercisesDoublyLinkedList() {
        return new ExercisesDoublyLinkedList();
    }
}

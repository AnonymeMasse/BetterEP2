import interfaces.IExercisesLinkedListTest;
import interfaces.ILinkedList;

public class ExercisesLinkedListTest implements IExercisesLinkedListTest<LinkedList, ExercisesLinkedList> {
    @Override
    public ExercisesLinkedList createExercisesLinkedList() {
        return new ExercisesLinkedList();
    }
}

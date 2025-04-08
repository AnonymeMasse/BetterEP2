import interfaces.IExercisesLinkedListTest;
import interfaces.ILinkedList;

public class ExercisesLinkedListTest implements IExercisesLinkedListTest {
    @Override
    public ExercisesLinkedList createExercisesLinkedList() {
        return new ExercisesLinkedList();
    }
}

import interfaces.IDynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public interface IDynamicArrayTest<T extends IDynamicArray> {
    T createDynamicArray();

    @Test
    @DisplayName("Basic test (needs to be reworked and split up)")
    default void basicTest() {
        T array = this.createDynamicArray();
        for (int i = 0; i < 100; i += 1) {
            array.push(i);
        }
        for (int i = 0; i < 100; i += 1) {
            assertEquals(i, array.get(i));
        }
        for (int i = 99; i >= 0; i -= 1) {
            assertEquals(i, array.pop());
        }
    }
}

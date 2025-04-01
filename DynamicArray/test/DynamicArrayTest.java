import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "musterloesung", matches = "only", disabledReason = "The solution is not implemented yet")
public class DynamicArrayTest implements IDynamicArrayTest<DynamicArray> {
    @Override
    public DynamicArray createDynamicArray() {
        return new DynamicArray();
    }
}

package interfaces;

public interface IDynamicArray {
    void push(int value);
    void insert(int value, int index);

    Integer pop();
    Integer remove();
}

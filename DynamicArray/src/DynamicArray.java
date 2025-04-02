import interfaces.IDynamicArray;

public class DynamicArray implements IDynamicArray {
    private int length;
    private int capacity;
    private int[] buffer;

    public DynamicArray() {
        // TODO:
    }

    // `element` an der ersten freien Stelle in `buffer` einfuegen und `buffer` groesser machen falls wir es brauchen
    public void push(int element) {
        // TODO: implement push method
    }

    // letztes element aus dem `buffer` entfernen und returnen
    public int pop() {
        // TODO: implement pop method
        return -1;
    }

    // element an der stelle `index` aus dem `buffer` returnen
    public int get(int index) {
        // TODO: implement  get method
        return -1;
    }

    public int length() {
        return 0;
    }

    public void insert(int element, int index) {

    }

    public int remove(int index) {
        return 0;
    }
}

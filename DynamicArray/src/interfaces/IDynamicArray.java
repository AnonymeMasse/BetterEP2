package interfaces;

public interface IDynamicArray {
    // `element` an der ersten freien Stelle in `buffer` einfuegen und `buffer` groesser machen falls wir es brauchen
    void push(int element);

    // letztes element aus dem `buffer` entfernen und returnen
    int pop();

    // element an der stelle `index` aus dem `buffer` returnen
    int get(int index);

    // gebe die aktuelle Anzahl an Elementen zurueck
    int length();

    // fuege das element `element` an der Stelle index ein
    void insert(int element, int index);

    // entferne das element an der stelle index
    int remove(int index);
}

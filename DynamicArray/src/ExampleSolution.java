import interfaces.IDynamicArray;

public class ExampleSolution implements IDynamicArray {
    private int length;
    private int capacity;
    private int[] buffer;

    public ExampleSolution() {
        this.length = 0;                                // initial sind keine Elemente im Array also ist unsere Liste lehr
        this.capacity = 1;                              // eine initiale Groesse unseres buffers
        this.buffer = new int[this.capacity];           // buffer mit capacity initilisieren
    }

    // grows the buffer to double its current size
    private void grow() {
        // neuen buffer mit doppelter capacity anlegen
        int[] newBuffer = new int[this.capacity * 2];

        // element rueberkopieren
        for (int i = 0; i < this.length; i += 1) {
            newBuffer[i] = this.buffer[i];
        }
        // diese Copy function koennte auch so aussehen:
        // System.arraycopy(this.buffer, 0, newBuffer, 0, this.length);

        // newBuffer als internen buffer verwenden
        this.buffer = newBuffer;

        // neue capacity speichern
        this.capacity = this.capacity * 2;
    }

    // `element` an der ersten freien Stelle in `buffer` einfuegen und `buffer` groesser machen falls wir es brauchen
    public void push(int element) {
        boolean has_enough_space = this.length < this.capacity;     // schauen ob wir genug space haben
        if (!has_enough_space) {                                    // wenn wir nicht genug space haben dann vergroessern wir unseren buffer
            grow();
        }
        this.buffer[this.length] = element;                         // element an die erste freie Stelle im Buffer schreiben
        this.length += 1;                                           // laenge erhoehen
    }

    // letztes element aus dem `buffer` entfernen und returnen
    public int pop() {
        // NOTE: wir machen hier kein Error handling fuer den fall dass der buffer leer ist

        int element = this.buffer[this.length - 1];   // letztes element im buffer finden
        this.length -= 1;                             // length veringen und damit effektiv das element aus dem buffer entfernen

        return element;                               // element zurueckgeben
    }

    // element an der stelle `index` aus dem `buffer` returnen
    public int get(int index) {
        // NOTE: wir machen hier kein Error handling fuer den Fall das der index keinen Sinn macht

        int element = this.buffer[index];       // element im buffer finden
        return element;                         // element zurueckgeben
    }

    // returns the number of elements stored
    public int length() {
        // the number of elements is stored in the object variable `this.length`
        return this.length;
    }

    public void insert(int element, int index) {
        boolean has_enough_space = this.length < this.capacity;
        if (!has_enough_space) {
            grow();
        }

        // fuer element Platz machen im Buffer indem man jedes element ab `index` auf eine Stelle weiter rechts kopiert
        for (int i = this.length - 1; i >= index; i -= 1) {
            this.buffer[i + 1] = this.buffer[i];
        }

        // dieser Copy Loop koennte auch durch diesen Call ersetzt werden
        // System.arraycopy(this.buffer, index, this.buffer, index + 1, this.length - index);
        this.buffer[index] = element;
        this.length += 1;
    }

    public int remove(int index) {
        int element = this.buffer[index];

        for (int i = index; i < this.length - 1; i += 1) {
            this.buffer[i] = this.buffer[i + 1];
        }

        this.length -= 1;

        return element;
    }
}

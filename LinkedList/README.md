# LinkedList

Eine Linked List ist eine Datenstruktur, die – wie auch ein dynamisches Array –
zur Laufzeit wachsen und schrumpfen kann.

Im Gegensatz zu einem dynamischen Array bietet die Linked List allerdings den
Vorteil, dass das Einfügen an einer Stelle `x` einen Konstanten Zeitaufwand
`O(1)` hat. Im Array hingegen, wäre dieser linear `O(n)`, da alle Elemente nach
`x` verschoben werden müssten.

Ein Nachteil der Linked List ist, dass der Zugriff auf ein Element immer mit dem
Traversieren der Liste verbunden ist, was nur in `O(n)` möglich ist. Demnach
sind auch aufwändigere Suchalgorithmen nicht möglich.

In vielen Programmiersprachen gibt es eine Implementierung in deren
Standardbibliotheken. Einige Beispiele:

- Java: `LinkedList`
- Rust: `LinkedList`
- C++: `std::forward_list`
- Zig: `SinglyLinkedList`

Im Prinzip benötigt die primitivste Form einer Linked List lediglich:

- `private Node head` ... eine Referenz auf das erste Node in der Liste

Eine sehr einfache Optimierung für eine `length()` Funktion ist allerdings das
Hinzufügen von:

- `private int count` ... eine `int` variable,
  mit welcher die Elemente in der Liste gezählt werden

Zu zweiteren jedoch später mehr.

Damit hat unsere LinkedList die folgende Grundform:

![](images/basic_list.svg)

Ein sehr einfaches Interface für eine LinkedList wie auch wir es verwenden
könnte wie folgt aussehen:

```java
public interface ILinkedList {
    void addLast(int value);

    void addFirst(int value);

    void insert(int value, int index);

    Integer get(int index);

    Integer removeLast();

    Integer removeFirst();

    Integer remove(int index);

    int length();
}
```

Dieses Interface können wir nun step by step durchgehen und die Funktionen
der Reihe nach implementieren:

### `void addLast(int value)`

Im Wesentlichen betrachten wir zwei Fälle:

- Fall 1: Die LinkedList ist leer:
    1. Hier müssen wir nur den head der Liste auf
       unser Node setzen

- Fall 2: Es befinden sich bereits Nodes in der List:
    1. Wir traversieren die Liste bis wir das letzte Node gefunden haben, also
       bis `current.getNext()` uns `null` zurückliefert:

       ![](images/addLast_traverse.svg)

    2. Wir setzten den Nachfolger des letzten Elements auf unser neues Node

       ![](images/addLast_insert.svg)

Wir setzten den Nachfolger des neuen Elements auf den aktuellen head und den
head auf das neue Element.

### `void addFirst(int value)`

`addFirst` ist eine der einfacheren Methoden. Sie setzt lediglich den Nachfolger
des neuen nodes auf den aktuellen `head` und setzt schließlich den `head` auf
das neue Node.

### `void insert(int value, int index)`

Zuerst wird überprüft, ob der angegebene Index valid ist, sich also im
Intervall `[0, length())` befindet.

Dann wird die LinkedList solange traversiert bis wir bei `index` ankommen.
Also setzen wir in jeder Iteration zuerst `parent` auf `current` und `current`
solange auf `current.getNext()` bis `current` auf `index` zeigt.

Dann sind zwei Fälle zu unterscheiden:

- Fall 1: Die LinkedList ist leer `parent == null`:
    - Hier wird der Nachfolger der `newNode` auf `head` (`null`) gesetzt und die
      neue Node zum head

- Fall 2: Es befinden sich bereits Nodes in der List:
    - Der Nachfolger der `newNode` wird auf `current` gesetzt und der Nachfolger
      von `parent` auf `newNode`

### `Integer get(int index)`

Wie auch bei `insert` überprüfen wir im ersten Schritt, ob sich der Index im
richtigen Intervall befindet.

Danach beginnen wir beim `head`, und traversieren `index` mal durch die Liste.
Dadurch liegen wir mit `current` am `index`'th node, welches wir zurückgeben
können.

![](images/get.svg)

### `Integer removeLast()`

Im ersten Schritt überprüfen wir, ob die List leer ist, also ob `head == null`.

Anschließend traversieren wir bis zum letzten Node, wobei wir uns auch das
vorletzte speichern.

![](images/removeLast_traverse.svg)

Nun kommt es zu zwei Fällen:

1. `parent == null`:
   In diesem Fall hätte die linked list eine Länge von 1, da wir keinen
   Schritt im Traverse gemacht haben.
   Folglich können wir `head = null` setzen, und `current` zurückgeben.

2. Andernfalls:
   müssen wir das vorletzte Node vom letzten Trennen, markiert durch den
   gestrichelten Pfeil, und wie auch im 1. Fall `current` zurückgeben.

![](images/removeLast_removal.svg)

### `Integer removeFirst()`

Wie immer, ist unsere Precondition erneut, dass die Liste nicht leer ist.

Ist dies nicht der Fall, können wir einfach unseren `head` eine Stelle vorwärts
schieben, und den Wert des 'alten' `head`'s zurückgeben.

![](images/removeFirst_remove.svg)

### `Integer remove(int index)`

Wie auch `void insert(int value, int index)` muss auch hier die Validität des
`index` überprüft werden. Ansonsten ist der Vorgang sehr ähnlich zu
`Integer removeLast()`.

Wir beginnen mit einem Traverse durch die Liste, mit dem wir uns erneut `parent`
und `current` einholen.

![](images/remove_traverse.svg)

Anschließend müssen wir nur noch zwei Fälle unterscheiden:

1. `parent == null`:
   Dieser Fall bedeutet, dass wir im Traverse keinen Schritt getätigt haben,
   also `index == 0`. In diesem Fall gilt es einfach den `head` auf den
   Nachfolger von `current` zu setzen, und `current` zurückzugeben.

2. Ansonsten:
   können wir wie zuvor das `parent` Node vom `current` trennen, und `current`
   zurückgeben.

![](images/remove_removal.svg)

### `int length()`

Abschließend noch die `length()` Funktion. Sie ist im Prinzip nichts anderes als
ein Traverse, mit einer Laufvariable `length`.

![](images/length_traverse.svg)

# Dynamisches Array 
Ein dynamisches Array ist ein Array welches seine Groesse dynamisch aendern
kann um mehr, oder weniger Elemente speichern zu koennen. Wir werden hier nur
`int` speichern, allerdings koennt ihr das gleiche Konzept mit einem anderen
Datentypen zum Beispiel `String` anwenden.

In praktisch jeder Programmiersprache gibt es eine Implementierung in der
standardlib einige Beispiele:
- Java: `ArrayList`
- Rust: `Vec`
- C++: `std::vector`
- Zig: `std.ArrayList`

An sich bestehen alle diese Implementierungen aus drei Teilen:
- `private int[] buffer` ... einem `int` Array welches die Werte haelt
- `private int capacity` ... das aktuelle Fassungsvermoegen unseres `buffer`
- `private int length` ... die Anzahl an werten die aktuell in `buffer` gespeichert werden

> NOTE:
> `buffer`, `capacity` und `length` koennen auch anders benannt werden in der
> VO zum Beispiel wurde `capacity` als `size` bezeichnet und `length` als
> `count`.

Zudem Folgen Implementierungen zumeist dem folgenden Interface. 

> NOTE: Bitte habt keine Angst vor dem Wort interface (ich glaube in der VO
> wurde dies noch nicht ausreichend abgearbeitet). Alles was interface bedeutet
> ist: "diese Sachen muss diese Klasse koennen"
>
> Zum Beispiel: Alle Autos haben das Interface eines Lenkrads und eines
> Gaspedals. Wenn man also unterschiedlich Autos faehrt reicht ein
> Fuehrerschein. Man was wie man ein Auto faehrt -> man kann alle Autos fahren.

```java
interface DynamicArray {
    // Fuege `element` in das dynamische Array ein 
    void push(int element);

    // Entferne das zuletzt eingefuegte Element aus dem Array und returne es 
    int pop();

    // returne das element an `index`
    int get(int index);

    // entferne dass Element am `index` und returne es
    int remove(int index);

    // fuege `element` an stelle `index` ein
    void insert(int index);
}
```

Denken wir uns mal die verschieden Methoden durch:
- `void push(int element)`:
  - zuerst schauen ob genug Platz ist fuer ein weiteres Element
  - wenn nein: mehr Platz machen
  - `element` and die erste freie Stelle im `buffer` schreiben (dies sollte immer die stelle: `buffer[length]`) sein
  - die `length` incrementieren: `length += 1`

  zur Veranschaulichung ein bisschen ASCII Art:

```
Setup:
  length = 3
  capacity = 4

           +---------------------+
  buffer = | 34 | 35 | 420 |     |
           +---------------------+

           |-----length----|

           |-----capacity--------|


push(69):
    -> haben wir genug Platz: length < capacity?
    -> Ja
    -> 69 am index length Einfuegen

                            buffer[length] 
                              |
                              V
           +---------------------+
  buffer = | 34 | 35 | 420 | 69  |
           +---------------------+

           |-----length----|

           |-----capacity--------|


    -> length inkrementieren
    -> length += 1

           +---------------------+
  buffer = | 34 | 35 | 420 | 69  |
           +---------------------+

           |-----length----------|

           |-----capacity--------|


push(13):
    -> haben wir genug Platz: length < capacity?
    -> Nein
    -> buffer groesser machen (wie genau besprechen wir spaeter)

            -> groesser machen
           +---------------------+
  buffer = | 34 | 35 | 420 | 69  |
           +---------------------+

           |-----length----------|

           |-----capacity--------|



           +---------------------------------------+
  buffer = | 34 | 35 | 420 | 69  |   |   |    |    |
           +---------------------------------------+

           |-----length----------|

           |-----capacity--------------------------|

    -> 13 am index length einfuegen

                                buffer[length] 
                                   |
                                   V
           +----------------------------------------+
  buffer = | 34 | 35 | 420 | 69  | 13 |   |    |    |
           +----------------------------------------+

           |-----length----------|

           |-----capacity---------------------------|


    -> length um eines erhoehen

           +----------------------------------------+
  buffer = | 34 | 35 | 420 | 69  | 13 |   |    |    |
           +----------------------------------------+

           |-----length---------------|

           |-----capacity---------------------------|

```


- `int pop()`
  - letztes element im array finden (wird sich immer bei `buffer[length - 1]` aufhalten)
  - dieses element entfernen (wird meistens gemacht indem man die )

Zur Veranschaulichung ein bisschen mehr ASCII Art
```
```

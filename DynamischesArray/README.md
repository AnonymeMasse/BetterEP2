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
> Fuehrerschein. Man weis wie man ein Auto faehrt -> man kann alle Autos fahren.

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
## void push(int element)

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

## `int pop()`
- `int pop()`
  - letztes element im array finden (wird sich immer bei `buffer[length - 1]` aufhalten)
  - dieses element entfernen (wird meistens gemacht indem man die `length` einfach dekrementiert also: `length -= 1`)
  - und das element zurueggeben

Zur Veranschaulichung ein bisschen mehr ASCII Art
```
Setup:

    length = 3
    capacity = 4

             +-------------------+
    buffer = | 69 | 420 | 13 |   |
             +-------------------+

             |-length--------|

             |---capacity--------|


    -> letztes element finden (buffer[length - 1])

                   buffer[length - 1]
                          |
                          V
             +-------------------+
    buffer = | 69 | 420 | 13 |   |
             +-------------------+

             |-length--------|

             |---capacity--------|


    int element = 13;

    -> element "entfernen" also length - 1

             +-------------------+
    buffer = | 69 | 420 | 13 |   |
             +-------------------+

             |-length---|

             |---capacity--------|

    -> element zurueggeben

    return element
```

> NOTE: wir entfernene nicht wirklich das Element aus unserem `buffer` sondern
> rechnen einfach die `length` - 1 damit sagen wir unserer `push` Funktion: 
> > "Jo dieser Platz ist frei du kannst hier neue Daten reinschreiben"


## `get(int index)`
- `get(index)`
- Finde das element am gegebenen index
- returne das element

MEHR ASCII ART:

```
Setup:
    length = 3;
    capacity = 4;

             +-----------------+
    buffer = | 30 | 30 | 9 |   |
             +-----------------+

             |--length-----|

             |--capacity-------|


get(2):
    -> element an index: 2 finden

                       buffer[2]
                         |
                         V
             +-----------------+
    buffer = | 30 | 30 | 9 |   |
             +-----------------+

             |--length-----|

             |--capacity-------|


    int element = buffer[2];
    element = 9

    -> element returnen

    return element

```

## Wie vergroessert man den `buffer`
Mit einer Funktion `private void grow()`. 
- wir hohlen uns einfach einen neuen buffer mit doppelter `capacity`
- kopieren alle unsere Elemente in diesen neuen buffer
- verwenden diesen `newBuffer` ab jetzt als unseren `buffer`
- updaten unsere `capacity` auf den neuen Wert.

ASCII Art is my passion

```
Setup:
    length = 2;
    capacity = 2;

             +----------+
    buffer = | 69 | 420 |
             +----------+

grow():
-> neuen buffer buffer hohlen mit doppelter capacity

    length = 2;
    capacity = 2;

                +----------+
    buffer =    | 69 | 420 |
                +----------+

                +------------------+
    newbuffer = |    |     |   |   |
                +------------------+

-> alten element rueberkopieren 

                +----------+
    buffer =    | 69 | 420 |
                +----------+
                  |    |
                  V    V
                +------------------+
    newbuffer = | 69 | 420 |   |   |
                +------------------+

-> newBuffer wird zu buffer

             +------------------+
    buffer = | 69 | 420 |   |   |
             +------------------+

-> updaten capacity
    capacity = capacity * 2;
```


> NOTE: die angegebenen Funktionen behandeln keine Fehler (was passiert zum
> Beispiel wenn man auf einem leeren dynamischen Array `.pop()` called).
> Allerdings sollte man zuerst lernen wie Sachen funktionieren sollten wenn
> alle Umstaende gut sind und sich dann erst anschauen was passiert wenn
> Bullshit passiert IMHO

> NOTE: die restlichen Funktionen sind noch nicht beschrieben da dies ein WIP
> ist und ich erstmal schauen moechte ob ueberhaupt interesse bestehen wuerde.

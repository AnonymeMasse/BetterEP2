# Objektorientierte Programmierung (OOP)

Objektorientierte Programmierung (OOP) ist eine Art von Programmierung, mit der versucht wird Entitäten aus der 
echten Welt in Programmen abzubilden. Diese Entitäten werden als Objekte bezeichnet.

In diesem Modul werden wir zusammen iterativ ein öffentliches Verkehrssystem mithilfe von OOP erstellen.
Wir werden uns vor allem damit beschäftigen wie mehrere Klassen miteinander interagieren können und wie in Folge
diese Klassen ein komplexes System bilden können.

In diesem ersten Modul werden noch Step-by-Step Anleitungen gegeben, um die Konzepte zu erklären.

## Domäne (Domain)

Wir wollen also ein öffentliches Verkehrssystem modellieren. Was brauchen wir dafür?

- Irgendeine Art von Fahrzeug (wir werden uns für U-Bahnen entscheiden)
- Fahrgäste
- Fahrkarten

Das ist die kleinste Menge an Klassen, mit der wir trotzdem schon Abläufe aus der echten Welt abbilden können.

## Schritt 1: Ticket

Wir fangen mit der "leichtesten" Klasse an, das Ticket ([Ticket.java](src/Ticket.java)).

Aus der echten Welt wissen wir, dass ein Ticket einen bestimmten Preis hat und für einen bestimmten Passagier gültig ist. 
Außerdem kann ein Ticket gültig oder ungültig sein. In der echten Welt gibt es natürlich viele Arten von Tickets (Einzelfahrten, Dauerkarten, etc.).
Aus Einfachheitsgründen haben wir uns dazu entschieden, dass ein Ticket einen Passagier dazu berechtigt genau eine Fahrt mit einer bestimmten Linie zu machen.

Also setzen wir uns nun an die Implementierung von `Ticket.java` und versuchen die oben genannten Eigenschaften in Code zu übersetzen.

### 1.1 Fields (Objektvariablen)

Zuerst implementieren wir die Informationen, die wir brauchen um ein Ticket zu erstellen als variablen in der Klasse.

Wir brauchen:
- Ein `int` für den Preis (`private`)
- Ein `String` für die Linie (`private`)
- Ein `String` für den Namen des Passagiers (`private`)

Fürs Erste setzen wir alles auf `private`, das ist immer ein gutes Grundprinzip. Es gibt wirklich wenig Ausnahmefälle, in denen wir Variablen `public` machen wollen.

### 1.2 Konstruktor

Nun überlegen wir uns welche Informationen wir brauchen um ein Ticket zu erstellen.
In diesem Fall müssen wir alle drei Variablen angeben. Also brauchen wir einen Konstruktor der alle drei Variablen als Parameter entgegennimmt.

<details>
<summary>Mehr erfahren</summary>
Das ist nicht immer so. Manchmal ist es sinnvoll einen Standardwert zu setzen, oder eine Variable kann mithilfe von abgeleiteter Information berechnet werden. 
</details>


Nun überlegen wir uns was für fehlerhafte Eingaben wir haben könnten.

- `price <= 0` 
- `line == null` oder `line == ""`
- `passengerName == null` oder `passengerName == ""`

Wir müssen also Validierung einbauen.

- Falls `price < 0` setzen wir `price = -1` um einen invaliden Ticket Status zu signalisieren.
- Falls `line == null` oder `line == ""` setzen wir `line = "unknown"` aus demselben Grund.
- Falls  `passengerName == null` oder `passengerName == ""` setzen wir `passengerName = "unknown"`

### 1.3 Funktionalität

Nun überlegen wir uns was für Funktionen jemand, der von außen auf ein Ticket zugreifen will brauchen könnte. 

- Man sollte in der Lage sein, zu wissen, wem das Ticket gehört, d.h. wir brauchen für `passengerName` einen Getter (`getPassengerName()`).
- Man sollte wissen wieviel ein Ticket kostet, damit es verkauft werden kann, also brauchen wir einen Getter für `price` (`getPrice()`).
- Es muss einen Weg geben, um herauszufinden, ob ein Ticket gültig ist.
  - Ein Ticket ist ungültig, wenn es invalide Daten enthält, also wenn `price <= 0`, `passengerName == "unknown"` oder `line == "unknown"` ist.
  - Dazu implementieren wir die Funktion `isValid()`
- Ein Kontrolleur sollte überprüfen können ob ein Ticket für eine bestimmte Linie gültig ist.
  - Dazu implementieren wir die Funktion `isValidForLine(String line)`.
  - Ein Ticket ist gültig für eine Linie, wenn das Ticket gültig ist und `this.line == line`.

Wir haben soeben 3 wichtige Prinzipien von OOP kennengelernt und selber implementiert.

- **Encapsulation (Kapselung)**: Wir mithilfe von Informationen aus der echten Welt eine Einheit aus Daten und Funktionalität erstellt.
- **Abstraction (Abstraktion)**: Wir haben uns überlegt, welche Informationen und Funktionalität für den Benutzer wichtig sind und diese in der Klasse implementiert.
    - Der Benutzer muss nicht wissen wie das Ticket intern funktioniert, aber kann durch die Methoden mit dem Ticket arbeiten.
- **Data Hiding**: Wir geben so wenig wie möglich über das innere der Klasse preis.
    - Wir haben die Variablen `private` gemacht, damit sie nicht von außen verändert werden können.
    - Wir haben Getter nur für triviale Variablen implementiert, die keine Logik enthalten.
    - Durch die Implementierung von `isValid()` und `isValidForLine()` haben wir die Logik in der Klasse versteckt, sodass der Benutzer nicht wissen muss wie das Ticket intern funktioniert.

<details>
<summary>Bonus Aufgabe</summary>
Man könnte auch die Funktionalität des Entwerten eines Tickets implementieren. Das würde gut über eine weitere Objektvariable `boolean isUsed` gehen.

Das Ticket könnte dann ungültig werden, wenn es entwertet wird.
</details>

## Schritt 2: Passenger

Als Nächstes gehen wir zu den Passagieren ([Passenger.java](src/Passenger.java)) über.

Ein Passagier hat einen Namen und einen Kontostand (`balance`) mit dem Tickets gekauft werden können. Außerdem hält er sich immer an einer bestimmten Position (`String` location) auf.

Ein neuer Passagier hat immer einen Kontostand von 100, und spawned am `"Karlsplatz"`.

Da wir nun Standardwerte für `balance` und `location` haben, brauchen wir einen Konstruktor, der nur den Namen des Passagiers entgegennimmt.
Falls `name == null` oder `name == ""` setzen wir `name = "unknown"` um klarzumachen, dass der Passagier nicht existiert.

### 2.1 Verbindung zu Ticket

Ein Passagier muss auch in der Lage sein, Tickets zu kaufen. 
Die gekauften Tickets müssen wir speichern, da wir nicht wissen wieviele Tickets ein Passagier besitzen kann, brauchen wir eine Liste von Tickets, in diesem Fall benutzen wir eine `ArrayList<Ticket>`. 
Diese funktioniert ähnlich wie die Datenstruktur im Modul `DynamicArray`.
Diese Liste ist von uns schon gegeben und initialisiert:

```java
private ArrayList<Ticket> tickets = new ArrayList<>();
```

Diese hat folgende für uns wichtige Funktionalitäten:

- `add(Ticket ticket)`: Fügt ein Ticket zur Liste hinzu.
- `remove(int index)`: Entfernt das Ticket an der Stelle `index`.
- `size()`: Gibt die Anzahl der Tickets in der Liste zurück. Mithilfe dieser Funktion können wir durch die Liste iterieren.

### 2.2 Funktionalität

Als Erstes implementieren wir die Getter `getName()`, `getBalance()` und `getLocation()`.

#### 2.2.1 Tickets kontrollieren

Als Nächstes muss ein Kontrolleuer überprüfen können, ob ein Passagier ein Ticket für eine bestimmte Linie hat.

Dazu implementieren wir die Funktion `hasTicketForLine(String line)`. 
Diese Methode iteriert durch die Liste der Tickets und überprüft, ob eines der Tickets gültig ist und für die angegebene Linie gültig ist.
Da wir nun brav vorausgedacht haben und schon eine Methode `isValidForLine(String line)` in der Klasse `Ticket` implementiert haben, können wir diese hier einfach verwenden.

Falls keins der Tickets gültig oder die angegebene Linie `null` bzw. `""` ist, gibt die Methode `false` zurück. Andernfalls gibt sie `true` zurück.
Falls die angegebene Linie `null` oder `line == ""` ist, gibt die Methode `false` zurück.

#### 2.2.2 Ticket kaufen

Ein Passagier muss auch in der Lage sein, Tickets zu kaufen.
Dazu implementieren wir die Funktion `buyTicket(Ticket ticket)`.
Diese Methode überprüft, ob der Passagier genug Geld hat, um das Ticket zu kaufen: 

- Falls ja, wird das Ticket zur Liste der Tickets hinzugefügt und der Kontostand des Passagiers um den Preis des Tickets verringert.
- Falls nicht, returnen wir `false`.

Falls das Ticket ungültig oder `null` ist, returnen wir `false`.

Fürs Erste ist das alles, was wir brauchen. Wir haben nun eine Klasse, die einen Passagier repräsentiert und die Funktionalität hat, Tickets zu kaufen und zu überprüfen, ob ein Passagier ein Ticket für eine bestimmte Linie hat.

> Die Methode `exitAtSubwayStation()` ist zum jetztigen Zeitpunkt zu ignorieren, da wir uns noch nicht mit U-Bahnen beschäftigt haben.

## Schritt 3: Subway

Um jetzt wirklich zu sehen, wie sich all diese Klassen zusammenfügen, implementieren wir die Klasse `Subway` ([Subway.java](src/Subway.java)).

Wir überlegen uns wieder, was eine U-Bahn braucht, um zu funktionieren.

- Sie ist zugehörig zu einer Linie (`String line`), falls nicht angegeben, ist die Linie `"unknown"`.
- Sie ist immer an einem bestimmten Ort (`String location`), falls nicht angegeben, ist der Ort `"unknown"`.
- Sie hat Sitzplätze an denen Passagiere sitzen können.
  - Das bilden wir durch ein Array `Passenger[] passengers` ab. Falls ein Sitzplatz leer ist, ist der Wert `null`.
  - Die Anzahl der Sitzplätze ist `int capacity`, falls nicht angegeben, ist die Anzahl der Sitzplätze 100.
  - Wenn eine U-Bahn gebaut (instanziert) wird, erstellen wir also ein Array mit der Größe `capacity`.

### 3.1 Funktionalität

Wir brauchen mal wieder simple Getter für die Variablen `getLine()`, `getLocation()` und `getCapacity()`.

Nun zur wirklichen Funktionalität einer U-Bahn, eine U-Bahn kann:

- sich bewegen (`moveTo(String location)`)
- einen Passagier aufnehmen (`pickUpPassenger(Passenger passenger)`)
- einen Passagier absetzen (`dropOffPassenger(String name)`)
  - Bzw. mehrere Passagiere absetzen (`dropOffPassengers(String[] names)`).

#### 3.1.2 U-Bahn bewegen

Eine U-Bahn kann sich bewegen, indem sie ihre `location` ändert. 
Falls die neue `location` `null` oder `""` ist, ändert sich nichts an der `location`. 
Ansonsten setzen wir die `location` auf die neue `location`.

#### 3.1.3 Passagier aufnehmen

Diese Methode modelliert das Einsteigen eines Passagiers in die U-Bahn.

- Falls der Passagier `null` ist, returnen wir `false`.
- Falls die U-Bahn voll ist, returnen wir `false`.
- Falls der Passagier nicht an der gleichen `location` wie die U-Bahn ist, returnen wir `false`.
- Falls der Passagier kein Ticket für die Linie hat, returnen wir `false`.
  - Dazu verwenden wir die Methode `hasTicketForLine(String line)` aus der Klasse `Passenger`.

Sonst setzen wir den Passagier an den ersten freien Platz in der U-Bahn und returnen `true`.

#### 3.1.4 Passagier absetzen

Diese Methode modelliert das Aussteigen eines Passagiers aus der U-Bahn.

Dazu gehen wir nochmal zurück in die Klasse `Passenger` und implementieren die Methode `exitAtStation(String line, String station)`.

#### 3.1.5 Aussteigen eines Passagiers 

Diese Methode entfernt EIN (!) Ticket, das gültig für die angegebene Linie (Tipp: `ticket.isValidForLine()`) ist, und setzt die `location` des Passagiers auf die angegebene Station.

- Falls die `line` oder die `station` `null` oder `""` sind, returnen wir `false`. 
- Falls der Passagier kein Ticket für die angegebene Linie hat, returnen wir `false`.

Ansonsten können wir das Ticket entfernen und die `location` des Passagiers auf die angegebene Station setzen und returnen `true`.

Nun widmen wir uns wieder der U-Bahn (`dropOffPassenger(String name)`).

- Falls der Name `null` oder `""` ist, returnen wir `false`.
- Falls die U-Bahn leer ist, returnen wir `false`.
- Falls der Passagier nicht in der U-Bahn ist, returnen wir `false`.

Ansonsten lassen wir den Passagier aussteigen (`passenger.exitAtStation(line, location)`). Wenn uns diese methode `true` zurückgibt, setzen wir den Platz auf `null` und returnen `true`. Ansonsten returnen wir `false`.

#### 3.1.6 Mehrere Passagiere absetzen

Diese Methode ist sehr ähnlich zu `dropOffPassenger(String name)`, nur dass wir hier mehrere Passagiere absetzen können.

Wir iterieren durch alle Plätze und setzen alle Passagiere ab, dessen Namen im Array `names` enthalten sind.
Das machen wir, indem wir die Methode `dropOffPassenger(String name)` aufrufen.

- Falls alle Passagiere korrekt abgesetzt wurden, returnen wir `true`.
- Falls nicht oder `names` `null` ist, returnen wir `false`.


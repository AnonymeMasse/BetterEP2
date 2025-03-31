public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Tests
        // AUTHOR NOTE: es ist ein Work In Progress ich moechte hier eigentlich mehr tests sehen aber will erstmal schauen ob bedarf da ist.
        Musterloesung array = new Musterloesung();
        for (int i = 0; i < 100; i += 1) {
            array.push(i);
        }
        for (int i = 0; i < 100; i += 1) {
            assert array.get(i) == i;
        }
        for (int i = 99; i >= 0; i -= 1) {
            assert array.pop() == i;
        }
    }
}
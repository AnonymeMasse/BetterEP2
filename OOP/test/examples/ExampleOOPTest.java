package examples;

import interfaces.IOOPTest;
import interfaces.IPassenger;
import interfaces.ISubway;
import interfaces.ITicket;

public class ExampleOOPTest implements IOOPTest {


    @Override
    public ITicket createTicket(String passengerName, String line, int price) {
        return new ExampleTicket(passengerName, line, price);
    }

    @Override
    public IPassenger createPassenger(String name) {
        return new ExamplePassenger(name);
    }

    @Override
    public ISubway createSubway(String id, String startStation, int capacity) {
        return new ExampleSubway(id, capacity, startStation);
    }
}

import interfaces.IOOPTest;
import interfaces.IPassenger;
import interfaces.ISubway;
import interfaces.ITicket;

public class OOPTest implements IOOPTest {
    @Override
    public ITicket createTicket(String passengerName, String line, int price) {
        return new Ticket(passengerName, line, price);
    }

    @Override
    public IPassenger createPassenger(String name) {
        return new Passenger(name);
    }

    @Override
    public ISubway createSubway(String id, String startStation, int capacity) {
        return new Subway(id, capacity, startStation);
    }
}

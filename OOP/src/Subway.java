import interfaces.IPassenger;
import interfaces.ISubway;

public class Subway implements ISubway {

    // 1.1 Create fields for id, capacity, and passengers

    // 1.2 Choose appropriate data types and access type for each field
    private Passenger[] passengers;

    // 2.1 Create a constructor to initialize the fields

    public Subway(String id, int capacity, String startStation) {

    }

    // 2.2 Think about reasonable constraints for the parameters
    // For example, capacity should be a positive integer

    // 3. Implement some simple getters

    @Override
    public Integer getCapacity() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public String getLine() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public String getLocation() {
        return "";
    }

    // 4. Implement the moveTo method

    @Override
    public void moveTo(String station) {
        // TODO: Implement this method
    }

    @Override
    public Boolean dropOffPassenger(String name) {
        return null;
    }

    // 5. Implement the exitPassengers method

    @Override
    public Boolean dropOffPassengers(String[] names) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public Boolean pickupPassenger(IPassenger iPassenger) {
        return null;
    }

    // used for testing, in a real world application this would be private/not exist.
    @Override
    public IPassenger[] getSeats() {
        return passengers;
    }

}

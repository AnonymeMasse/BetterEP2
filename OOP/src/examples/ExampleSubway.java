package examples;

import interfaces.IPassenger;
import interfaces.ISubway;

public class ExampleSubway implements ISubway {

    private String line;
    private int capacity;
    private final ExamplePassenger[] seats;
    private String location;

    public ExampleSubway(String line, int capacity, String startLocation) {
        setLine(line);
        setCapacity(capacity);
        setLocation(startLocation);
        this.seats = new ExamplePassenger[this.capacity];
    }

    @Override
    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String getLine() {
        return line;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void moveTo(String station) {
        if (location == null || location.isBlank())
            return;

        this.location = station;
    }

    @Override
    public Boolean dropOffPassengers(String[] names) {
        if (names == null)
            return false;

        boolean removedAll = true;
        for (String name : names) {
            boolean success = dropOffPassenger(name);
            if (!success)
                removedAll = false;
        }

        return removedAll;
    }

    @Override
    public Boolean dropOffPassenger(String name) {
        if (name == null || name.isBlank())
            return false;

        for (int i = 0; i < capacity; i++) {
            if (seats[i] == null)
                continue;

            if (seats[i].getName().equals(name)) {
                boolean success = seats[i].exitAtStation(line, location);
                if (!success)
                    return false;
                seats[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean pickupPassenger(IPassenger iPassenger) {
        ExamplePassenger passenger = (ExamplePassenger) iPassenger;

        if (passenger == null)
            return false;

        if (!passenger.getLocation().equals(location))
            return false;

        if (!passenger.hasTicketForLine(line))
            return false;

        for (int i = 0; i < capacity; i++) {
            if (seats[i] == null) {
                seats[i] = passenger;
                return true;
            }
        }

        return false;
    }

    private void setLine(String line) {
        if (line == null || line.isBlank())
            this.line = "unknown";
        else
            this.line = line;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0)
            this.capacity = 100;
        else
            this.capacity = capacity;
    }

    private void setLocation(String newLocation) {
        if (newLocation == null || newLocation.isBlank())
            this.location = "unknown";
        else
            location = newLocation;
    }

    @Override
    public IPassenger[] getSeats() {
        return seats;
    }

}

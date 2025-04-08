package examples;

import interfaces.IPassenger;
import interfaces.ITicket;

import java.util.ArrayList;

public class ExamplePassenger implements IPassenger {

    private String name;
    private int balance = 100;
    private String location = "Karlsplatz";
    private final ArrayList<ExampleTicket> tickets = new ArrayList<>();

    public ExamplePassenger(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public Boolean hasTicketForLine(String line) {
        if (line == null || line.isBlank())
            return false;

        for (ExampleTicket ticket : tickets) {
            if (ticket.isValidForLine(line))
                return true;
        }

        return false;
    }

    @Override
    public Boolean buyTicket(ITicket iTicket) {
        ExampleTicket ticket = (ExampleTicket) iTicket;

        if (ticket == null || !ticket.isValid())
            return false;

        int newBalance = balance - ticket.getPrice();
        if (newBalance < 0)
            return false;

        balance = newBalance;
        tickets.add(ticket);
        return true;
    }

    @Override
    public Boolean exitAtStation(String line, String station) {
        if (line == null || line.isBlank())
            return false;

        for (int i = 0; i < tickets.size(); i++) {
            ExampleTicket ticket = tickets.get(i);
            if (ticket.isValidForLine(line)) {
                tickets.remove(i);
                moveTo(station);
                return true;
            }
        }

        return false;
    }

    private void moveTo(String newLocation) {
        if (newLocation == null || newLocation.isBlank())
            return;

        location = newLocation;
    }

    private void setName(String name) {
        if (name == null || name.isBlank())
            this.name = "unknown";
        else
            this.name = name;
    }

}

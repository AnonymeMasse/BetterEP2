import interfaces.IPassenger;
import interfaces.ITicket;

import java.util.ArrayList;

public class Passenger implements IPassenger {

    // TODO: Implement neceessarry attributes

    // this is the list that will be used to store the tickets, please do not change
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    /**
     * Constructor for the Passenger class.
     *
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        // TODO: Implement constructor
    }

    /**
     * Returns the name of the passenger.
     *
     * @return the name of the passenger
     */
    @Override
    public String getName() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the location of the passenger.
     *
     * @return the location of the passenger
     */
    @Override
    public String getLocation() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the balance of the passenger.
     *
     * @return the balance of the passenger
     */
    @Override
    public Integer getBalance() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Checks if the passenger has a valid ticket for a specific line.
     *
     * @param line the line to check
     * @return true if the passenger has a valid ticket for the given line, false otherwise or if the line is null or empty
     */
    @Override
    public Boolean hasTicketForLine(String line) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Buys a ticket for the passenger and adds it to the list of tickets.
     *
     * @param iTicket the ticket to buy
     * @return true if the ticket was bought successfully, false otherwise
     */
    @Override
    public Boolean buyTicket(ITicket iTicket) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Moves the passenger to a new location and removes the used ticket from the list of tickets.
     *
     * @param station the station at which the passenger exits the subway
     * @param line the line the passenger is exiting
     * @return true if the passenger exited successfully, false otherwise
     */
    @Override
    public Boolean exitAtStation(String line, String station) {
        // TODO: Implement this method
        return null;
    }

}

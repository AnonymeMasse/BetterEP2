import interfaces.ITicket;

public class Ticket implements ITicket {

    // TODO: Implement neceessarry attributes

    /**
     * Constructor for the Ticket class.
     *
     * @param passengerName the name of the passenger who purchased the ticket
     * @param line the line for which the ticket is valid
     * @param price the price of the ticket
     */
    public Ticket(String passengerName, String line, int price) {
        // TODO: Implement constructor
    }


    /**
     * Returns the name of the passenger who purchased the ticket.
     *
     * @return the name of the passenger
     */
    @Override
    public String getPassengerName() {
        //TODO: Implement this method
        return null;
    }

    /**
     * Returns the price of the ticket.
     *
     * @return the price of the ticket
     */
    @Override
    public Integer getPrice() {
        //TODO: Implement this method
        return null;
    }

    /**
     * Checks if the ticket is valid, i.e. if the passenger name, line, and price are valid.
     *
     * @return true if the ticket is valid, false otherwise
     */
    @Override
    public Boolean isValid() {
        //TODO: Implement this method
        return null;
    }

    /**
     * Checks if the ticket is valid for a specific line.
     *
     * @param line the line to check
     * @return true if the ticket is valid and issued for the given line, false otherwise
     */
    @Override
    public Boolean isValidForLine(String line) {
        //TODO: Implement this method
        return null;
    }

}

package interfaces;

public interface IPassenger {

    String getName();
    String getLocation();
    Integer getBalance();
    Boolean hasTicketForLine(String line);
    Boolean buyTicket(ITicket iTicket);
    Boolean exitAtStation(String line, String station);


}

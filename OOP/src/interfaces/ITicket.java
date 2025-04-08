package interfaces;

public interface ITicket {

    String getPassengerName();
    Integer getPrice();
    Boolean isValid();
    Boolean isValidForLine(String line);

}

package interfaces;

public interface ISubway {

    Integer getCapacity();
    String getLine();
    String getLocation();
    void moveTo(String station);
    Boolean dropOffPassenger(String name);
    Boolean dropOffPassengers(String[] names);
    Boolean pickupPassenger(IPassenger iPassenger);
    IPassenger[] getSeats();

}

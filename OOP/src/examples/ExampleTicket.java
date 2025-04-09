package examples;

import interfaces.ITicket;

public class ExampleTicket implements ITicket {

    private String passengerName;
    private String line;
    private int price;

    public ExampleTicket(String passengerName, String line, int price) {
        setPassengerName(passengerName);
        setLine(line);
        setPrice(price);
    }

    @Override
    public String getPassengerName() {
        return passengerName;
    }

    @Override
    public Boolean isValidForLine(String line) {
        if (!isValid() || line == null || line.isBlank())
            return false;

        return this.line.equals(line);
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public Boolean isValid() {
        return !this.passengerName.equals("unknown") && !this.line.equals("unknown") && this.price > 0;
    }

    private void setPassengerName(String passengerName) {
        if (passengerName == null || passengerName.isBlank())
            this.passengerName = "unknown";
        else
            this.passengerName = passengerName;
    }

    private void setLine(String line) {
        if (line == null || line.isBlank())
            this.line = "unknown";
        else
            this.line = line;
    }

    private void setPrice(int price) {
        if (price <= 0)
            this.price = -1;
        else
            this.price = price;
    }
}

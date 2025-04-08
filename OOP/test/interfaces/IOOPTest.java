package interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.OOPTestUtils.passengerArrayContainsName;

public interface IOOPTest {

    ITicket createTicket(String passengerName, String line, int price);
    IPassenger createPassenger(String name);
    ISubway createSubway(String id, String startStation, int capacity);

    @Test
    @DisplayName("Creating a Ticket with valid data should give me back a Ticket with the same data")
    default void testTicket() {
        ITicket ticket = createTicket("John Doe", "U4", 5);

        assertNotNull(ticket, "Ticket should not be null");
        assertNotNull(ticket.getPassengerName(), "Passenger name should not be null");
        assertTrue(ticket.isValidForLine("U4"), "Ticket should be valid for U4");
        assertTrue(ticket.isValid(), "Ticket should be valid");
        assertEquals(5, ticket.getPrice(), "Price should be 5");
    }

    @Test
    @DisplayName("Creating a Ticket with faulty data should set the data")
    default void testTicketWithFaultyData() {
        ITicket ticket = createTicket(null, null, -1);

        assertNotNull(ticket, "Ticket should not be null");
        assertEquals("unknown", ticket.getPassengerName(), "Passenger name should be unknown");
        assertFalse(ticket.isValid());
        assertFalse(ticket.isValidForLine("U4"), "A ticket with faulty data should not be valid for any line");
        assertEquals(-1, ticket.getPrice(), "Price should be -1 (invalid)");
    }

    @Test
    @DisplayName("Creating a ticket with only invalid name should be invalid")
    default void testTicketWithOnlyInvalidName() {
        ITicket ticket = createTicket("", "U4", 5);

        assertNotNull(ticket, "Ticket should not be null");
        assertEquals("unknown", ticket.getPassengerName(), "Passenger name should be unknown");
        assertFalse(ticket.isValid());
        assertFalse(ticket.isValidForLine("U4"), "A ticket with faulty data should not be valid for any line");
        assertEquals(5, ticket.getPrice(), "Price should be 5");
    }

    @Test
    @DisplayName("Creating a ticket with only invalid line should be invalid")
    default void testTicketWithOnlyInvalidLine() {
        ITicket ticket = createTicket("John Doe", "", 5);

        assertNotNull(ticket, "Ticket should not be null");
        assertEquals("John Doe", ticket.getPassengerName(), "Passenger name should be 'John Doe'");
        assertFalse(ticket.isValid());
        assertFalse(ticket.isValidForLine("U4"), "A ticket with faulty data should not be valid for any line");
        assertEquals(5, ticket.getPrice(), "Price should be 5");
    }

    @Test
    @DisplayName("Creating a ticket with only invalid price should be invalid")
    default void testTicketWithOnlyInvalidPrice() {
        ITicket ticket = createTicket("John Doe", "U4", -1);

        assertNotNull(ticket, "Ticket should not be null");
        assertEquals("John Doe", ticket.getPassengerName(), "Passenger name should be 'John Doe'");
        assertFalse(ticket.isValid());
        assertFalse(ticket.isValidForLine("U4"), "A ticket with faulty data should not be valid for any line");
        assertEquals(-1, ticket.getPrice(), "Price should be -1 (invalid)");
    }

    @Test
    @DisplayName("Creating a Passenger with valid data should give me back a Passenger with the same data")
    default void testPassenger() {
        IPassenger passenger = createPassenger("John Doe");
        assertNotNull(passenger, "Passenger should not be null");
        assertNotNull(passenger.getName(), "Passenger name should not be null");
        assertEquals("John Doe", passenger.getName(), "Passenger name should be 'John Doe'");
    }

    @Test
    @DisplayName("Creating a Passenger with faulty data should not set the data")
    default void testPassengerWithFaultyData() {
        IPassenger passenger = createPassenger("");
        assertNotNull(passenger, "Passenger should not be null");
        assertEquals("unknown", passenger.getName(), "Passenger name should be empty");
    }

    @Test
    @DisplayName("Creating a Subway with valid data should give me back a Subway with the same data")
    default void testSubway() {
        ISubway subway = createSubway("U4", "Karlsplatz", 100);
        assertNotNull(subway, "Subway should not be null");
        assertNotNull(subway.getLine(), "Subway ID should not be null");
        assertNotNull(subway.getLocation(), "Subway start station should not be null");
        assertEquals(100, subway.getCapacity(), "Subway capacity should be 100");
    }

    @Test
    @DisplayName("Creating a Subway with faulty data should not set the data")
    default void testSubwayWithFaultyData() {
        ISubway subway = createSubway(null, null, -1);
        assertNotNull(subway, "Subway should not be null");
        assertEquals("unknown", subway.getLine(), "Subway ID should be unknown");
        assertEquals("unknown", subway.getLocation(), "Subway start station should be unknown");
        assertEquals(100, subway.getCapacity(), "Subway capacity should be 100");
    }

    @Test
    @DisplayName("Updating the location of a Subway should change its location")
    default void testSubwayLocationUpdate() {
        ISubway subway = createSubway("U4", "Karlsplatz", 100);
        subway.moveTo("Pilgramgasse");
        assertEquals("Pilgramgasse", subway.getLocation(), "Subway location should be 'Pilgramgasse'");
    }

    // Functional tests

    @Test
    @DisplayName("When a Passenger buys a Ticket, the balance should be reduced by the Ticket price")
    default void testTicketBuyingReducesBalance() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");

        boolean success = passenger.buyTicket(ticket);

        assertTrue(success, "Passenger should be able to buy the ticket");
        assertEquals(95, passenger.getBalance(), "Passenger balance should be 95");
    }

    @Test
    @DisplayName("When a Passenger buys a Ticket, the Ticket should be added to the Passenger's tickets")
    default void testTicketBuyingAddsTicket() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");

        passenger.buyTicket(ticket);

        assertTrue(passenger.hasTicketForLine("U4"), "Passenger should have a ticket for U4");
    }

    @Test
    @DisplayName("When a Passenger with a Ticket enters a Subway, the Passenger should be added to the Subway")
    default void testPassengerEntersSubway() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        boolean success = subway.pickupPassenger(passenger);

        assertTrue(success, "Passenger should be able to enter the subway");
        assertTrue(passengerArrayContainsName("John Doe", subway.getSeats()), "Passenger should be in the subway");
    }

    @Test
    @DisplayName("When a Passenger without a Ticket tries to enter a Subway, the Passenger should not be added to the Subway")
    default void testPassengerWithoutTicketCannotEnterSubway() {
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        boolean success = subway.pickupPassenger(passenger);

        assertFalse(success, "Passenger should not be able to enter the subway without a ticket");
        assertFalse(passengerArrayContainsName("John Doe", subway.getSeats()), "Passenger should not be in the subway");
    }

    @Test
    @DisplayName("When a Passenger at the wrong location tries to enter a Subway, the Passenger should not be added to the Subway")
    default void testPassengerAtWrongLocationCannotEnterSubway() {
        ITicket ticket = createTicket("John Doe", "U1", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U1", "Stephansplatz", 100);

        passenger.buyTicket(ticket);
        boolean success = subway.pickupPassenger(passenger);

        assertFalse(success, "Passenger should not be able to enter the subway at the wrong location");
        assertFalse(passengerArrayContainsName("John Doe", subway.getSeats()), "Passenger should not be in the subway");
    }

    @Test
    @DisplayName("When a Passenger tries to enter a Subway that is full, the Passenger should not be added to the Subway")
    default void testPassengerCannotEnterFullSubway() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        IPassenger secondPassenger = createPassenger("Marie Mustermann");
        ISubway subway = createSubway("U4", "Karlsplatz", 1);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        boolean success = subway.pickupPassenger(secondPassenger);

        assertFalse(success, "Second passenger should not be able to enter the full subway");
        assertTrue(passengerArrayContainsName("John Doe", subway.getSeats()), "First passenger should be in the subway");
        assertFalse(passengerArrayContainsName("Marie Mustermann", subway.getSeats()), "Second passenger should not be in the subway");
    }

    @Test
    @DisplayName("When a null Passenger tries to enter a Subway, the Passenger should not be added to the Subway")
    default void testNullPassengerCannotEnterSubway() {
        ISubway subway = createSubway("U4", "Karlsplatz", 100);
        boolean success = subway.pickupPassenger(null);

        assertFalse(success, "Null passenger should not be able to enter the subway");
    }

    // exitSubway (single)

    @Test
    @DisplayName("When a Passenger exits a Subway, the Passenger should be removed from the Subway")
    default void testPassengerExitsSubway() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        boolean success = subway.dropOffPassenger("John Doe");

        assertTrue(success, "Passenger should be able to exit the subway");
        assertFalse(passengerArrayContainsName("John Doe", subway.getSeats()), "Passenger should not be in the subway");
    }

    @Test
    @DisplayName("When a Passenger with a Ticket exits a Subway, the Ticket should be removed from the Passenger's tickets")
    default void testPassengerExitsSubwayRemovesTicket() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        subway.dropOffPassenger("John Doe");

        assertFalse(passenger.hasTicketForLine("U4"), "Passenger should not have a ticket for U4 anymore");
    }

    @Test
    @DisplayName("When a Passenger exits a Subway, the Passenger should be moved to the exit location")
    default void testPassengerExitsSubwayMovesToExitLocation() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        subway.moveTo("Pilgramgasse");
        subway.dropOffPassenger("John Doe");

        assertEquals("Pilgramgasse", passenger.getLocation(), "Passenger should be at Pilgramgasse after exiting");
    }

    @Test
    @DisplayName("When a Passenger exits a Subway with a null name, the Passenger should not be removed from the Subway")
    default void testNullPassengerCannotExitSubway() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        boolean success = subway.dropOffPassenger(null);

        assertFalse(success, "Null passenger should not be able to exit the subway");
        assertTrue(passengerArrayContainsName("John Doe", subway.getSeats()), "Passenger should still be in the subway");
    }

    @Test
    @DisplayName("When a Passenger that is not in the Subway tries to exit, the Passenger should not be removed from the Subway")
    default void testPassengerNotInSubwayCannotExit() {
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        boolean success = subway.dropOffPassenger("John Doe");

        assertFalse(success, "Passenger should not be able to exit the subway if not in it");
    }

    // exit Passenger (multiple)

    @Test
    @DisplayName("When multiple Passengers exit a Subway, all Passengers should be removed from the Subway")
    default void testMultiplePassengersExitSubway() {
        IPassenger passenger = createPassenger("John Doe");
        ITicket ticket = createTicket(passenger.getName(), "U4", 5);
        IPassenger secondPassenger = createPassenger("Marie Mustermann");
        ITicket secondTicket = createTicket(secondPassenger.getName(), "U4", 5);
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        secondPassenger.buyTicket(secondTicket);
        subway.pickupPassenger(passenger);
        subway.pickupPassenger(secondPassenger);
        boolean success = subway.dropOffPassengers(new String[]{"John Doe", "Marie Mustermann"});

        assertTrue(success, "Both passengers should be able to exit the subway");
        assertFalse(passengerArrayContainsName("John Doe", subway.getSeats()), "First passenger should not be in the subway");
        assertFalse(passengerArrayContainsName("Marie Mustermann", subway.getSeats()), "Second passenger should not be in the subway");
    }

    @Test
    @DisplayName("When multiple Passengers exit a Subway, all Passengers should be removed from the Subway and moved to the exit location")
    default void testMultiplePassengersExitSubwayMovesToExitLocation() {
        IPassenger passenger = createPassenger("John Doe");
        ITicket ticket = createTicket(passenger.getName(), "U4", 5);
        IPassenger secondPassenger = createPassenger("Marie Mustermann");
        ITicket secondTicket = createTicket(secondPassenger.getName(), "U4", 5);
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        secondPassenger.buyTicket(secondTicket);
        subway.pickupPassenger(passenger);
        subway.pickupPassenger(secondPassenger);
        subway.moveTo("Pilgramgasse");
        subway.dropOffPassengers(new String[]{"John Doe", "Marie Mustermann"});

        assertEquals("Pilgramgasse", passenger.getLocation(), "First passenger should be at Pilgramgasse after exiting");
        assertEquals("Pilgramgasse", secondPassenger.getLocation(), "Second passenger should be at Pilgramgasse after exiting");
    }

    @Test
    @DisplayName("Moving inbetween passengers existing should result in correct passenger locations")
    default void testMultiplePassengersExitSubwayMovesToExitLocationWithInterveningMove() {
        IPassenger passenger = createPassenger("John Doe");
        ITicket ticket = createTicket(passenger.getName(), "U4", 5);
        IPassenger secondPassenger = createPassenger("Marie Mustermann");
        ITicket secondTicket = createTicket(secondPassenger.getName(), "U4", 5);
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        secondPassenger.buyTicket(secondTicket);
        subway.pickupPassenger(passenger);
        subway.pickupPassenger(secondPassenger);
        subway.moveTo("Pilgramgasse");
        subway.dropOffPassenger("John Doe");
        assertEquals("Pilgramgasse", passenger.getLocation(), "First passenger should be at Pilgramgasse after exiting");
        subway.moveTo("Schönbrunn");
        subway.dropOffPassenger("Marie Mustermann");
        assertEquals("Schönbrunn", secondPassenger.getLocation(), "Second passenger should be at Karlsplatz after exiting");
    }

    @Test
    @DisplayName("When null Passengers try to exit a Subway, the method should return false")
    default void testNullPassengerCannotExitSubwayMultiple() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        boolean success = subway.dropOffPassengers(null);

        assertFalse(success, "Null passenger should not be able to exit the subway");
    }

    @Test
    @DisplayName("When a Passenger that is not in the Subway tries to exit, the Passenger should not be removed from the Subway")
    default void testPassengerNotInSubwayCannotExitMultiple() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        boolean success = subway.dropOffPassengers(new String[]{"John Doe"});

        assertFalse(success, "Passenger should not be able to exit the subway if not in it");
    }

    @Test
    @DisplayName("When 0 Passengers try to exit a Subway, the method should return true")
    default void testZeroPassengerCannotExitSubwayMultiple() {
        ITicket ticket = createTicket("John Doe", "U4", 5);
        IPassenger passenger = createPassenger("John Doe");
        ISubway subway = createSubway("U4", "Karlsplatz", 100);

        passenger.buyTicket(ticket);
        subway.pickupPassenger(passenger);
        boolean success = subway.dropOffPassengers(new String[]{});

        assertTrue(success, "0 passengers should be able to exit the subway");
    }

}

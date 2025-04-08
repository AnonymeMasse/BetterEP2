package util;

import interfaces.IPassenger;

public class OOPTestUtils {

    public static boolean passengerArrayContainsName(String name, interfaces.IPassenger[] passengers) {
        if (name == null || name.isBlank() || passengers == null)
            return false;

        for (IPassenger passenger : passengers) {
            if (passenger == null)
                continue;
            if (passenger.getName().equals(name))
                return true;
        }
        return false;
    }
}

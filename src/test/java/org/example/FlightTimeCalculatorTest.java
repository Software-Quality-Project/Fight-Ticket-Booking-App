package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlightTimeCalculatorTest {

    @Test
    public void testCalculateTotalFlightTime() {
        // Test calculating total flight time for valid departure and arrival times
        FlightTimeCalculator calculator = new FlightTimeCalculator();
        String departureTime = "08:00";
        String arrivalTime = "10:30";
        int expectedTotalMinutes = 150; // 2 hours and 30 minutes

        int totalMinutes = calculator.calculateTotalFlightTime(departureTime, arrivalTime);

        assertEquals(expectedTotalMinutes, totalMinutes);
    }
}

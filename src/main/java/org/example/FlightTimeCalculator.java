package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class FlightTimeCalculator {

    // Method to calculate total flight time
    public int calculateTotalFlightTime(String departureTime, String arrivalTime) {
        // Parse departure and arrival times
        LocalTime departure = LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime arrival = LocalTime.parse(arrivalTime, DateTimeFormatter.ofPattern("HH:mm"));

        // Calculate total flight time in minutes
        int totalMinutes = calculateMinutesBetween(departure, arrival);

        // Return total flight time
        return totalMinutes;
    }

    // private method to calculate minutes between two LocalTime instances
    private int calculateMinutesBetween(LocalTime start, LocalTime end) {
        return (int) java.time.Duration.between(start, end).toMinutes();
    }
}

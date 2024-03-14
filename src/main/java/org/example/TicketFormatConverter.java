package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TicketFormatConverter {

    // Method to convert time to 12-hour format
    public String convertTo12HourFormat(String time) {
        // Parse the time string to LocalTime object
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));

        // Format the LocalTime object to 12-hour format
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

        // Return the formatted time
        return formattedTime;
    }

    // Method to convert time to 24-hour format
    public String convertTo24HourFormat(String time) {
        // Parse the time string to LocalTime object
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"));

        // Format the LocalTime object to 24-hour format
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Return the formatted time
        return formattedTime;
    }
}


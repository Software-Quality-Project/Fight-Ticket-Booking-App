package org.example;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private String departureDate;
    private String seatClass;

    // Constructor
    public Flight(String flightNumber, String departureAirport, String destinationAirport, String departureDate, String seatClass) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.seatClass = seatClass;

    }

    // Getters for flight details
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getSeatClass() {
        return seatClass;
    }
}


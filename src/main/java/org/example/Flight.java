package org.example;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String flightClass;

    // Constructor
    public Flight(String flightNumber, String departureAirport, String destinationAirport, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String flightClass) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.flightClass = flightClass;

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

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
    
    public String getFlightClass() {
        return flightClass;
    }
}


package org.example;

public class Ticket {
    private String flightNumber;
    private String seatNumber;
    private String flightClass;
    private String departureAirport;
    private String destinationAirport;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private int flightTime;

    // Constructor
    public Ticket(String flightNumber, String seatNumber, String flightClass, String departureAirport, String destinationAirport, String departureDate, String departureTime , String arrivalDate, String arrivalTime , int flightTime) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.flightClass = flightClass;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.flightTime = flightTime;
    }

    // Getters...
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getFlightClass() {
        return flightClass;
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

    public int getFlightTime() {
        return flightTime;
    }
}

package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CyclicTripPreventionManager {

    // Map to store visited airports for each departure airport
    private Map<String, Set<String>> visitedAirports;

    // Constructor
    public CyclicTripPreventionManager() {
        visitedAirports = new HashMap<>();
    }

    // Method to prevent cyclic trips
    public boolean preventCyclicTrip(String departureAirport, String destinationAirport) {
        // Check if the departure airport exists in the map
        if (!visitedAirports.containsKey(departureAirport)) {
            // If not, add it to the map with an empty set of visited airports
            visitedAirports.put(departureAirport, new HashSet<>());
        }

        // Get the set of visited airports for the departure airport
        Set<String> visited = visitedAirports.get(departureAirport);

        // Check if the destination airport has already been visited from the departure airport
        if (visited.contains(destinationAirport)) {
            // If yes, prevent the trip
            System.out.println("Cyclic trip detected. Trip from " + departureAirport + " to " + destinationAirport + " is not allowed.");
            return false;
        } else {
            // If not, mark the destination airport as visited and allow the trip
            visited.add(destinationAirport);
            System.out.println("Trip from " + departureAirport + " to " + destinationAirport + " allowed.");
            return true;
        }
    }
}


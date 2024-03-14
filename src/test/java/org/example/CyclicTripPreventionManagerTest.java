package org.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CyclicTripPreventionManagerTest {

    @Test
    public void testPreventCyclicTrip_NoCyclicTrip() {
        // Create a new instance of CyclicTripPreventionManager
        CyclicTripPreventionManager manager = new CyclicTripPreventionManager();

        // Call preventCyclicTrip method with different departure and destination airports
        assertTrue(manager.preventCyclicTrip("JFK", "LAX"));
    }

    @Test
    public void testPreventCyclicTrip_CyclicTrip() {
        // Create a new instance of CyclicTripPreventionManager
        CyclicTripPreventionManager manager = new CyclicTripPreventionManager();

        // Set up a cyclic trip scenario
        manager.preventCyclicTrip("JFK", "LAX");

        // Call preventCyclicTrip method with the same departure and destination airports
        assertFalse(manager.preventCyclicTrip("JFK", "LAX"));
    }

    @Test
    public void testPreventCyclicTrip_MultipleDepartures() {
        // Create a new instance of CyclicTripPreventionManager
        CyclicTripPreventionManager manager = new CyclicTripPreventionManager();

        // Set up multiple departure and destination airports
        manager.preventCyclicTrip("JFK", "LAX");
        manager.preventCyclicTrip("LAX", "SFO");
        manager.preventCyclicTrip("SFO", "JFK");

        // Call preventCyclicTrip method with different departure and destination airports
        assertTrue(manager.preventCyclicTrip("JFK", "SFO"));
    }
}


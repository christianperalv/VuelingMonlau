package org.example;

import java.util.Objects;

public class Pilot {
    private String id;
    private String license;

    // Constructor
    public Pilot(String id, String license) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Pilot ID cannot be null or empty.");
        }
        if (license == null || license.isEmpty()) {
            throw new IllegalArgumentException("License cannot be null or empty.");
        }
        this.id = id;
        this.license = license;
    }

    // Method to schedule a flight
    public void scheduleFly(String flightId, String dateTime) {
        if (flightId == null || flightId.isEmpty()) {
            throw new IllegalArgumentException("Flight ID cannot be null or empty.");
        }
        if (dateTime == null || dateTime.isEmpty()) {
            throw new IllegalArgumentException("Date and time cannot be null or empty.");
        }
        System.out.println("Pilot " + id + " has scheduled flight " + flightId + " on " + dateTime);
    }

    // Getters and Setters with validation
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Pilot ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        if (license == null || license.isEmpty()) {
            throw new IllegalArgumentException("License cannot be null or empty.");
        }
        this.license = license;
    }

    // Utility methods
    @Override
    public String toString() {
        return "Pilot{id='" + id + "', license='" + license + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return id.equals(pilot.id) && license.equals(pilot.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license);
    }
}

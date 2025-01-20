package org.example;

public class Steward {
    private String id;
    private String name;

    // Constructor
    public Steward(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to manage reservations
    public void manageReservations() {
        System.out.println(name + " is managing reservations.");
        // Add logic for reservation management here
    }

    // Method to assist passengers
    public void assistPassengers(String passengerName) {
        System.out.println(name + " is assisting passenger: " + passengerName);
    }

    @Override
    public String toString() {
        return "Steward{id='" + id + "', name='" + name + "'}";
    }
}

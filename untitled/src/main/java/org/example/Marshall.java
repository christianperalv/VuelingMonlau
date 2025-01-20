package org.example;

public class Marshall {
    private String id;
    private String name;

    // Constructor
    public Marshall(String id, String name) {
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

    // Method to enforce flight safety
    public void enforceSafety() {
        System.out.println(name + " is ensuring safety protocols are followed.");
    }

    // Method to handle emergencies
    public void handleEmergency(String emergencyDetails) {
        System.out.println(name + " is handling the emergency: " + emergencyDetails);
    }

    @Override
    public String toString() {
        return "Marshall{id='" + id + "', name='" + name + "'}";
    }
}

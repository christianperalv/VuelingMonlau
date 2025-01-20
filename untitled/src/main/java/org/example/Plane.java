package org.example;

public class Plane {
    private String id;
    private String model;
    private int totalSeats;
    private int availableSeats;

    public Plane(String id, String model, int totalSeats, int availableSeats) {
        this.id = id;
        this.model = model;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int calculateTotalSeats() {
        return this.totalSeats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane{");
        sb.append("id='").append(id).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", totalSeats=").append(totalSeats);
        sb.append(", availableSeats=").append(availableSeats);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

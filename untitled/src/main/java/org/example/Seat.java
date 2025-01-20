package org.example;

public class Seat {
    private String id;
    private SeatType seatType;
    private boolean available;
    private double price;

    public Seat(String id, SeatType seatType, boolean available, double price) {
        this.id = id;
        this.seatType = seatType;
        this.available = available;
        this.price = price;
    }

    public void showDetails() {
        System.out.println(id + "\t" + seatType + "\t" + available + "\t" + price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Seat{");
        sb.append("id='").append(id).append('\'');
        sb.append(", seatType=").append(seatType);
        sb.append(", available=").append(available);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

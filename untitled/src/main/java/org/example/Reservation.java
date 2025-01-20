package org.example;

import java.util.Date;
import java.util.List;

public class Reservation {
    private String id;
    private ReservationStatus status;
    private String reservationNumber;
    private Date reservationDate;
    private Date flightDate;
    private String flightId;
    private List<Seat> reservedSeat;
    private String clientId;
    private double totalPrice;

    public Reservation(String id, ReservationStatus status, String reservationNumber, Date reservationDate, Date flightDate, String flightId, List<Seat> reservedSeat, String clientId, double totalPrice) {
        this.id = id;
        this.status = status;
        this.reservationNumber = reservationNumber;
        this.reservationDate = reservationDate;
        this.flightDate = flightDate;
        this.flightId = flightId;
        this.reservedSeat = reservedSeat;
        this.clientId = clientId;
        this.totalPrice = totalPrice;
    }

    // Only accept non cancelled
    public void changeStatus(ReservationStatus newStatus) {
        if (newStatus != ReservationStatus.CANCELLED) {
            this.status = newStatus;
        }
    }

    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Reservation Details:\n");
        details.append("ID: ").append(id).append("\n");
        details.append("Status: ").append(status).append("\n");
        details.append("Reservation Number: ").append(reservationNumber).append("\n");
        details.append("Reservation Date: ").append(reservationDate).append("\n");
        details.append("Flight Date: ").append(flightDate).append("\n");
        details.append("Flight ID: ").append(flightId).append("\n");
        details.append("Reserved Seats: ");

        if (reservedSeat != null && !reservedSeat.isEmpty()) {
            for (Seat seat : reservedSeat) {
                details.append(seat.toString()).append(", ");
            }
            // Remove trailing comma and space
            details.setLength(details.length() - 2);
        } else {
            details.append("No seats reserved");
        }

        details.append("\nClient ID: ").append(clientId).append("\n");
        details.append("Total Price: $").append(String.format("%.2f", totalPrice)).append("\n");
        return details.toString();
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        for (Seat seat : reservedSeat) {
            totalPrice += seat.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservations{");
        sb.append("id='").append(id).append('\'');
        sb.append(", status=").append(status);
        sb.append(", reservationNumber='").append(reservationNumber).append('\'');
        sb.append(", reservationDate=").append(reservationDate);
        sb.append(", flightDate=").append(flightDate);
        sb.append(", flightId='").append(flightId).append('\'');
        sb.append(", reservedSeat=").append(reservedSeat);
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public List<Seat> getReservedSeat() {
        return reservedSeat;
    }

    public void setReservedSeat(List<Seat> reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

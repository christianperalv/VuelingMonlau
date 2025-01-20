package org.example;

import org.example.Customer;
import org.example.Flight;

import java.util.Date;
import java.util.List;

public class Ticket {
    private String ticketId; // ID único del ticket
    private Customer customer; // Cliente que reservó el vuelo
    private Flight flight; // Vuelo reservado
    private Seat reservedSeat; // Asientos reservados
    private double totalCost; // Costo total de la reserva
    private Date reservationDate; // Fecha de la reserva

    // Constructor
    public Ticket(String ticketId, Customer customer, Flight flight, Seat reservedSeats) {
        this.ticketId = ticketId;
        this.customer = customer;
        this.flight = flight;
        this.reservedSeat = reservedSeats;
        this.totalCost = calculateTotalCost(); // Calcula el costo total
        this.reservationDate = new Date(); // Fecha actual como fecha de reserva
    }

    public String showDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Detalles del Ticket ===").append("\n");
        sb.append("Ticket ID: ").append(ticketId).append("\n");
        sb.append("Cliente: ").append(customer.getName()).append(" ").append(customer.getSurname()).append("\n");
        sb.append("Correo Electrónico: ").append(customer.getEmail()).append("\n\n");

        sb.append("Información del Vuelo:").append("\n");
        sb.append("Vuelo ID: ").append(flight.getId()).append("\n");
        sb.append("Compañía: ").append(flight.getCompany()).append("\n");
        sb.append("Origen: ").append(flight.getOrigin()).append("\n");
        sb.append("Destino: ").append(flight.getDestination()).append("\n");
        sb.append("Fecha de Salida: ").append(flight.getDeparture()).append("\n");
        sb.append("Fecha de Llegada: ").append(flight.getArrival()).append("\n\n");

        sb.append("Asiento Reservado:").append("\n");
        sb.append("Asiento ID: ").append(reservedSeat.getId()).append("\n");
        sb.append("Tipo de Asiento: ").append(reservedSeat.getSeatType()).append("\n");
        sb.append("Precio del Asiento: ").append(reservedSeat.getPrice()).append("\n\n");

        sb.append("Costo Total del Ticket: ").append(totalCost).append("\n");
        sb.append("Fecha de la Reserva: ").append(reservationDate).append("\n");

        return sb.toString();
    }


    // Método para calcular el costo total
    private double calculateTotalCost() {
        return this.reservedSeat.getPrice() + this.flight.getPrice();
    }

    // Métodos Getters
    public String getTicketId() {
        return ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getReservedSeat() {
        return reservedSeat;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", customer=" + customer.getName() +
                ", flight=" + flight.getId() +
                ", reservedSeats=" + reservedSeat +
                ", totalCost=" + totalCost +
                ", reservationDate=" + reservationDate +
                '}';
    }
}

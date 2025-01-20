package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    private String id;
    private Company company;
    private Location origin;
    private Location destination;
    private Date departure;
    private Date arrival;
    private double price;
    private double luggageCost;
    private String boardingGate;
    private FlightStatus flightStatus;
    private List<Seat> seats;
    private int totalSeats;

    public Flight(String id, Company company, Location origin, Location destination, Date departure, Date arrival, double price, double luggageCost, String boardingGate, FlightStatus flightStatus, int totalSeats) {
        this.id = id;
        this.company = company;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.luggageCost = luggageCost;
        this.boardingGate = boardingGate;
        this.flightStatus = flightStatus;
        this.totalSeats = totalSeats;
        this.seats = new ArrayList<>();
    }

    public void initializeSeats() {
        // Calcular cantidad de asientos por clase
        int economySeats = totalSeats / 2; // 50% Economy
        int businessSeats = totalSeats / 4; // 25% Business
        int firstClassSeats = totalSeats - (economySeats + businessSeats);

        // Crear asientos Economy
        for (int i = 1; i <= economySeats; i++) {
            seats.add(new Seat("E" + i, SeatType.ECONOMY, true, price));
        }

        // Crear asientos Business
        for (int i = 1; i <= businessSeats; i++) {
            seats.add(new Seat("B" + i, SeatType.BUSINESS, true, price * 1.5));
        }

        // Crear asientos First Class
        for (int i = 1; i <= firstClassSeats; i++) {
            seats.add(new Seat("F" + i, SeatType.FIRST_CLASS, true, price * 2.0));
        }
    }

    public Seat reserveSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getId().equals(seatId) && seat.isAvailable()) {
                seat.setAvailable(false);
                return seat;
            }
        }
        return null;
    }

    public String showDetails() {
        return "Vuelo " + id + " - " + company +
                "\nOrigen: " + origin +
                "\nDestino: " + destination +
                "\nSalida: " + departure +
                "\nLlegada: " + arrival +
                "\nPrecio base (Economy): " + price +
                "\nEstado: " + flightStatus +
                "\nPuerta de embarque: " + boardingGate;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public double getPrice() {
        return price;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

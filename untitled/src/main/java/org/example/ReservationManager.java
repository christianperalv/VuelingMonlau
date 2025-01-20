package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationManager {
    private List<Flight> flights;

    public ReservationManager() {
        this.flights = new ArrayList<>();
        initializeFlights();
    }

    private void initializeFlights() {
        // Crear vuelos de ejemplo
        flights.add(new Flight(
                "FL001",
                Company.IBERIA,
                Location.MDR,
                Location.BCN,
                new Date(),
                new Date(System.currentTimeMillis() + 3600000),
                120.0,
                30.0,
                "A1",
                FlightStatus.PROGRAMMED,
                100
        ));
        flights.get(0).initializeSeats();

        flights.add(new Flight(
                "FL002",
                Company.RYANAIR,
                Location.SVQ,
                Location.LON,
                new Date(),
                new Date(System.currentTimeMillis() + 7200000),
                80.0,
                20.0,
                "B2",
                FlightStatus.PROGRAMMED,
                80
        ));
        flights.get(1).initializeSeats();
    }

    public void showAvailableFlights() {
        if (flights.isEmpty()) {
            System.out.println("No hay vuelos disponibles.");
            return;
        }

        for (Flight flight : flights) {
            System.out.println(flight.showDetails());
            System.out.println(); // Separador entre vuelos
        }
    }

    public Flight getFlightById(String flightId) {
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)) {
                return flight;
            }
        }
        return null; // No se encontró el vuelo
    }


    public Reservation reserveFlight(Customer customer, String flightId, String seatId) {
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)) {
                // Intentar reservar el asiento en el vuelo
                Seat reservedSeat = flight.reserveSeat(seatId);
                if (reservedSeat != null) {
                    // Generar un número único para la reserva
                    String reservationId = "RES" + (customer.getReservations().size() + 1);
                    String reservationNumber = "R" + System.currentTimeMillis();

                    // Crear la reserva
                    Reservation reservation = new Reservation(
                            reservationId,
                            ReservationStatus.COMPLETED,
                            reservationNumber,
                            new Date(), // Fecha de reserva (actual)
                            flight.getDeparture(), // Fecha del vuelo
                            flightId,
                            List.of(reservedSeat), // Asiento reservado
                            customer.getId(),
                            reservedSeat.getPrice() + flight.getPrice() // Precio total
                    );

                    // Agregar la reserva al cliente
                    customer.addReservation(reservation);

                    System.out.println("Reserva realizada con éxito.");
                    return reservation;
                } else {
                    System.out.println("El asiento no está disponible o no existe.");
                }
            }
        }
        System.out.println("No se encontró un vuelo con el ID proporcionado.");
        return null; // Fallo en la reserva
    }

}

package org.example;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    // Lista de reservas asociadas al cliente
    private List<Reservation> reservations;

    // Constructor
    public Customer(String id, String name, String surname, String secondSurname, String email, String phone, String password) {
        super(id, name, surname, secondSurname, email, phone, password);
        this.reservations = new ArrayList<>();
    }

    // Métodos específicos para Customer

    public Customer signIn(String email, String password) {
        if (this.getEmail().equals(email) && this.getPassword().equals(password)) {
            return this; // Devuelve el objeto Customer
        }
        return null;
    }

    /**
     * Devuelve el rol del usuario.
     * Este método sobrescribe el método abstracto de la clase User.
     */
    @Override
    public String getRole() {
        return "Cliente";
    }

    /**
     * Devuelve la lista de reservas del cliente.
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Añade una reserva a la lista de reservas del cliente.
     *
     * @param reservation La reserva a añadir.
     * @throws IllegalArgumentException Si la reserva es nula.
     */
    public void addReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }

        // Verificar si ya existe una reserva con el mismo ID
        for (Reservation existingReservation : this.reservations) {
            if (existingReservation.getId().equals(reservation.getId())) {
                System.out.println("Ya existe una reserva con este ID.");
                return;
            }
        }

        // Agregar la reserva si pasa las validaciones
        this.reservations.add(reservation);
        System.out.println("Reserva añadida con éxito.");
    }

}

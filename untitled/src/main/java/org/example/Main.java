package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager(); // Manejo de usuarios
    private static ReservationManager reservationManager = new ReservationManager(); // Manejo de reservas y vuelos
    private static Customer currentUser = null;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            if (currentUser == null) {
                showWelcomeMenu();
            } else {
                showMainMenu();
            }
        }

        System.out.println("Gracias por usar el sistema de reservas. ¡Adiós!");
    }

    private static void showWelcomeMenu() {
        System.out.println("\n=== Bienvenido al Sistema de Reservas ===");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Crear Usuario");
        System.out.println("3. Salir");

        int option = getOption();

        switch (option) {
            case 1:
                login();
                break;
            case 2:
                createUser();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Ver mis Reservas");
        System.out.println("2. Ver Vuelos Disponibles");
        System.out.println("3. Hacer una Reserva");
        System.out.println("4. Cerrar Sesión");

        int option = getOption();

        switch (option) {
            case 1:
                viewReservations();
                break;
            case 2:
                viewAvailableFlights();
                break;
            case 3:
                makeReservation();
                break;
            case 4:
                currentUser = null;
                System.out.println("Sesión cerrada.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static int getOption() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    private static void login() {
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Correo: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        currentUser = userManager.signIn(email, password);
        if (currentUser == null) {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
        } else {
            System.out.println("Inicio de sesión exitoso. Bienvenido " + currentUser.getName() + "!");
        }
    }

    private static void createUser() {
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellido: ");
        String surname = scanner.nextLine();
        System.out.print("Correo: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        currentUser = userManager.createUser(name, surname, email, phone, password);
        System.out.println("Usuario creado exitosamente. ¡Bienvenido " + currentUser.getName() + "!");
    }

    private static void viewReservations() {
        System.out.println("\n=== Mis Reservas ===");
        if (currentUser.getReservations().isEmpty()) {
            System.out.println("No tienes reservas.");
        } else {
            currentUser.getReservations().forEach(reservation -> System.out.println(reservation.showDetails()));
        }
    }

    private static void viewAvailableFlights() {
        System.out.println("\n=== Vuelos Disponibles ===");
        reservationManager.showAvailableFlights();
    }

    private static void makeReservation() {
        System.out.println("\n=== Realizar una Reserva ===");

        // Mostrar vuelos disponibles
        System.out.println("Vuelos disponibles:");
        reservationManager.showAvailableFlights();

        // Solicitar al usuario el ID del vuelo
        System.out.print("\nIngrese el ID del vuelo que desea reservar: ");
        String flightId = scanner.next();

        // Buscar el vuelo seleccionado
        Flight selectedFlight = reservationManager.getFlightById(flightId);
        if (selectedFlight == null) {
            System.out.println("El vuelo no existe. Por favor, intente nuevamente.");
            return;
        }

        // Mostrar los asientos disponibles en formato de avión
        System.out.println("\n=== Asientos Disponibles ===");
        showSeatsInPlaneFormat(selectedFlight);

        // Solicitar al usuario el ID del asiento
        System.out.print("\nIngrese el ID del asiento que desea reservar: ");
        String seatId = scanner.next();

        // Intentar realizar la reserva
        Reservation reservation = reservationManager.reserveFlight(currentUser, flightId, seatId);
        if (reservation != null) {
            System.out.println("Reserva realizada con éxito. Detalles:");
            System.out.println("ID de la Reserva: " + reservation.getId());
            System.out.println("Número de Reserva: " + reservation.getReservationNumber());
            System.out.println("Fecha de Reserva: " + reservation.getReservationDate());
            System.out.println("Fecha del Vuelo: " + reservation.getFlightDate());
            System.out.println("Vuelo ID: " + reservation.getFlightId());
            System.out.println("Asientos Reservados: ");
            reservation.getReservedSeat().forEach(seat -> System.out.println(" - " + seat.getId()));
            System.out.println("Precio Total: " + reservation.getTotalPrice());
        } else {
            System.out.println("No se pudo completar la reserva. Verifique los datos.");
        }
    }

    private static void showSeatsInPlaneFormat(Flight flight) {
        int columns = 4; // Número de columnas por fila
        int count = 0;

        for (Seat seat : flight.getSeats()) {
            if (seat.isAvailable()) {
                System.out.printf("%-8s", seat.getId()); // Mostrar el ID del asiento
            } else {
                System.out.printf("%-8s", "X"); // Mostrar "X" para los asientos ocupados
            }

            count++;
            if (count % columns == 0) {
                System.out.println(); // Saltar a la siguiente fila
            }
        }

        // Si hay asientos disponibles pero la última fila no se completó
        if (count % columns != 0) {
            System.out.println();
        }
    }



}

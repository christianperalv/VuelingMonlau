package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<Customer> customers;

    public UserManager() {
        this.customers = new ArrayList<>();
        initializeDefaultUsers(); // Agregar usuarios por defecto
    }

    // Crear usuarios por defecto
    private void initializeDefaultUsers() {
        createUser("Juan", "Pérez", "juan.perez@example.com", "123456789", "password123");
        createUser("María", "López", "maria.lopez@example.com", "987654321", "securepassword");
        createUser("Carlos", "García", "carlos.garcia@example.com", "555123456", "mypassword");
    }

    public Customer createUser(String name, String surname, String email, String phone, String password) {
        // Generar un ID único para el usuario (simple ejemplo, usa una mejor estrategia si es necesario)
        String id = "CUST" + (customers.size() + 1);
        Customer newCustomer = new Customer(id, name, surname, "", email, phone, password);
        customers.add(newCustomer);
        return newCustomer;
    }

    public Customer signIn(String email, String password) {
        initializeDefaultUsers();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer; // Usuario encontrado
            }
        }
        return null; // Credenciales incorrectas
    }
}

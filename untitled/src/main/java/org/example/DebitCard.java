package org.example;

public class DebitCard implements PaymentMethods {
    private String id;
    private String number;
    private String clientId;

    // Constructor
    public DebitCard(String id, String number, String clientId) {
        this.id = id;
        this.number = number;
        this.clientId = clientId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    // Implement PaymentMethods

    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " using debit card: " + getMaskedNumber());
    }


    public boolean validatePaymentDetails() {
        return number != null && number.matches("\\d{16}");
    }

    // Masked card number for security
    public String getMaskedNumber() {
        if (number != null && number.length() >= 4) {
            return "**** **** **** " + number.substring(number.length() - 4);
        }
        return "Invalid Number";
    }

    @Override
    public String toString() {
        return "DebitCard{id='" + id + "', clientId='" + clientId + "'}";
    }
}

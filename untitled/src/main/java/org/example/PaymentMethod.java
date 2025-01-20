package org.example;

import java.util.Date;

public class PaymentMethod {
    private String id;
    private String type;
    private double quantity;
    private Date date;

    public PaymentMethod(String id, String type, double quantity, Date date) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public String showDetails() {
        return "";
    }

    public void processPayment() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

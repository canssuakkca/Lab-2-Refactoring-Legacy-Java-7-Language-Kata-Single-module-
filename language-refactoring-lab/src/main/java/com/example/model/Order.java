package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private PaymentMethod payment;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "NEW";

    public Order() {}

    public Order(String id, Customer customer, PaymentMethod payment, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.payment = payment;
        this.items = items != null ? List.copyOf(items) : new ArrayList<>();
        this.status = "NEW";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public PaymentMethod getPayment() { return payment; }
    public void setPayment(PaymentMethod payment) { this.payment = payment; }

    public List<OrderItem> getItems() { return List.copyOf(items); }
    public void setItems(List<OrderItem> items) { this.items = List.copyOf(items); }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


    public long totalCents() {
        return items.stream()
                .mapToLong(OrderItem::lineTotalCents)
                .sum();
    }
}
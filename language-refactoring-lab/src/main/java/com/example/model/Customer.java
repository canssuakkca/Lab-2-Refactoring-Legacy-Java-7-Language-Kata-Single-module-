package com.example.model;

public class Customer {

    private final String id;
    private final String name;
    private final String tier;

    public Customer(String id, String name, String tier) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Customer id cannot be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        if (tier == null || tier.isBlank()) {
            throw new IllegalArgumentException("Customer tier cannot be blank");
        }
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, name=%s, tier=%s]", id, name, tier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer c = (Customer) o;
        return id.equals(c.id) && name.equals(c.name) && tier.equals(c.tier);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + tier.hashCode();
        return result;
    }
}
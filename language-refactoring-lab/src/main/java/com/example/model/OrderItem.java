package com.example.model;

public class OrderItem {

    private final String sku;
    private final int quantity;
    private final long unitPriceCents;

    public OrderItem(String sku, int quantity, long unitPriceCents) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (unitPriceCents < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        this.sku = sku;
        this.quantity = quantity;
        this.unitPriceCents = unitPriceCents;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getUnitPriceCents() {
        return unitPriceCents;
    }

    public long lineTotalCents() {
        return unitPriceCents * quantity;
    }

    @Override
    public String toString() {
        return String.format("OrderItem[sku=%s, quantity=%d, unitPriceCents=%d]",
                sku, quantity, unitPriceCents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return quantity == that.quantity &&
                unitPriceCents == that.unitPriceCents &&
                sku.equals(that.sku);
    }

    @Override
    public int hashCode() {
        int result = sku.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + Long.hashCode(unitPriceCents);
        return result;
    }
    
}
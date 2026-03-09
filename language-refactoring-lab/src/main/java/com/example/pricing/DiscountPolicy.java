package com.example.pricing;
import com.example.model.Order;

@FunctionalInterface
public interface DiscountPolicy {
    long discountCents(Order order);
    default String name() { return "DISCOUNT"; }
}
package com.example.pricing;

import java.util.ArrayList;
import java.util.List;
import com.example.model.Order;

public class DiscountEngine {

    private final List<DiscountPolicy> policies = new ArrayList<>();

    public DiscountEngine() {
        policies.add(order -> {
            if (order != null && order.getCustomer() != null
                    && "GOLD".equalsIgnoreCase(order.getCustomer().getTier())) {
                return (long)(order.totalCents() * 0.10);
            }
            return 0L;
        });
    }

    public long totalDiscountCents(Order order) {
        return policies.stream()
                .mapToLong(p -> p.discountCents(order))
                .sum();
    }
}
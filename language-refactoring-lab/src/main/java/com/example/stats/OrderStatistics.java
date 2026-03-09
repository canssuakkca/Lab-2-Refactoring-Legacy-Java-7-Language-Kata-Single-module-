package com.example.stats;

import java.util.List;
import java.util.Map;
import com.example.model.Order;
import com.example.pricing.DiscountEngine;

public class OrderStatistics {

    public Map<String, Object> compute(List<Order> orders) {
        DiscountEngine engine = new DiscountEngine();

        long totalRevenue = orders.stream()
                .filter(o -> o != null)
                .mapToLong(o -> o.totalCents() - engine.totalDiscountCents(o))
                .sum();

        int count = (int) orders.stream().filter(o -> o != null).count();

        return Map.of(
                "count", count,
                "totalRevenue", totalRevenue
        );
    }
}
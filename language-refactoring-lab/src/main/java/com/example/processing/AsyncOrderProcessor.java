package com.example.processing;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import com.example.model.Order;
import com.example.pricing.DiscountEngine;

public class AsyncOrderProcessor {

    private final ExecutorService pool = Executors.newFixedThreadPool(2);

    public List<Order> process(List<Order> orders) {
        try {
            List<Future<Order>> futures = orders.stream()
                    .map(order -> pool.submit(() -> {
                        DiscountEngine engine = new DiscountEngine();
                        long disc = engine.totalDiscountCents(order);
                        if (disc > 0) order.setStatus(order.getStatus() + "_DISC");
                        return order;
                    }))
                    .collect(Collectors.toList());

            return futures.stream()
                    .map(f -> {
                        try {
                            return f.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        } finally {
            pool.shutdown();
        }
    }
}
package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.*;

public class CsvIO {

    public List<Order> readOrders(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines()
                    .skip(1)
                    .filter(line -> line != null && !line.trim().isEmpty())
                    .map(this::parseOrder)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file, e);
        }
    }

    private Order parseOrder(String line) {
        String[] p = line.split(",");
        if (p.length < 9) throw new IllegalArgumentException("Invalid row: " + line);

        Customer customer = new Customer(p[1].trim(), p[2].trim(), p[3].trim());
        PaymentMethod payment = new PaymentParser().parse(p[4].trim());
        OrderItem item = new OrderItem(p[5].trim(),
                Integer.parseInt(p[6].trim()),
                Long.parseLong(p[7].trim()));
        Order order = new Order(p[0].trim(), customer, payment, List.of(item));

        order.setStatus(p[8].trim());
        return order;
    }
}
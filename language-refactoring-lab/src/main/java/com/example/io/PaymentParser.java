package com.example.io;

import com.example.model.*;

public class PaymentParser {

    public PaymentMethod parse(String raw) {
        if (raw == null || raw.isBlank()) return new CashPayment();

        String s = raw.trim();

        return switch (s) {
            case String str when str.startsWith("CARD:") -> new CardPayment(str.substring(5));
            case String str when str.startsWith("WIRE:") -> new WirePayment(str.substring(5));
            default -> new CashPayment();
        };
    }
}
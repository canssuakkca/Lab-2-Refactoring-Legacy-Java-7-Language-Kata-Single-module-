package com.example.model;

public class CardPayment extends PaymentMethod {

    private final String panLast4;

    public CardPayment(String panLast4) {
        super(PaymentMethodType.CARD);
        if (panLast4 == null || panLast4.length() != 4) {
            throw new IllegalArgumentException("panLast4 must be 4 digits");
        }
        this.panLast4 = panLast4;
    }

    public String getPanLast4() {
        return panLast4;
    }

    @Override
    public String masked() {
        return "CARD(****" + panLast4 + ")";
    }
}
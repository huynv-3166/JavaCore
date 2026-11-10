package com.example.practice2;

import java.time.LocalDate;

public abstract class Goods {

    private final String code;
    private final String name;
    private final int quantity;
    private final double unitPrice;

    protected Goods(String code, String name, int quantity, double unitPrice) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Product code must not be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be blank");
        }
        if (quantity < 0 || unitPrice < 0) {
            throw new IllegalArgumentException("Quantity and unit price must not be negative");
        }

        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public abstract double getVatPerUnit();

    public abstract String evaluateSales(LocalDate today);
}

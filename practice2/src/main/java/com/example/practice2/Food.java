package com.example.practice2;

import java.time.LocalDate;
import java.util.Objects;

public class Food extends Goods {
    private final LocalDate manufactureDate;
    private final LocalDate expirationDate;
    private final String supplier;

    private static final double VAT_RATE = 0.05;

    public Food(String code, String name, int quantity, double unitPrice,
                LocalDate manufactureDate, LocalDate expirationDate,
                String supplier) {
        super(code, name, quantity, unitPrice);

        this.manufactureDate = Objects.requireNonNull(manufactureDate);
        this.expirationDate = Objects.requireNonNull(expirationDate);
        if (!expirationDate.isAfter(manufactureDate)) {
            throw new IllegalArgumentException(
                    "Expiration date must be after manufacture date");
        }
        this.supplier = supplier;
    }

    @Override
    public double getVatPerUnit() {
        return getUnitPrice() * VAT_RATE;
    }

    @Override
    public String evaluateSales(LocalDate today) {
        if (getQuantity() > 0 && today.isAfter(expirationDate)) {
            return "HARD_TO_SELL";
        }
        return "NOT_EVALUATED";
    }
}
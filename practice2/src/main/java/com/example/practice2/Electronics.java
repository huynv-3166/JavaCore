package com.example.practice2;

import java.time.LocalDate;

public class Electronics extends Goods {
    private static final double VAT_RATE = 0.10;

    private final int warrantyMonths;
    private final double powerKw;

    public Electronics(String code, String name, int quantity, double unitPrice,
                       int warrantyMonths, double powerKw) {
        super(code, name, quantity, unitPrice);

        if (warrantyMonths < 0 || powerKw < 0) {
            throw new IllegalArgumentException(
                    "Warranty months and power must not be negative");
        }

        this.warrantyMonths = warrantyMonths;
        this.powerKw = powerKw;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public double getPowerKw() {
        return powerKw;
    }

    @Override
    public double getVatPerUnit() {
        return getUnitPrice() * VAT_RATE;
    }

    @Override
    public String evaluateSales(LocalDate today) {
        if (getQuantity() < 3) {
            return "SELLING_WELL";
        }
        return "NOT_EVALUATED";
    }
}
package com.example.practice2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Crockery extends Goods {
    private static final double VAT_RATE = 0.10;

    private final String manufacturer;
    private final LocalDate arrivalDate;

    public Crockery(String code, String name, int quantity, double unitPrice,
                    String manufacturer, LocalDate arrivalDate) {
        super(code, name, quantity, unitPrice);
        this.manufacturer = manufacturer;
        this.arrivalDate = Objects.requireNonNull(arrivalDate);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public double getVatPerUnit() {
        return getUnitPrice() * VAT_RATE;
    }

    @Override
    public String evaluateSales(LocalDate today) {
        long storageDays = ChronoUnit.DAYS.between(arrivalDate, today);

        if (getQuantity() > 50 && storageDays > 10) {
            return "SLOW_SELLING";
        }
        return "NOT_EVALUATED";
    }
}
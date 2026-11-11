package com.example.practice3;

public class Truck extends Vehicle {

    private final double tonnage;

    public Truck(String vehicleNumber, String manufacturer,
            int manufactureYear, String color, Owner owner,
            double tonnage) {
        super(vehicleNumber, manufacturer, manufactureYear, color, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }
}

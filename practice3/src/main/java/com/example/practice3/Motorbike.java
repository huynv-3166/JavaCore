package com.example.practice3;

public class Motorbike extends Vehicle {

    private final double capacity;

    public Motorbike(String vehicleNumber, String manufacturer,
            int manufactureYear, String color, Owner owner,
            double capacity) {
        super(vehicleNumber, manufacturer, manufactureYear, color, owner);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
}

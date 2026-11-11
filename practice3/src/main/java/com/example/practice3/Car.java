package com.example.practice3;

public class Car extends Vehicle {

    private final int seatCount;
    private final String engineType;

    public Car(String vehicleNumber, String manufacturer,
            int manufactureYear, String color, Owner owner,
            int seatCount, String engineType) {
        super(vehicleNumber, manufacturer, manufactureYear, color, owner);

        if (engineType == null || engineType.isBlank()) {
            throw new IllegalArgumentException("Engine type must not be blank");
        }

        this.seatCount = seatCount;
        this.engineType = engineType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String getEngineType() {
        return engineType;
    }
}

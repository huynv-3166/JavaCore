package com.example.practice3;

import java.time.Year;
import java.util.Objects;
import java.util.Set;

public abstract class Vehicle {

    private static final int VEHICLE_NUMBER_LENGTH = 5;
    private static final int MIN_MANUFACTURE_YEAR_EXCLUSIVE = 2000;

    private static final Set<String> MANUFACTURERS
            = Set.of("Honda", "Yamaha", "Toyota", "Suzuki");

    private final String vehicleNumber;
    private final String manufacturer;
    private final int manufactureYear;
    private final String color;
    private final Owner owner;

    protected Vehicle(String vehicleNumber, String manufacturer,
            int manufactureYear, String color, Owner owner) {
        if (vehicleNumber == null
                || vehicleNumber.length() != VEHICLE_NUMBER_LENGTH) {
            throw new IllegalArgumentException(
                    "Vehicle number must have exactly "
                    + VEHICLE_NUMBER_LENGTH + " characters");
        }
        if (!MANUFACTURERS.contains(manufacturer)) {
            throw new IllegalArgumentException("Invalid manufacturer");
        }
        if (manufactureYear <= MIN_MANUFACTURE_YEAR_EXCLUSIVE
                || manufactureYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Invalid manufacture year");
        }
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color must not be blank");
        }

        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.manufactureYear = manufactureYear;
        this.color = color;
        this.owner = Objects.requireNonNull(owner);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public Owner getOwner() {
        return owner;
    }
}

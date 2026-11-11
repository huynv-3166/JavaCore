package com.example.practice3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VehicleRegistry {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public boolean addVehicle(Vehicle vehicle) {
        Objects.requireNonNull(vehicle);

        if (findByVehicleNumber(vehicle.getVehicleNumber()) != null) {
            return false;
        }

        Owner newOwner = vehicle.getOwner();
        for (Vehicle existingVehicle : vehicles) {
            Owner existingOwner = existingVehicle.getOwner();
            if (existingOwner.getIdentityNumber().equals(newOwner.getIdentityNumber())
                    && (!existingOwner.getFullName().equals(newOwner.getFullName())
                    || !existingOwner.getEmail().equals(newOwner.getEmail()))) {
                throw new IllegalArgumentException(
                        "Identity number already belongs to another owner");
            }
        }

        vehicles.add(vehicle);
        return true;
    }

    public Vehicle findByVehicleNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> findByOwnerIdentityNumber(String identityNumber) {
        List<Vehicle> matches = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getIdentityNumber().equals(identityNumber)) {
                matches.add(vehicle);
            }
        }

        return matches;
    }

    public int removeAllByManufacturer(String manufacturer) {
        int countBefore = vehicles.size();

        vehicles.removeIf(vehicle
                -> vehicle.getManufacturer().equals(manufacturer));

        return countBefore - vehicles.size();
    }

    public String getManufacturerWithMostVehicles() {
        Map<String, Integer> counts = countVehiclesByManufacturer();

        String result = null;
        int highestCount = 0;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public List<String> getManufacturersSortedByVehicleCountDescending() {
        Map<String, Integer> counts = countVehiclesByManufacturer();
        List<String> manufacturers = new ArrayList<>(counts.keySet());
        manufacturers.sort((first, second)
                -> Integer.compare(counts.get(second), counts.get(first)));

        return manufacturers;
    }

    private Map<String, Integer> countVehiclesByManufacturer() {
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (Vehicle vehicle : vehicles) {
            String manufacturer = vehicle.getManufacturer();
            counts.put(manufacturer,
                    counts.getOrDefault(manufacturer, 0) + 1);
        }

        return counts;
    }

    public int countByType(Class<? extends Vehicle> type) {
        Objects.requireNonNull(type);

        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (type.isInstance(vehicle)) {
                count++;
            }
        }
        return count;
    }
}

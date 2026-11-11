package com.example.practice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice3Application.class, args);

        Owner an = new Owner("012345678901", "An Nguyen", "an@example.com");
        Owner binh = new Owner("123456789012", "Binh Tran", "binh@example.com");

        VehicleRegistry registry = new VehicleRegistry();

        Vehicle car = new Car("C0001", "Toyota", 2020, "White", an, 5, "Gasoline");
        Vehicle motorbike = new Motorbike("M0002", "Honda", 2022, "Red", an, 150);
        Vehicle truck = new Truck("T0003", "Honda", 2021, "Blue", binh, 3.5);
        Vehicle anotherMotorbike
                = new Motorbike("M0004", "Suzuki", 2023, "Black", binh, 125);

        System.out.println("Add car: " + registry.addVehicle(car));
        System.out.println("Add motorbike: " + registry.addVehicle(motorbike));
        System.out.println("Add truck: " + registry.addVehicle(truck));
        System.out.println("Add another motorbike: "
                + registry.addVehicle(anotherMotorbike));
        System.out.println("Add duplicate number: " + registry.addVehicle(car));

        Vehicle found = registry.findByVehicleNumber("C0001");
        System.out.println("Found C0001: "
                + (found == null ? "none" : found.getManufacturer()));

        System.out.println("Vehicles of An: "
                + registry.findByOwnerIdentityNumber("012345678901").size());

        System.out.println("Manufacturer with most vehicles: "
                + registry.getManufacturerWithMostVehicles());
        System.out.println("Manufacturers by vehicle count: "
                + registry.getManufacturersSortedByVehicleCountDescending());

        System.out.println("Cars: " + registry.countByType(Car.class));
        System.out.println("Motorbikes: " + registry.countByType(Motorbike.class));
        System.out.println("Trucks: " + registry.countByType(Truck.class));

        System.out.println("Removed Honda vehicles: "
                + registry.removeAllByManufacturer("Honda"));
    }

}

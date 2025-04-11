package com.github.curriculeon;

import com.github.curriculeon.parkinglot.*;

import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        // Create parking cells with different sizes
        List<ParkingSpot> row1Cells = Arrays.asList(
                new ParkingSpot(CarSize.SMALL),
                new ParkingSpot(CarSize.MEDIUM),
                new ParkingSpot(CarSize.LARGE)
        );

        List<ParkingSpot> row2Cells = Arrays.asList(
                new ParkingSpot(CarSize.MEDIUM),
                new ParkingSpot(CarSize.LARGE),
                new ParkingSpot(CarSize.SMALL)
        );

        // Create parking rows
        List<ParkingRow> rows = Arrays.asList(
                new ParkingRow(row1Cells),
                new ParkingRow(row2Cells)
        );

        // Create parking parkingLot
        ParkingLot parkingLot = new ParkingLot(rows);

        // Create some cars
        Car smallCar = new Car(CarSize.SMALL);
        Car largeCar = new Car(CarSize.LARGE);

        // Print initial status
        System.out.println("Initial parking status:");
        System.out.println(parkingLot.getStatus());

        // Park a small car
        System.out.println("Parking a small car...");
        parkingLot.park(smallCar);
        System.out.println(parkingLot.getStatus());

        // Park a large car
        System.out.println("Parking a large car...");
        parkingLot.park(largeCar);
        System.out.println(parkingLot.getStatus());
    }
}

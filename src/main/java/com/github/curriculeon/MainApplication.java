package com.github.curriculeon;

import com.github.curriculeon.parkinglot.*;

import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        // Create parking cells with different sizes
        List<ParkingCell> row1Cells = Arrays.asList(
                new ParkingCell(Size.SMALL),
                new ParkingCell(Size.MEDIUM),
                new ParkingCell(Size.LARGE)
        );

        List<ParkingCell> row2Cells = Arrays.asList(
                new ParkingCell(Size.MEDIUM),
                new ParkingCell(Size.LARGE),
                new ParkingCell(Size.SMALL)
        );

        // Create parking rows
        List<ParkingRow> rows = Arrays.asList(
                new ParkingRow(row1Cells),
                new ParkingRow(row2Cells)
        );

        // Create parking matrix
        ParkingMatrix parkingMatrix = new ParkingMatrix(rows);

        // Create some cars
        Car smallCar = new Car(Size.SMALL);
        Car largeCar = new Car(Size.LARGE);

        // Print initial status
        System.out.println("Initial parking status:");
        System.out.println(parkingMatrix.getStatus());

        // Park a small car
        System.out.println("Parking a small car...");
        parkingMatrix.parkCar(smallCar);
        System.out.println(parkingMatrix.getStatus());

        // Park a large car
        System.out.println("Parking a large car...");
        parkingMatrix.parkCar(largeCar);
        System.out.println(parkingMatrix.getStatus());
    }
}

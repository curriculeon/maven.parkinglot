package com.github.curriculeon.parkinglot.matrix;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingLot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrintStatusTest {
    
    @Test
    public void testPrintEMPTYMatrix() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("EMPTY matrix should show all spots as EMPTY", 
            "Row 0: [EMPTY][EMPTY][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintPartiallyOccupiedMatrix() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Matrix should show occupied and EMPTY spots correctly", 
            "Row 0: [MEDIUM][MEDIUM][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintFullMatrix() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        final Car car3 = new Car(CarSize.LARGE);
        final Car car4 = new Car(CarSize.SMALL);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        matrix.parkCar(car4);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Full matrix should show all spots as occupied", 
            "Row 0: [MEDIUM][MEDIUM]\nRow 1: [MEDIUM][EMPTY]",
            status);
    }

    @Test
    public void testPrintMatrixWithDifferentSizes() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.LARGE);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        final Car car3 = new Car(CarSize.LARGE);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Matrix should show spots with different car sizes", 
            "Row 0: [LARGE][LARGE][LARGE]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }
} 
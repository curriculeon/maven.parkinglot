package com.github.curriculeon.parkinglot.parkinglot;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingLot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrintStatusTest {
    
    @Test
    public void testPrintEMPTYMatrix() {
        // Given
        final ParkingLot parkingLot = new ParkingLot(2, 3, CarSize.MEDIUM);
        
        // When
        final String status = parkingLot.getStatus();
        
        // Then
        assertEquals("EMPTY parkingLot should show all spots as EMPTY", 
            "Row 0: [EMPTY][EMPTY][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintPartiallyOccupiedMatrix() {
        // Given
        final ParkingLot parkingLot = new ParkingLot(2, 3, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        parkingLot.park(car1);
        parkingLot.park(car2);
        
        // When
        final String status = parkingLot.getStatus();
        
        // Then
        assertEquals("Matrix should show occupied and EMPTY spots correctly", 
            "Row 0: [MEDIUM][MEDIUM][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintFullMatrix() {
        // Given
        final ParkingLot parkingLot = new ParkingLot(2, 2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        final Car car3 = new Car(CarSize.LARGE);
        final Car car4 = new Car(CarSize.SMALL);
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);
        
        // When
        final String status = parkingLot.getStatus();
        
        // Then
        assertEquals("Full parkingLot should show all spots as occupied", 
            "Row 0: [MEDIUM][MEDIUM]\nRow 1: [MEDIUM][EMPTY]",
            status);
    }

    @Test
    public void testPrintMatrixWithDifferentSizes() {
        // Given
        final ParkingLot parkingLot = new ParkingLot(2, 3, CarSize.LARGE);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        final Car car3 = new Car(CarSize.LARGE);
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        
        // When
        final String status = parkingLot.getStatus();
        
        // Then
        assertEquals("Matrix should show spots with different car sizes", 
            "Row 0: [LARGE][LARGE][LARGE]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }
} 